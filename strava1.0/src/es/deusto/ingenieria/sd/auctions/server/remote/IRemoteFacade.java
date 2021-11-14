package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;  
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
//	public ArrayList<EntrenamientoDTO> getEntrenamientosD(String deporte, UserDTO user) throws RemoteException;
	
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
	
	public UserDTO getUser(String email, String contrasenya) throws RemoteException;
	

}