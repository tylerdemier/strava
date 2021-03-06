package es.deusto.ingenieria.sd.auctions.server;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.auctions.server.data.dao.UserDAO;
import es.deusto.ingenieria.sd.auctions.server.data.dao.UserLocalDAO;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.RetoAceptado;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoUsuario;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.domain.UserLocal;
import es.deusto.ingenieria.sd.auctions.server.remote.IRemoteFacade;
import es.deusto.ingenieria.sd.auctions.server.remote.RemoteFacade;


 
public class MainProgram {

	public static void main(String[] args) {	
				
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}		
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
	
		//Inicializar DB
//		initDB();
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Strava Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Strava Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		if (args.length < 2) {
			System.err.println(" # Usage: Trans. SocketClient [SERVER IP] [PORT] ");
			System.exit(1);
		}
	
	}
	
	
	
	private static void initDB() {
		try {
			
			//Entrenamientos
			Entrenamiento entrenamiento1 = new Entrenamiento();
			entrenamiento1.setTitulo("BiciMax");
			entrenamiento1.setDistancia(200);
			entrenamiento1.setFechaIni("11/01/2021");
			entrenamiento1.setDuracion(20);
			entrenamiento1.setHoraIni("12:22");
			entrenamiento1.setDeporte("bici");
			
			Entrenamiento entrenamiento2 = new Entrenamiento();
			entrenamiento2.setTitulo("Maraton");
			entrenamiento2.setDistancia(30);
			entrenamiento2.setFechaIni("12/11/2021");
			entrenamiento2.setDuracion(24);
			entrenamiento2.setHoraIni("14:12");
			entrenamiento2.setDeporte("correr");
			
			Entrenamiento entrenamiento3 = new Entrenamiento();
			entrenamiento3.setTitulo("LllevameEnMiBicicleta");
			entrenamiento3.setDistancia(20);
			entrenamiento3.setFechaIni("11/11/2021");
			entrenamiento3.setDuracion(30);
			entrenamiento3.setHoraIni("11:11");
			entrenamiento3.setDeporte("bici");
			
			Entrenamiento entrenamiento4 = new Entrenamiento();
			entrenamiento4.setTitulo("EncontrarABilllie");
			entrenamiento4.setDistancia(3000);
			entrenamiento4.setFechaIni("12/12/2021");
			entrenamiento4.setDuracion(2);
			entrenamiento4.setHoraIni("10:20");
			entrenamiento4.setDeporte("correr");
			
			Entrenamiento entrenamiento5 = new Entrenamiento();
			entrenamiento5.setTitulo("ET");
			entrenamiento5.setDistancia(2000);
			entrenamiento5.setFechaIni("07/07/2021");
			entrenamiento5.setDuracion(10);
			entrenamiento5.setHoraIni("00:30");
			entrenamiento5.setDeporte("bici");
			
			Entrenamiento entrenamiento6 = new Entrenamiento();
			entrenamiento6.setTitulo("KORRIKA");
			entrenamiento6.setDistancia(10000);
			entrenamiento6.setFechaIni("12/11/2021");
			entrenamiento6.setDuracion(300);
			entrenamiento6.setHoraIni("14:12");
			entrenamiento6.setDeporte("correr");
			
			
			//ListasDeEntrenamientos
			ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
			entrenamientos.add(entrenamiento1);
			entrenamientos.add(entrenamiento2);		
					
			ArrayList<Entrenamiento> entrenamientos2 = new ArrayList<>();
			entrenamientos2.add(entrenamiento3);
			entrenamientos2.add(entrenamiento4);		
			
			ArrayList<Entrenamiento> entrenamientos3 = new ArrayList<>();
			entrenamientos3.add(entrenamiento5);
			entrenamientos3.add(entrenamiento6);	
				
			
			//Usuarios
			UserLocal user0 = new UserLocal();		
			user0.setEmail("thomas@gmail.com");
			user0.setNickname("Thomas");
			user0.setPassword("thomas");
			user0.setAltura(0);
			user0.setPeso(0);
			user0.setFreqcardiacamax(0);
			user0.setFreqcardireposo(0);;
			user0.setRpm(0);
			user0.setTipoUsuario(TipoUsuario.EMAIL);
			user0.setEntrenamientos(entrenamientos);
			List<RetoAceptado> retosAceptados = new ArrayList<RetoAceptado>();
			user0.setRetosAceptados(retosAceptados);
			
			User user1 = new User();		
			user1.setEmail("billlie@gmail.com");
			user1.setNickname("Billlie");
			user1.setAltura(0);
			user1.setPeso(0);
			user1.setFreqcardiacamax(0);
			user1.setFreqcardireposo(0);;
			user1.setRpm(0);
			user1.setEntrenamientos(entrenamientos2);
			List<RetoAceptado> retosAceptados2 = new ArrayList<RetoAceptado>();
			user1.setRetosAceptados(retosAceptados2);
			user1.setTipoUsuario(TipoUsuario.GOOGLE);
			
			User user2 = new User();	
			user2.setEmail("astro@hotmail.com");
			user2.setNickname("Astro");	
			user2.setAltura(0);
			user2.setPeso(0);
			user2.setFreqcardiacamax(0);
			user2.setFreqcardireposo(0);;
			user2.setRpm(0);
			user2.setEntrenamientos(entrenamientos3);
			List<RetoAceptado> retosAceptados3 = new ArrayList<RetoAceptado>();
			user2.setRetosAceptados(retosAceptados3);
			user2.setTipoUsuario(TipoUsuario.FACEBOOK);
					
			UserLocalDAO.getInstance().save(user0);
			UserDAO.getInstance().save(user1);
			UserDAO.getInstance().save(user2);			
			
			
			for (User u : UserDAO.getInstance().getAll()) {
				System.out.println("====" + u.getNickname() + "====");
				if(u.getTipoUsuario().equals(TipoUsuario.EMAIL)) {
					System.out.println(((UserLocal)u).checkPassword("thomas"));
				}
				for (Entrenamiento e : u.getEntrenamientos()) {
					System.out.println(e.getTitulo());
				}
				System.out.println("\n");
			}
			
			
			//Create Retos
			Reto reto1 = new Reto();
			reto1.setTitulo("Pedalear Muchisimo");
			reto1.setDescripcion("?quema tu bici!");
			reto1.setCreador(user1);
			reto1.setFechaInicio("01/01/2021");
			reto1.setFechaFin("31/12/2021");
			reto1.setObjetivo(2800);
			reto1.setDeporte("bici");

			Reto reto2 = new Reto();
			reto2.setTitulo("Correr Muchisimo");
			reto2.setDescripcion("Huye de la policia");
			reto2.setCreador(user0);
			reto2.setFechaInicio("31/10/2021");
			reto2.setFechaFin("31/12/2021");
			reto2.setObjetivo(300);
			reto2.setDeporte("correr");
 
			RetoDAO.getInstance().save(reto1);
			RetoDAO.getInstance().save(reto2);
			
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data base:" + ex.getMessage());
		}		
		
		

		
	}

}