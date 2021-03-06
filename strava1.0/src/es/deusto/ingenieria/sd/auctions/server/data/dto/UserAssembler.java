package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.util.ArrayList; 
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoUsuario;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.services.ErAppService;

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

	public UserDTO userToDTO(User user, ErAppService er) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setNickname(user.getNickname());
		System.out.println("*AQUI 0*");		
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

		System.out.println("*AQUI 1*");	
		List<RetoAceptadoDTO> listaretos = new ArrayList<>();
		for (Reto reto : user.getRetosAceptados()) {
			RetoAceptadoDTO rDTO = new RetoAceptadoDTO();
			rDTO.setTitulo(reto.getTitulo());
			rDTO.setDescripcion(reto.getDescripcion());
			rDTO.setDeporte(reto.getDeporte());
			rDTO.setObjetivo(reto.getObjetivo());
			rDTO.setCreador(dto);
			rDTO.setFechaFin(reto.getFechaFin());
			rDTO.setFechaInicio(reto.getFechaInicio());
			rDTO.setPorcentajeCompletado(er.calcularEstado(rDTO, dto));
			listaretos.add(rDTO);
		}
		
		dto.setRetosAceptados(listaretos);
		System.out.println("*AQUI 2*");	
		System.out.println("Info: ");
		System.out.print(user.getNickname());
		if(user.getTipoUsuario().equals(TipoUsuario.GOOGLE)) {
			dto.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
		} else if(user.getTipoUsuario().equals(TipoUsuario.EMAIL)) {
			dto.setTipoUsuario(TipoUsuarioDTO.EMAIL);
		} else if(user.getTipoUsuario().equals(TipoUsuario.FACEBOOK)) {
			dto.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
		}
		
		System.out.println("*AQUI 3*");	
		return dto;
	}
}