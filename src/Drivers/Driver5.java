package Drivers;

import Client.DefaultSocketClient;

public class Driver5 {
    public static void main(String[] args) {
        DefaultSocketClient socketClient = new DefaultSocketClient("localhost", 9000);
        socketClient.run();
    }
}
