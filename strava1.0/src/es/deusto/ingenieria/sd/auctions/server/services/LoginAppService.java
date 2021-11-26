package es.deusto.ingenieria.sd.auctions.server.services;

import java.text.DateFormat;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoUsuario;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.domain.UserLocal;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import gateway.RegisterServiceGateway;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private List<User> usuarios = new ArrayList<>();
	private RegisterServiceGateway registerServiceGateway = new RegisterServiceGateway();


	public User login(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {

		if(tipoUsuarioDTO.equals(TipoUsuarioDTO.FACEBOOK) || tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)) {
			User u = new User();
			u.setEmail(email);
			u.setNickname(nickName);
			List<Entrenamiento> edto = new ArrayList<>();
			u.setEntrenamientos(edto);
			List<Reto> rdto = new ArrayList<>();
			u.setRetosAceptados(rdto);
			return u;
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.EMAIL)){
			UserLocal u = new UserLocal();
			u.setEmail(email);
			u.setNickname(nickName);
			u.setPassword(password);
			List<Entrenamiento> edto = new ArrayList<>();
			u.setEntrenamientos(edto);
			List<Reto> rdto = new ArrayList<>();
			u.setRetosAceptados(rdto);
			return u;
		}
		return null;
	}

	public UserDTO getCheckedUsuario(String email, String password) {
		UserDTO userQueVaASerRellenado = new UserDTO();

		UserLocal uT = new UserLocal();		
		uT.setEmail("thomas.e2001@gmail.com");
		uT.setNickname("Thomas");		
		uT.setPassword("thomas");
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
		ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
		entrenamientos.add(entrenamiento2);
		entrenamientos.add(entrenamiento1);		
		uT.setEntrenamientos(entrenamientos);
		List<Reto> retosAceptados = new ArrayList<Reto>();
		uT.setRetosAceptados(retosAceptados);
		uT.setTipoUsuario(TipoUsuario.EMAIL);
		usuarios.add(uT);
		
		User uB = new User();		
		uB.setEmail("billlie@gmail.com");
		uB.setNickname("Billlie");		
		Entrenamiento entrenamiento3 = new Entrenamiento();
		entrenamiento3.setTitulo("BiciMax");
		entrenamiento3.setDistancia(200);
		entrenamiento3.setFechaIni("11/01/2021");
		entrenamiento3.setDuracion(20);
		entrenamiento3.setHoraIni("12:22");
		entrenamiento3.setDeporte("bici");
		Entrenamiento entrenamiento4 = new Entrenamiento();
		entrenamiento4.setTitulo("Maraton");
		entrenamiento4.setDistancia(30);
		entrenamiento4.setFechaIni("12/11/2021");
		entrenamiento4.setDuracion(24);
		entrenamiento4.setHoraIni("14:12");
		entrenamiento4.setDeporte("correr");
		ArrayList<Entrenamiento> entrenamientos2 = new ArrayList<>();
		entrenamientos2.add(entrenamiento3);
		entrenamientos2.add(entrenamiento4);		
		uB.setEntrenamientos(entrenamientos2);
		List<Reto> retosAceptados2 = new ArrayList<Reto>();
		uB.setRetosAceptados(retosAceptados2);
		uB.setTipoUsuario(TipoUsuario.GOOGLE);
		usuarios.add(uB);

		for (User usuario : usuarios) {

			if(usuario.getTipoUsuario() == TipoUsuario.EMAIL) {
				UserLocal u = (UserLocal) usuario;
				if(u.getEmail().matches(email) && u.checkPassword(password)) {

					userQueVaASerRellenado.setEmail(u.getEmail());
					userQueVaASerRellenado.setNickname(u.getNickname());
					List<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
					for (Entrenamiento e : u.getEntrenamientos()) {
						entrenamientosDTO.add(assemblerEntrenamiento.entrenamientoToDTO(e));
					}
					userQueVaASerRellenado.setEntrenamientos(entrenamientosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.EMAIL);
					List<RetoAceptadoDTO> retosAceptadosDTO = new ArrayList<>();
					for (Reto reto : u.getRetosAceptados()) {
						RetoAceptadoDTO r = new RetoAceptadoDTO();
						r.setCreador(assamblerUser.userToDTO(reto.getCreador()));
						r.setDeporte(reto.getDeporte());
						r.setDescripcion(reto.getDescripcion());
						r.setFechaFin(reto.getFechaFin());
						r.setFechaInicio(reto.getFechaInicio());
						r.setObjetivo(reto.getObjetivo());
						r.setPorcentajeCompletado(101);
						r.setTitulo(r.getTitulo());
						retosAceptadosDTO.add(r);
					}
					userQueVaASerRellenado.setRetosAceptados(retosAceptadosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.EMAIL);
					return userQueVaASerRellenado;
				}
			} else if(usuario.getTipoUsuario() == TipoUsuario.GOOGLE) {
				if(registerServiceGateway.checkCuentaGmail(email, password)) {
					userQueVaASerRellenado.setEmail(usuario.getEmail());
					userQueVaASerRellenado.setNickname(usuario.getNickname());
					List<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
					for (Entrenamiento e : usuario.getEntrenamientos()) {
						entrenamientosDTO.add(assemblerEntrenamiento.entrenamientoToDTO(e));
					}
					userQueVaASerRellenado.setEntrenamientos(entrenamientosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.EMAIL);
					List<RetoAceptadoDTO> retosAceptadosDTO = new ArrayList<>();
					for (Reto reto : usuario.getRetosAceptados()) {
						RetoAceptadoDTO r = new RetoAceptadoDTO();
						r.setCreador(assamblerUser.userToDTO(reto.getCreador()));
						r.setDeporte(reto.getDeporte());
						r.setDescripcion(reto.getDescripcion());
						r.setFechaFin(reto.getFechaFin());
						r.setFechaInicio(reto.getFechaInicio());
						r.setObjetivo(reto.getObjetivo());
						r.setPorcentajeCompletado(101);
						r.setTitulo(r.getTitulo());
						retosAceptadosDTO.add(r);
					}
					userQueVaASerRellenado.setRetosAceptados(retosAceptadosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.EMAIL);
					return userQueVaASerRellenado;
				}
			}

		}

		return userQueVaASerRellenado;
	}


}

