package es.deusto.ingenieria.sd.auctions.server.test;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import es.deusto.ingenieria.sd.auctions.server.remote.RemoteFacade;

public class LocalTest {

	public static void main(String[] args) {		
		RemoteFacade facade = null;
		List<EntrenamientoDTO> entrenamientos = null;
		EntrenamientoDTO entrenamiento = null;
		List<RetoDTO> retos = null;
		RetoDTO reto = null;
		long token = 0l;
		
		try {
			facade = new RemoteFacade();
			
			User user = new User();		
			user.setEmail("thomas.e2001@gmail.com");
			user.setNickname("Thomas");	
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
			user.setPassword(sha1);
			
			Entrenamiento entrenamiento1 = new Entrenamiento();
			entrenamiento1.setTitulo("BiciMax");
			entrenamiento1.setDistancia(20);
			entrenamiento1.setFechaIni("28:10:2021");
			entrenamiento1.setDuracion(20);
			entrenamiento1.setHoraIni(12);
			entrenamiento1.setDeporte("bici");
			
			
			ArrayList<Entrenamiento> entrenamientosAA = new ArrayList<>();
			entrenamientosAA.add(entrenamiento1);

			user.setEntrenamientos(entrenamientosAA);
			
			entrenamiento = entrenamientos.get(0);
			
			for (EntrenamientoDTO e : entrenamientos) {
				System.out.println("\t- " + e);
			}			
						
			retos = facade.getRetos("correr");
			reto = retos.get(0);
			
			for (RetoDTO r : retos) {
				System.out.println("\t- " + r);
			}
								
		} catch (Exception e) {			
			System.out.println("\t# Error: " + e.getMessage());
		} 
		
		try {
			//Login
			String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");
			token = facade.login("thomas.e2001@gmail.com", sha1, "Thomas");	
			//Logout
			facade.logout(token);

			retos = facade.getRetos(reto.getDeporte());
			reto = retos.get(0); 			
			System.out.println("\t- " + reto);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}