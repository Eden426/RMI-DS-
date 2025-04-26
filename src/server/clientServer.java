package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import client.ClientInterface;



public class clientServer extends UnicastRemoteObject implements ChatSIF {
	private static final long serialversionUID = 1L;
	private ArrayList<ClientInterface>chatClients;

	protected clientServer() throws RemoteException {
        chatClients = new ArrayList<>();
	}

	@Override
    public synchronized void registerchatclient(ClientInterface client)
            throws RemoteException{
        this.chatClients.add(client); 
        System.out.println("New client has enterd the chat");
    }
    public synchronized void broadcastMessage(String message) throws RemoteException{
    	 for (ClientInterface client : chatClients) {
             try {
                 client.Message1(message);
             } catch (RemoteException e) {
                 System.err.println("Error sending message to client: " + e.getMessage());
             }
         }
     }
 }

   

