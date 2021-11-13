package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;

public class RetoAssembler {
	private static RetoAssembler instance;

	public RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}

	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setTitulo(reto.getTitulo());
		dto.setDeporte(reto.getDeporte());
		dto.setObjetivo(reto.getObjetivo());
		
		return dto;
	}
}
