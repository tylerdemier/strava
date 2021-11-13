package es.deusto.ingenieria.sd.auctions.server.test;

import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
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
			
			entrenamientos = facade.getEntrenamientos("bici");
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
			token = facade.login("thomas.e2001@gmail.com", sha1);			
			//Logout
			facade.logout(token);

			retos = facade.getRetos(reto.getTitulo());
			reto = retos.get(0); 			
			System.out.println("\t- " + reto);
		} catch (Exception e) {
			System.out.println("\t# Error: " + e.getMessage());	
		}

		//Force exit to stop RMI Server
		System.exit(0);
	}
}