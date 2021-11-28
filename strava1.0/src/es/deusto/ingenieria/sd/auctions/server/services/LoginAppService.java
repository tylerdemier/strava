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
import socket.FacebookSocketClient;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private List<User> usuarios = new ArrayList<>();
	private RegisterServiceGateway registerServiceGateway = new RegisterServiceGateway();
	private FacebookSocketClient client = new FacebookSocketClient("0.0.0.0", 35600);


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
		entrenamiento3.setTitulo("Bicicleteando");
		entrenamiento3.setDistancia(20);
		entrenamiento3.setFechaIni("11/11/2021");
		entrenamiento3.setDuracion(30);
		entrenamiento3.setHoraIni("11:11");
		entrenamiento3.setDeporte("bici");
		Entrenamiento entrenamiento4 = new Entrenamiento();
		entrenamiento4.setTitulo("EncontrarABilllie");
		entrenamiento4.setDistancia(3000);
		entrenamiento4.setFechaIni("12/12/2021");
		entrenamiento4.setDuracion(2);
		entrenamiento4.setHoraIni("10:20");
		entrenamiento4.setDeporte("correr");
		ArrayList<Entrenamiento> entrenamientos2 = new ArrayList<>();
		entrenamientos2.add(entrenamiento3);
		entrenamientos2.add(entrenamiento4);		
		uB.setEntrenamientos(entrenamientos2);
		List<Reto> retosAceptados2 = new ArrayList<Reto>();
		uB.setRetosAceptados(retosAceptados2);
		uB.setTipoUsuario(TipoUsuario.GOOGLE);
		usuarios.add(uB);
		
		User uA = new User();		
		uA.setEmail("astro@hotmail.com");
		uA.setNickname("Astro");		
		Entrenamiento entrenamiento5 = new Entrenamiento();
		entrenamiento5.setTitulo("ET");
		entrenamiento5.setDistancia(2000);
		entrenamiento5.setFechaIni("07/07/2021");
		entrenamiento5.setDuracion(10);
		entrenamiento5.setHoraIni("00:30");
		entrenamiento5.setDeporte("bici");
		Entrenamiento entrenamiento6 = new Entrenamiento();
		entrenamiento6.setTitulo("Maraton");
		entrenamiento6.setDistancia(10000);
		entrenamiento6.setFechaIni("12/11/2021");
		entrenamiento6.setDuracion(300);
		entrenamiento6.setHoraIni("14:12");
		entrenamiento6.setDeporte("correr");
		ArrayList<Entrenamiento> entrenamientos3 = new ArrayList<>();
		entrenamientos3.add(entrenamiento3);
		entrenamientos3.add(entrenamiento4);		
		uA.setEntrenamientos(entrenamientos2);
		List<Reto> retosAceptados3 = new ArrayList<Reto>();
		uA.setRetosAceptados(retosAceptados3);
		uA.setTipoUsuario(TipoUsuario.FACEBOOK);
		usuarios.add(uA);


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
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
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
					return userQueVaASerRellenado;
				}
			} else if (usuario.getTipoUsuario() == TipoUsuario.FACEBOOK) {
				if(client.sendMessage(email, password)) {
					userQueVaASerRellenado.setEmail(usuario.getEmail());
					userQueVaASerRellenado.setNickname(usuario.getNickname());
					List<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
					for (Entrenamiento e : usuario.getEntrenamientos()) {
						entrenamientosDTO.add(assemblerEntrenamiento.entrenamientoToDTO(e));
					}
					userQueVaASerRellenado.setEntrenamientos(entrenamientosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
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
					return userQueVaASerRellenado;
				}
			}

		}

		return userQueVaASerRellenado;
	}


}

