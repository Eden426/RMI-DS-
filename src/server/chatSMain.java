package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class chatSMain {

	public static void main(String[] args)throws RemoteException,MalformedURLException {
	 try {
        Naming.rebind("RMIChatServer", new clientServer());
        System.out.println("Chat server is ready.");
    } catch (RemoteException | MalformedURLException e) {
        System.err.println("Server exception: " + e.getMessage());
        e.printStackTrace();
    }

}}
