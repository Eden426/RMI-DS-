package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ClientInterface;


public interface ChatSIF extends Remote {
	 void registerchatclient(ClientInterface  Chat) throws RemoteException;
	 void broadcastMessage(String message) throws RemoteException;

}
