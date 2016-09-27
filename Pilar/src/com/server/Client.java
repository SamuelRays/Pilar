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
        try {
            socket = new Socket(HOST, PORT);
            ConsoleThread console = new ConsoleThread(socket);
            console.start();
            console.join();
        } catch (IOException | InterruptedException e) {
            log.error("Failed to read from socket", e);
        } finally {
            Util.closeResource(socket);
        }
    }

    class ConsoleThread extends Thread {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out;
        BufferedReader in;

        public ConsoleThread(Socket socket) throws IOException {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = console.readLine()) != null) {
                    out.println(line);
                    out.flush();
                    while (in.ready()) {
                        System.out.println(in.readLine());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Util.closeResource(console);
                Util.closeResource(out);
                Util.closeResource(in);
            }
        }
    }
}