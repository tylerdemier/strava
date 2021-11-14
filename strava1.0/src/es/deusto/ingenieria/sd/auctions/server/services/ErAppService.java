package es.deusto.ingenieria.sd.auctions.server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//TODO: Implement Singleton Pattern
public class ErAppService {
	
	private List<Reto> retos = new ArrayList<>();
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private RetoAssembler assemblerReto = new RetoAssembler();
	
	public ErAppService() {
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
		reto1.setTitulo("Pedalear Muchisimo");
		reto1.setDescripcion("¡quema tu bici!");
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
		
		retos.add(reto1);
		retos.add(reto2);
		
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

	public List<Reto> getRetosNormales() {
		return retos;
	}

	public void anyadirRetoARetos(RetoDTO reto, UserDTO user) {
		Reto r = new Reto();
		User u = new User();
		u.setNickname(user.getNickname());
		r.setCreador(u);
		r.setDeporte(reto.getDeporte());
		r.setDescripcion(reto.getDescripcion());
		r.setFechaInicio(reto.getFechaInicio());
		r.setFechaFin(r.getFechaFin());
		r.setObjetivo(reto.getObjetivo());
		r.setTitulo(reto.getTitulo());
		
		this.retos.add(r);
			
			
		}
	
	public void quitarRetoARetos(String tituloReto) {
		
		List<Reto> retosNuevos = new ArrayList<>();
		for (Reto reto : this.retos) {
			if(!reto.getTitulo().matches(tituloReto)) {
				retosNuevos.add(reto);
			}
		}
		
		this.retos = retosNuevos;			
		}
	
	
	
	
	}
