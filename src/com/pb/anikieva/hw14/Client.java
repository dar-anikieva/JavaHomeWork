package com.pb.anikieva.hw14;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;


class Client1 {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private BufferedReader inputUser;
    private String addr;
    private int port;
    private static LocalDateTime ldt = LocalDateTime.now();


    public Client1(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {

            Client1.this.downService();
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }


    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str="first";
            try {
                while (true) {
                    str = in.readLine();
                    if (str.equals("stop")) {
                        Client1.this.downService();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                Client1.this.downService();
            }
        }
    }


    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {

                    userWord = inputUser.readLine();
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        Client1.this.downService();
                        break;
                    } else {
                        out.write( ldt.toString()+":"+userWord + "\n");
                    }
                    out.flush();
                } catch (IOException e) {
                    Client1.this.downService();

                }

            }
        }
    }
}

public class Client {

    public static String ipAddr = "192.0.0.1";
    public static int port = 1234;

    public static void main(String[] args) {
        new Client1(ipAddr, port);
    }

}
