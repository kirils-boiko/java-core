package com.example.mypackage;

import java.io.IOException;
import java.net.*;
import java.util.Set;

// Multi-threaded implementation of the UDP Echo Server

public class Main {

    public static void main(String[] args) {
	    try (DatagramSocket datagramSocket = new DatagramSocket(5000)) {
            while (true) {
                byte[] inputBuffer = new byte[50];
                DatagramPacket datagramPacket = new DatagramPacket(inputBuffer, inputBuffer.length);
                datagramSocket.receive(datagramPacket);
                new UDPEchoer(datagramSocket, datagramPacket, inputBuffer).start();
                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                System.out.println("Currently active threads: " + threadSet.size());
            }

        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}


//            DatagramSocket socket = new DatagramSocket(5000);
//
//            while (true) {
//                byte[] buffer = new byte[50];
//                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                socket.receive(packet);     // no end-to-end connection between client and server
//                System.out.println("Bytes received is: " + new String(buffer));
//                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));
//
//                String response = "echo: " + new String(buffer, 0, packet.getLength());
//                byte[] responseBuffer = response.getBytes();
//                DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length,
//                        packet.getAddress(), packet.getPort());
//                socket.send(responsePacket);
//            }