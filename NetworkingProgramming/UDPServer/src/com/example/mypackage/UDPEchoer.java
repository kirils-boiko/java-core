package com.example.mypackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.regex.Pattern;

public class UDPEchoer extends Thread {

    private DatagramSocket datagramSocket;
    private DatagramPacket inputPacket;
    private byte[] inputBuffer;

    public UDPEchoer(DatagramSocket datagramSocket, DatagramPacket inputPacket, byte[] inputBuffer) {
        this.datagramSocket = datagramSocket;
        this.inputPacket = inputPacket;
        this.inputBuffer = inputBuffer;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread() + ": Received: " + new String(inputBuffer, 0,
                    inputPacket.getLength()));

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                System.out.println(currentThread() + " was interrupted: " + e.getMessage());
            }

            String response = "echo: " + new String(inputBuffer, 0, inputPacket.getLength());
            byte[] outputBuffer = response.getBytes();
            DatagramPacket outputPacket = new DatagramPacket(outputBuffer, outputBuffer.length,
                    inputPacket.getAddress(), inputPacket.getPort());
            datagramSocket.send(outputPacket);


        } catch (IOException e) {
            System.out.println(currentThread() + ": IOException: "
                    + e.getMessage());
        }
    }
}
