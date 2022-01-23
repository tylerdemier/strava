package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.RetoAceptado;

public class RetoAceptadoAssembler {
	private static RetoAceptadoAssembler instance;

	public RetoAceptadoAssembler() { }
	
	public static RetoAceptadoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAceptadoAssembler();
		}
		return instance;
	}
	
	public RetoAceptadoDTO retoAceptadoToDTO(RetoAceptado reto) {
		RetoAceptadoDTO dto = new RetoAceptadoDTO();
		UserDTO userDTO = new UserDTO();
		userDTO.setNickname(reto.getCreador().getNickname());
		dto.setCreador(userDTO);
		dto.setDeporte(reto.getDeporte());
		dto.setDescripcion(reto.getDescripcion());
		dto.setFechaFin(reto.getFechaFin());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setObjetivo(reto.getObjetivo());
		dto.setTitulo(reto.getTitulo());
		dto.setPorcentajeCompletado(reto.getPorcentaje());
		
		return dto;
	}
}
