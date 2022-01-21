package es.deusto.ingenieria.sd.auctions.server.data.dto;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;

public class RetoAceptadoAssembler {
	private static RetoAceptadoAssembler instance;

	public RetoAceptadoAssembler() { }
	
	public static RetoAceptadoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAceptadoAssembler();
		}
		return instance;
	}
	
	public RetoAceptadoDTO RetoAceptadoToDTO(Reto reto, UserDTO usuarioAceptador) {
		RetoAceptadoDTO dto = new RetoAceptadoDTO();
		
		UserDTO uDTO = new UserDTO();
		uDTO.setEmail(reto.getCreador().getEmail());
		uDTO.setNickname(reto.getCreador().getNickname());
		
		dto.setCreador(uDTO);
		dto.setDeporte(reto.getDeporte());
		dto.setDescripcion(reto.getDescripcion());
		dto.setFechaFin(reto.getFechaFin());
		dto.setFechaInicio(reto.getFechaInicio());
		dto.setObjetivo(reto.getObjetivo());
		dto.setTitulo(reto.getTitulo());
		dto.setPorcentajeCompletado(0);
		
		return dto;
	}
}
