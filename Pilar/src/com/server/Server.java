package com.server;

import com.Game;
import com.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private static Logger log = LoggerFactory.getLogger("ThreadedServer");
    private static final int MAX_CLIENTS = 10;
    private static final int PORT = 19000;
    private static int counter = 0;

    private Game game = new Game();
    private List<ClientHandler> handlers = new ArrayList<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }

    public void startServer() {
        log.info("Starting server...");
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                if (game.isStarted() || handlers.size() == MAX_CLIENTS) {
                    break;
                }
                log.info("Client connected: " + socket.getInetAddress().toString() + ":" + socket.getPort());
                ClientHandler handler = new ClientHandler(socket, counter++);
                handlers.add(handler);
                handler.start();
            }
        } catch (IOException e) {
            log.error("Failed to create ServerSocket.", e);
        }
    }


    class ClientHandler extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private int number;
        private Player player;
        private boolean isReady;

        public ClientHandler(Socket socket, int counter) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream());
                number = counter;
            } catch (IOException e) {
                log.error("Failed to create ClientHandler object", e);
                Util.closeResource(in);
                Util.closeResource(out);
            }
        }


        public void send(String message) {
            out.println(message);
            out.flush();
        }

        @Override
        public void run() {
            try {
                Pattern patternLogin = Pattern.compile("^login:.+");
                String line;
                Outer: while ((line = in.readLine()) != null) {
                    if (!game.isStarted()) {
                        Matcher matcherLogin = patternLogin.matcher(line);
                        if (matcherLogin.matches()) {
                            if (player != null) {
                                log.info("Repeated login attempt.");
                                send("You have already logged in.");
                                continue;
                            }
                            String name = line.substring(6).trim();
                            for (ClientHandler i : handlers) {
                                if (i.player != null && name.equals(i.player.getName())) {
                                    log.info("Player with that name already exists.");
                                    send("Player with that name already exists.\nTry another one.");
                                    continue Outer;
                                }
                            }
                            player = new Player(name);
                            game.addPlayer(player);
                            log.info("New player registered. Name: {}", name);
                            send("Successful connection to the game.\nYour nickname is " + name);
                        } else if (line.equals("help")) {
                            log.info("Help request.");
                            send("Operations:\n" +
                                    "help - get the list of operations\n" +
                                    "login:name - log in with name\n" +
                                    "ready - mark yourself as ready to play\n" +
                                    "start - start the game");
                        } else if (player == null) {
                            log.info("Non logged in client attempt.");
                            send("Please, log in first.\n" +
                                    "Operations:\n" +
                                    "help - get the list of operations\n" +
                                    "login:name - log in with name\n" +
                                    "ready - mark yourself as ready to play\n" +
                                    "start - start the game");
                        } else if (line.equals("ready")) {
                            log.info("Player {} is ready to start.", player.getName());
                            isReady = true;
                        } else if (line.equals("start")) {
                            if (handlers.size() < 2) {
                                log.info("Single player attempt to start");
                                send("You need more players to start.");
                                continue;
                            }
                            for (ClientHandler i : handlers) {
                                if (i.player == null) {
                                    log.info("Attempt to start with non logged in players.");
                                    send("Please wait for other players to log in.");
                                    continue Outer;
                                }
                            }
                            for (ClientHandler i : handlers) {
                                if (!i.isReady) {
                                    log.info("Attempt to start with not ready players.");
                                    send("Please wait for other players to get ready.");
                                    continue Outer;
                                }
                            }
                            game.setStarted(true);
                            log.info("Game has started.");
                            for (ClientHandler i : handlers) {
                                i.send("Game has started.");
                            }
                        } else {
                            log.info("Unknown operation request.");
                            send("Unknown operation request.\nType \"help\" to see the list of operations.");
                        }
                    } else {

                    }
                }
            } catch (IOException e) {
                log.error("Failed to read from socket", e);
            } finally {
                log.info("Client disconnected: " + "Client #" + number);
                handlers.remove(this);
                Util.closeResource(in);
                Util.closeResource(out);
            }
        }
    }
}