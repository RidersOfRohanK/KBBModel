package Drivers;

import Client.DefaultSocketClient;

public class Driver5 {
    public static void main(String[] args) {
        DefaultSocketClient socketClient = new DefaultSocketClient("localhost", 8080);
        socketClient.run();
    }
}
