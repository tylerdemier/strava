package es.deusto.ingenieria.sd.auctions.server.remote;

import java.rmi.Remote;   
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.auctions.server.services.ErAppService;


//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
		
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
	
	public UserDTO getCheckedUsuario(String email, String password) throws RemoteException;
			
	public float calcularEstado(RetoAceptadoDTO reto, UserDTO user) throws RemoteException;
	
	public List<EntrenamientoDTO> crearEntrenamiento(UserDTO usuarioDTO, String deporte, String titulo, String fechaIni, int distancia, String horaIni, int duracion)  throws RemoteException;
	
	public void crearReto(UserDTO user, String deporte, String titulo, String descripcion, String fechaIni, String fechaFin, int objetivo)  throws RemoteException;
	
	public void crearUsuario(TipoUsuarioDTO tipo, String email, String nickname, String password, int alt, int fcm, int fcr, int peso, int rpm)  throws RemoteException;
	
	public UserDTO actualizarUser(UserDTO u) throws RemoteException;
}