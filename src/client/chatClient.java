package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import server.ChatSIF;

public class chatClient extends UnicastRemoteObject implements ClientInterface, Runnable {
    private static final long serialVersionUID = 1L;
    private ChatSIF chat;
    private String name;

    // Constructor to initialize the client with the server and name
    public chatClient(String name, ChatSIF chat) throws RemoteException {
        this.name = name;
        this.chat = chat;
        chat.registerchatclient(this); // Register this client with the server
    }

    @Override
    public void Message1(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void registerchatclient(ClientInterface client) throws RemoteException {}

    @Override
    public void broadcastmessage(String string) throws RemoteException {}

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        String message;
        while (true) {
            message = scan.nextLine();
            try {
                chat.broadcastMessage(name + ": " + message);
            } catch (RemoteException e) {
                System.err.println("Error broadcasting message: " + e.getMessage());
            }
        }
    }
}