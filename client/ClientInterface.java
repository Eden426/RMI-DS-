package client;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface ClientInterface extends Remote{
	void Message1(String message) throws RemoteException;
	void registerchatclient(ClientInterface client) throws RemoteException;
	void broadcastmessage(String string) throws RemoteException;

    default void defaultMessage() {
    	System.out.println("Welcome to the chat!!");

    }

}
