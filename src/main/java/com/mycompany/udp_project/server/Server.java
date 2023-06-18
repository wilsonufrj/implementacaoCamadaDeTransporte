package com.mycompany.udp_project.server;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author wilson
 */
public class Server {

    public static void main(String[] args) throws SocketException, IOException {

        UDPServer server = new UDPServer();
        server.startServer();
    }
}

