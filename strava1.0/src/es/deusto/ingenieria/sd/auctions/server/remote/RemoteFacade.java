package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.RemoteException;   
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.auctions.server.services.ErAppService;
import es.deusto.ingenieria.sd.auctions.server.services.LoginAppService;
 
public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, User> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private ErAppService bidService = new ErAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuario) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password);
			
		User user  = loginService.login(email, password, nickname, tipoUsuario);
		
		if (user != null) {

			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}


	@Override
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException {
		ArrayList<RetoDTO> a = bidService.getRetos(deporte);
		return a;
	}

	@Override
	public void anyadirRetoARetos(RetoDTO reto, UserDTO user) throws RemoteException {
		bidService.anyadirRetoARetos(reto, user);		
	}

	@Override
	public void quitarRetoARetos(String tituloReto) throws RemoteException {
		bidService.quitarRetoARetos(tituloReto);
		
	}

	@Override
	public float calcularEstado(RetoAceptadoDTO reto, UserDTO user) throws RemoteException {
		return bidService.calcularEstado(reto, user);
	}

	@Override
	public UserDTO getCheckedUsuario(String email, String password) throws RemoteException {
		return loginService.getCheckedUsuario(email, password);
	}

	
	
}

