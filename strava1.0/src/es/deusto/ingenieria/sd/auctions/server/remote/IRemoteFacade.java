package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;  
import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public ArrayList<Entrenamiento> getEntrenamientos() throws RemoteException;
	
	public ArrayList<Reto> getRetos() throws RemoteException;
	

}