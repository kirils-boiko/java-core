package com.example.mypackage;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try {
            // get the address of the host where server is running
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String message;

            do {
                System.out.println("Enter string to be sent to server in UDP:");
                message = scanner.nextLine();

                // convert the data to send in bytes
                byte[] buffer = message.getBytes();

                // create the packet to send through
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);

                // receive the response packet
                byte[] responseBuffer = new byte[50];
                packet = new DatagramPacket(responseBuffer, responseBuffer.length);
                socket.receive(packet);
                System.out.println(new String(responseBuffer, 0, packet.getLength()));

            } while (!message.equals("exit"));

        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client IOException: " + e.getMessage());
        }
    }
}
