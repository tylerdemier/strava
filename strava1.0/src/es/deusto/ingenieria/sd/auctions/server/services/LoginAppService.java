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
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();


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


}

