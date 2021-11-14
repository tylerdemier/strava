package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

//This class is part of the DTO pattern. It also implements Singleton Pattern.
public class UserAssembler {
	private static UserAssembler instance;

	public UserAssembler() { }
	
	public static UserAssembler getInstance() {
		if (instance == null) {
			instance = new UserAssembler();
		}

		return instance;
	}

	public UserDTO userToDTO(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setNickname(user.getNickname());
		List<EntrenamientoDTO> listaEntreno = new ArrayList<>();
		for (Entrenamiento entrenamiento : user.getEntrenamientos()) {
			EntrenamientoDTO eDTO = new EntrenamientoDTO();
			eDTO.setTitulo(entrenamiento.getTitulo());
			eDTO.setDeporte(entrenamiento.getDeporte());
			eDTO.setDistancia(entrenamiento.getDistancia());
			eDTO.setDuracion(entrenamiento.getDuracion());
			eDTO.setHoraIni(entrenamiento.getHoraIni());
			eDTO.setFechaIni(entrenamiento.getFechaIni());
			listaEntreno.add(eDTO);
		}
		
		dto.setEntrenamientos(listaEntreno);
		
		
		List<RetoDTO> listaretos = new ArrayList<>();
		for (Reto reto : user.getRetosAceptados()) {
			RetoDTO rDTO = new RetoDTO();
			rDTO.setTitulo(reto.getTitulo());
			rDTO.setDeporte(reto.getDeporte());
			rDTO.setObjetivo(reto.getObjetivo());
			rDTO.setCreador(dto);
			rDTO.setFechaFin(reto.getFechaFin());
			rDTO.setFechaInicio(reto.getFechaInicio());
			listaretos.add(rDTO);
		}
		
		dto.setRetosAceptados(listaretos);
		
		return dto;
	}
}