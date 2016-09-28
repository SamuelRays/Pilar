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
        Thread replyThread;

        public ConsoleThread(Socket socket) throws IOException {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            replyThread = new Thread() {
                @Override
                public void run() {
                    try {
                        String line;
                        while ((line = in.readLine()) != null) {
                            StringBuilder answer = new StringBuilder(line);
                            answer.append("\n");
                            while (in.ready()) {
                                answer.append(in.readLine());
                                answer.append("\n");
                            }
                            log.info(answer.toString());
                        }
                    } catch (Exception e) {
                        log.error("Failed to receive message from server.", e);
                    } finally {
                        Util.closeResource(in);
                    }
                }
            };
            replyThread.start();
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = console.readLine()) != null) {
                    out.println(line);
                    out.flush();
                }
            } catch (Exception e) {
                log.error("Failed to send message to server.", e);
            } finally {
                Util.closeResource(console);
                Util.closeResource(out);
            }
        }
    }
}