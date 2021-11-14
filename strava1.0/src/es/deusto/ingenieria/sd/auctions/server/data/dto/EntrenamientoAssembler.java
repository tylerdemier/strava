package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class EntrenamientoAssembler {
	private static EntrenamientoAssembler instance;

	public EntrenamientoAssembler() { }
	
	public static EntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new EntrenamientoAssembler();
		}

		return instance;
	}

	public EntrenamientoDTO entrenamientoToDTO(Entrenamiento entrenamiento) {
		EntrenamientoDTO dto = new EntrenamientoDTO();
		
		dto.setTitulo(entrenamiento.getTitulo());
		dto.setDeporte(entrenamiento.getDeporte());
		dto.setDistancia(entrenamiento.getDistancia());
		dto.setDuracion(entrenamiento.getDuracion());
		dto.setFechaIni(entrenamiento.getFechaIni());
		dto.setHoraIni(entrenamiento.getHoraIni());
		
		return dto;
	}
}
