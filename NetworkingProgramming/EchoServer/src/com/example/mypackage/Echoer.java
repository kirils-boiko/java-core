package com.example.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected, running on server's "
                    + currentThread());
            BufferedReader inputFromClient = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter outputToClient = new PrintWriter(socket.getOutputStream(),
                    true);

            while (true) {
                String stringToEcho = inputFromClient.readLine();
                System.out.println("Received client input: " + stringToEcho);
                if (stringToEcho.equals("exit"))
                    break;
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    System.out.println(currentThread() + " was interrupted");
                }
                outputToClient.println("Echo from server " +
                        currentThread() + ": " + stringToEcho);
            }
        } catch (IOException e) {
            System.out.println("IOexception at " + currentThread() + ": " +
                    e.getMessage());
        } finally {
            try {
                System.out.println("Closing the " + currentThread());
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing the socket at " + currentThread());
            }
        }
    }
}
