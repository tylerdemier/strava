package es.deusto.ingenieria.sd.auctions.server.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.ingenieria.sd.auctions.server.data.dao.UserDAO;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.server.data.domain.RetoAceptado;
import es.deusto.ingenieria.sd.auctions.server.data.domain.TipoUsuario;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.domain.UserLocal;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;
import factory.FacebookSocketClient;
import factory.GoogleServiceGateway;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private RetoAceptadoAssembler assemblerReto = new RetoAceptadoAssembler();
	private GoogleServiceGateway registerServiceGateway = new GoogleServiceGateway();
	private FacebookSocketClient client = new FacebookSocketClient("0.0.0.0", 35600);


	public User login(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {

		if(tipoUsuarioDTO.equals(TipoUsuarioDTO.FACEBOOK) || tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)) {
			User u = new User();
			u.setEmail(email);
			u.setNickname(nickName);
			List<Entrenamiento> edto = new ArrayList<>();
			u.setEntrenamientos(edto);
			List<RetoAceptado> rdto = new ArrayList<>();
			u.setRetosAceptados(rdto);
			return u;
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.EMAIL)){
			UserLocal u = new UserLocal();
			u.setEmail(email);
			u.setNickname(nickName);
			u.setPassword(password);
			List<Entrenamiento> edto = new ArrayList<>();
			u.setEntrenamientos(edto);
			List<RetoAceptado> rdto = new ArrayList<>();
			u.setRetosAceptados(rdto);
			return u;
		}
		return null;
	}



	public void crearUsuario(TipoUsuarioDTO tipo, String email, String nickname, String password,int alt, int fcm, int fcr, int peso, int rpm) {
		User u = new User();

		u.setEmail(email);
		u.setEntrenamientos(new ArrayList<>());
		u.setNickname(nickname);
		u.setRetosAceptados(new ArrayList<>());
		u.setAltura(alt);
		u.setFreqcardiacamax(fcm);
		u.setFreqcardireposo(fcr);
		u.setPeso(peso);
		u.setRpm(rpm);

		if(tipo.equals(TipoUsuarioDTO.EMAIL)) {
			UserLocal uL = new UserLocal();
			uL.setAltura(alt);
			uL.setEntrenamientos(new ArrayList<>());
			uL.setEmail(email);
			uL.setFreqcardiacamax(fcm);
			uL.setFreqcardireposo(fcr);
			uL.setNickname(nickname);
			uL.setPassword(password);
			uL.setPeso(peso);
			uL.setRetosAceptados(new ArrayList<>());
			uL.setRpm(rpm);
			uL.setTipoUsuario(TipoUsuario.EMAIL);
			System.out.println("ESLOCAL!");
			UserDAO.getInstance().save(uL);
		} else if(tipo.equals(TipoUsuarioDTO.GOOGLE)) {
			if(registerServiceGateway.checkCuenta(email, password)) {
				u.setTipoUsuario(TipoUsuario.GOOGLE);
				System.out.println("ESDEGOOGLE!");
				UserDAO.getInstance().save(u);
			} else {
				JOptionPane.showMessageDialog(null, "Este usuario de google no existe");
			}
		} else if(tipo.equals(TipoUsuarioDTO.FACEBOOK)) {
			if(client.checkCuenta(email, password)) {
				u.setTipoUsuario(TipoUsuario.FACEBOOK);
				System.out.println("ESDEFACEBOOOK!");
				UserDAO.getInstance().save(u);
			} else {
				JOptionPane.showMessageDialog(null, "Este usuario de facebook no existe");
			}
		}

	}


	public UserDTO getCheckedUsuario(String email, String password) {

		UserDTO userQueVaASerRellenado = new UserDTO();

		for (User usuario : UserDAO.getInstance().getAll()) {
			if(usuario.getTipoUsuario().equals(TipoUsuario.EMAIL)) {
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
					for (RetoAceptado r : u.getRetosAceptados()) {
						retosAceptadosDTO.add(assemblerReto.retoAceptadoToDTO(r));
					}
					userQueVaASerRellenado.setRetosAceptados(retosAceptadosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.EMAIL);
					return userQueVaASerRellenado;
				}
			} else if(usuario.getTipoUsuario().equals(TipoUsuario.GOOGLE)) {
				if(registerServiceGateway.checkCuenta(email, password) && email.matches(usuario.getEmail())) {
//					System.out.println("==== LLEGO 5 ====");
//					System.out.println("Email:" + email);
//					System.out.println("password:" + password);
//					System.out.println("getemail:" + usuario.getEmail());
//					System.out.println("nick:" + usuario.getNickname());
					userQueVaASerRellenado.setEmail(usuario.getEmail());
					userQueVaASerRellenado.setNickname(usuario.getNickname());
					List<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
					for (Entrenamiento e : usuario.getEntrenamientos()) {
						entrenamientosDTO.add(assemblerEntrenamiento.entrenamientoToDTO(e));
					}
					userQueVaASerRellenado.setEntrenamientos(entrenamientosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
					List<RetoAceptadoDTO> retosAceptadosDTO = new ArrayList<>();
					for (RetoAceptado r : usuario.getRetosAceptados()) {
						retosAceptadosDTO.add(assemblerReto.retoAceptadoToDTO(r));
					}
					userQueVaASerRellenado.setRetosAceptados(retosAceptadosDTO);
					return userQueVaASerRellenado;
				}
			} else if (usuario.getTipoUsuario().equals(TipoUsuario.FACEBOOK)) {
				if(client.checkCuenta(email, password)) {
					userQueVaASerRellenado.setEmail(usuario.getEmail());
					userQueVaASerRellenado.setNickname(usuario.getNickname());
					List<EntrenamientoDTO> entrenamientosDTO = new ArrayList<>();
					for (Entrenamiento e : usuario.getEntrenamientos()) {
						entrenamientosDTO.add(assemblerEntrenamiento.entrenamientoToDTO(e));
					}
					userQueVaASerRellenado.setEntrenamientos(entrenamientosDTO);
					userQueVaASerRellenado.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
					List<RetoAceptadoDTO> retosAceptadosDTO = new ArrayList<>();
					for (RetoAceptado r : usuario.getRetosAceptados()) {
						retosAceptadosDTO.add(assemblerReto.retoAceptadoToDTO(r));
					}
					userQueVaASerRellenado.setRetosAceptados(retosAceptadosDTO);
					return userQueVaASerRellenado;
				}
			}

		}

		return userQueVaASerRellenado;
	}
	
	
	public UserDTO actualizarUser(UserDTO u, ErAppService er) {
		User usuario = new User();
		System.out.println("++++++ LLEGO "+u.getNickname()+" ++++++");
		for (User user : UserDAO.getInstance().getAll()) {
			if(user.getNickname().matches(u.getNickname())) {
//				UserDAO.getInstance().delete(user);
					usuario = user;
			}
		}
		UserDAO.getInstance().delete(UserDAO.getInstance().find(u.getNickname()));
		
		usuario.setEntrenamientos(new ArrayList<>());
		System.out.println("++++++ LLEGO 1 ++++++");
		for (EntrenamientoDTO eDTO : u.getEntrenamientos()) {
			Entrenamiento e = new Entrenamiento();
			e.setDeporte(eDTO.getDeporte());
			e.setDistancia(eDTO.getDistancia());
			e.setDuracion(eDTO.getDuracion());
			e.setFechaIni(eDTO.getFechaIni());
			e.setHoraIni(eDTO.getHoraIni());
			e.setTitulo(eDTO.getTitulo());
			usuario.getEntrenamientos().add(e);
		}
	
		usuario.setRetosAceptados(new ArrayList<>());
		System.out.println("++++++ LLEGO 2 ++++++");
		for (RetoAceptadoDTO rDTO : u.getRetosAceptados()) {
			RetoAceptado r = new RetoAceptado();
			User creador = new User();
			creador.setNickname(rDTO.getCreador().getNickname());
			r.setCreador(creador);
			r.setDeporte(rDTO.getDeporte());
			r.setDescripcion(rDTO.getDescripcion());
			r.setFechaFin(rDTO.getFechaFin());
			r.setFechaInicio(rDTO.getFechaInicio());
			r.setObjetivo(rDTO.getObjetivo());
			r.setTitulo(rDTO.getTitulo());
			r.setPorcentaje(rDTO.getPorcentajeCompletado());
			usuario.getRetosAceptados().add(r);
		}
		System.out.println("++++++ LLEGO 3 ++++++");
		UserDAO.getInstance().save(usuario);
		
		UserAssembler uA = new UserAssembler();
		
		for (User user : UserDAO.getInstance().getAll()) {
			System.out.println("Al Guardar F: " + user.getNickname());
			for (Entrenamiento e : user.getEntrenamientos()) {
				System.out.println("	Definitvo: " + e.getTitulo());
			}
		}
		
		
		return uA.userToDTO(usuario, er);	
	}


}

