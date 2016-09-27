package com.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Logger log = LoggerFactory.getLogger(Client.class);
    public static final int PORT = 19000;
    public static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.startClient();
    }

    public void startClient() {
        Socket socket = null;
        BufferedReader in = null;
        try {
            socket = new Socket(HOST, PORT);
            ConsoleThread console = new ConsoleThread(socket);
            console.start();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            log.error("Failed to read from socket", e);
        } finally {
            Util.closeResource(in);
            Util.closeResource(socket);
        }
    }

    class ConsoleThread extends Thread {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out;

        public ConsoleThread(Socket socket) throws IOException {
            out = new PrintWriter(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = console.readLine()) != null) {
                    //TODO
                    out.println(line);
                    out.flush();
                    log.info("Player requests %s operation", line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Util.closeResource(out);
                Util.closeResource(console);
            }
        }
    }
}