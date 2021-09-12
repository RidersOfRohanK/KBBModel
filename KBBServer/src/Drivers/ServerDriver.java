package Drivers;

import Server.DefaultServerSocket;

public class ServerDriver {
    public static void main(String[] args) {
        DefaultServerSocket server = new DefaultServerSocket(8080);
        server.run();
    }
}
