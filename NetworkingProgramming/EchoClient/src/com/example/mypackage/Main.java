package com.example.mypackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try (Socket socket = new Socket("localhost", 5000)) {

            socket.setSoTimeout(5000);

            BufferedReader inputFromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String messageToServer;
            String responseFromServer;

            do {
                System.out.println("Enter string to be echoed:");
                messageToServer = scanner.nextLine();

                outputToServer.println(messageToServer);
                if (!messageToServer.equals("exit")) {
                    responseFromServer = inputFromServer.readLine();
                    System.out.println(responseFromServer);
                }

            } while (!messageToServer.equals("exit"));


        } catch (SocketTimeoutException e) {
            System.out.println("the socket timed out");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
