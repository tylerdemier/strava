package es.deusto.ingenieria.sd.auctions.server.services;

import java.util.ArrayList;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	
	public User login(String email, String password) {

		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");		

		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);

		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
	}
	


	public UserDTO getUser(String email, String password) {
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");	
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);
		
		//Create Entrenamiento				
		Entrenamiento entrenamiento1 = new Entrenamiento();
		entrenamiento1.setTitulo("BiciMax");
		entrenamiento1.setDistancia(20);
		entrenamiento1.setFechaIni("28:10:2021");
		entrenamiento1.setDuracion(20);
		entrenamiento1.setHoraIni(12);
		entrenamiento1.setDeporte("bici");
		
		Entrenamiento entrenamiento2 = new Entrenamiento();
		entrenamiento2.setTitulo("Maraton");
		entrenamiento2.setDistancia(30);
		entrenamiento2.setFechaIni("07:07:2019");
		entrenamiento2.setDuracion(99);
		entrenamiento2.setHoraIni(32);
		entrenamiento2.setDeporte("correr");
		
		ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
		entrenamientos.add(entrenamiento2);
		entrenamientos.add(entrenamiento1);
		ArrayList<Entrenamiento> entrenamientos2 = new ArrayList<>();
		entrenamientos2.add(entrenamiento2);

		user.setEntrenamientos(entrenamientos);
	
		
		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return assamblerUser.userToDTO(user);
		} else {
			return null;
		}


	}

}