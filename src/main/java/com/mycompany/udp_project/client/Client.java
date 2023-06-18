package com.mycompany.udp_project.client;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author wilson
 */
public class Client {
    
  public static void main(String[] args) throws SocketException, IOException {

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress clientAddress = InetAddress.getByName("localhost");
        byte[] buffer = new byte[256];

        String message = "Mensagem enviada para o servidor";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, clientAddress, 12000);
        clientSocket.send(packet);
        
        packet = new DatagramPacket(buffer,buffer.length);
        clientSocket.receive(packet);
        
        String response = new String(packet.getData(),0,packet.getLength());
        System.out.println(response);
        clientSocket.close();
    }
    
    
}
