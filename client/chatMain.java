package client;

import java.rmi.Naming;

import server.ChatSIF;

public class chatMain {
    public static void main(String[] args) {
        try {
            String chatURL = "rmi://localhost/RMIChatServer";
            ChatSIF chat = (ChatSIF) Naming.lookup(chatURL);
            new Thread(new chatClient(args[0], chat)).start();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
