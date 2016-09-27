package com.server;

import com.Game;
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
            ClientHandler handler = new ClientHandler(this, socket, counter++);
            handlers.add(handler);
            handler.start();
        }
    }


    class ClientHandler extends Thread {

        private Server server;
        private BufferedReader in;
        private PrintWriter out;

        private int number;
        private String login;

        public ClientHandler(Server server, Socket socket, int counter) throws Exception {
            this.server = server;
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
                String line = null;
                while ((line = in.readLine()) != null) {
                    //TODO
                }
            } catch (IOException e) {
                log.error("Failed to read from socket", e);
            } finally {
                log.info("Client disconnected: " + (login == null ? "Client #" + number : login));
                handlers.remove(this);
                Util.closeResource(in);
                Util.closeResource(out);
            }
        }
    }
}