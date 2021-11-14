package es.deusto.ingenieria.sd.auctions.server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;

//TODO: Implement Singleton Pattern
public class BidAppService {
	
	private List<Reto> retos = new ArrayList<>();
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private RetoAssembler assemblerReto = new RetoAssembler();
	
	public BidAppService() {
		this.initilizeData();
	}
	
	private void initilizeData() {
		//Create Users
		User user0 = new User();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNickname("Thomas");
		user0.setPassword("$!9PhNz,");
		
		User user1 = new User();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");		
		user1.setPassword("hqc`}3Hb");
								
		//Create Reto
		Reto reto1 = new Reto();
		reto1.setTitulo("pedalear Muchisimo");
		reto1.setDescripcion("El cardio es bueno amigo mio");
		reto1.setCreador(user1);
		reto1.setFechaInicio("28:10:2021");
		reto1.setFechaFin("28:10:2021");
		reto1.setObjetivo(9000);
		reto1.setDeporte("bici");
		
		Reto reto2 = new Reto();
		reto2.setTitulo("Correr Muchisimo");
		reto2.setDescripcion("Huye de la policia");
		reto2.setCreador(user0);
		reto2.setFechaInicio("29:10:2020");
		reto2.setFechaFin("01:04:2021");
		reto2.setObjetivo(3);
		reto2.setDeporte("correr");
		
		retos.add(reto1);
		retos.add(reto2);
		
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
		entrenamiento2.setFechaIni("28:10:2021");
		entrenamiento2.setDuracion(90);
		entrenamiento2.setHoraIni(22);
		entrenamiento2.setDeporte("correr");
		
		entrenamientos.add(entrenamiento2);
		entrenamientos.add(entrenamiento1);
		
		user1.getEntrenamientos().add(entrenamiento1);
		user1.getRetosAceptados().add(reto2);
		user0.getRetosAceptados().add(reto1);
		user0.getEntrenamientos().add(entrenamiento2);
				
	}
	
	
	public ArrayList<RetoDTO> getRetos(String deporte) {
		ArrayList<RetoDTO> retosArray = new ArrayList<>();
		for (Reto r : this.retos) {
			if (r.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerReto.getInstance();
				RetoDTO dto = assemblerReto.retoToDTO(r);
				retosArray.add(dto);
			}
		}	
		return retosArray;
	}
	
	public ArrayList<EntrenamientoDTO> getEntrenamientos(String deporte) {
		ArrayList<EntrenamientoDTO> entrenamientosArray = new ArrayList<>();
		for (Entrenamiento e : this.entrenamientos) {
			if (e.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerEntrenamiento.getInstance();
				EntrenamientoDTO dto = assemblerEntrenamiento.entrenamientoToDTO(e);
				entrenamientosArray.add(dto);
			}
		}	
		return entrenamientosArray;
	}
	
	
}