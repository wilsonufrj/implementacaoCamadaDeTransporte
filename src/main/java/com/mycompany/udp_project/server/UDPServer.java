package com.mycompany.udp_project.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author wilson
 */
public class UDPServer {
     
    DatagramSocket serverSocket;
    byte[] buffer = new byte[256];
    DatagramPacket datagram;

    public UDPServer() {
        inicializeSocket();
    }

    public void startServer() {
       System.out.println("Server was started...");
        while (true) {
            getRequest();
            treatmentRequest();
            sendResponse();
            cleanVariables();
        }
    }

    private void inicializeSocket() {
        try {
            this.serverSocket = new DatagramSocket(12000);
        } catch (SocketException e) {
           System.out.println(e.getMessage());
        }
    }

    private void getRequest() {
        try {
            this.datagram = new DatagramPacket(buffer, buffer.length);
            this.serverSocket.receive(datagram);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void treatmentRequest() {
        String request = new String(this.datagram.getData(), 0, this.datagram.getLength());
        this.buffer = request.toUpperCase().getBytes();
    }

    private void sendResponse() {
        try{
            this.datagram = new DatagramPacket(this.buffer,this.buffer.length,this.datagram.getSocketAddress());
            this.serverSocket.send(this.datagram);
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }
    }
    
    private void cleanVariables(){
        this.buffer = new byte[256];
        this.datagram = null;
    }

}
