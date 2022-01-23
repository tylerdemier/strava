package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento; 
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.services.ErAppService;

public class RetoAssembler {
	private static RetoAssembler instance;

	public RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}

	public RetoDTO retoToDTO(Reto reto, ErAppService er) {
		RetoDTO dto = new RetoDTO();
		
		dto.setTitulo(reto.getTitulo());
		dto.setDeporte(reto.getDeporte());
		dto.setObjetivo(reto.getObjetivo());
		
		UserAssembler uA = new UserAssembler();
		dto.setCreador(uA.userToDTO(reto.getCreador(), er));
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setFechaFin(reto.getFechaFin());
		dto.setDescripcion(reto.getDescripcion());
		
		return dto;
	}
}
