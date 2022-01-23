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
	private ErAppService erService = new ErAppService();

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
		ArrayList<RetoDTO> a = erService.getRetos(deporte);
		return a;
	}

	@Override
	public float calcularEstado(RetoDTO reto, UserDTO user) throws RemoteException {
		return erService.calcularEstado(reto, user);
	}

	@Override
	public UserDTO getCheckedUsuario(String email, String password) throws RemoteException {
		return loginService.getCheckedUsuario(email, password);
	}

	@Override
	public List<EntrenamientoDTO> crearEntrenamiento(UserDTO usuarioDTO, String deporte, String titulo, String fechaIni, int distancia,
			String horaIni, int duracion) {
		return erService.crearEntrenamiento(usuarioDTO, deporte, titulo, fechaIni, distancia, horaIni, duracion);
		
	}

	@Override
	public void crearReto(UserDTO user, String deporte, String titulo, String descripcion, String fechaIni,
			String fechaFin, int objetivo) {
		erService.crearReto(user, deporte, titulo, descripcion, fechaIni, fechaFin, objetivo);
		
	}

	@Override
	public void crearUsuario(TipoUsuarioDTO tipo, String email, String nickname, String password, int alt, int fcm, int fcr, int peso,
			int rpm) {
		loginService.crearUsuario(tipo, email, nickname, password, alt, fcm, fcr, peso, rpm);
		
	}

	@Override
	public UserDTO actualizarUser(UserDTO u) throws RemoteException {
		return loginService.actualizarUser(u, erService);
	}

	@Override
	public UserDTO aceptarReto(UserDTO userDTO, RetoDTO retoAAceptar) throws RemoteException {
		return erService.aceptarReto(userDTO, retoAAceptar, erService);
	}

	
	
}

