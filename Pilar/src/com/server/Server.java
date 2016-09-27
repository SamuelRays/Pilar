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
    private static final int PORT = 19000;
    private static int counter = 0;

    private Game game = new Game();
    private List<ClientHandler> handlers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.startServer();
    }

    public void startServer() throws Exception {
        log.info("Starting server...");
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            log.info("Client connected: " + socket.getInetAddress().toString() + ":" + socket.getPort());
            ClientHandler handler = new ClientHandler(socket, counter++);
            handlers.add(handler);
            handler.start();
        }
    }


    class ClientHandler extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private int number;
        private Player player;

        public ClientHandler(Socket socket, int counter) throws Exception {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            number = counter;
        }


        public void send(String message) {
            out.println(message);
            out.flush();
        }

        @Override
        public void run() {
            try {
                Pattern patternLogin = Pattern.compile("^login:.+");
                String line = null;
                while ((line = in.readLine()) != null) {
                    Matcher matcherLogin = patternLogin.matcher(line);
                    if (matcherLogin.matches()) {
                        String name = line.substring(6).trim();
                        player = new Player(name);
                        game.addPlayer(player);
                        log.info("New player registered. Name: {}", name);
                        send("You connected to the game.\nYour nickname is " + name);
                    } else {
                        log.info("Unknown operation request.");
                        send("Unknown operation request.\nChoose one of the followings:");
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