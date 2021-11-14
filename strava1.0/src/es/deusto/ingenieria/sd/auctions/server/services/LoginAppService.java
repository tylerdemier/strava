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
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	

	public User login(String email, String password, String nickName) {
		
		List<User> usuarios = new ArrayList<>();
		User uT = new User();		
		uT.setEmail("thomas.e2001@gmail.com");
		uT.setNickname("Thomas");		
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		uT.setPassword(sha1);
		
		usuarios.add(uT);
		
		User u = new User();
		u.setEmail(email);
		u.setNickname(nickName);
		u.setPassword(password);
		List<Entrenamiento> edto = new ArrayList<>();
		u.setEntrenamientos(edto);
		List<Reto> rdto = new ArrayList<>();
		u.setRetosAceptados(rdto);
		
		usuarios.add(u);
		
		for (User usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.checkPassword(password)) {		
				return usuario;
			}
		}
		
		return null;
		
	}



	public UserDTO getUser(String email, String password) {
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");	
		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);

		//Create Entrenamiento				
		Entrenamiento entrenamiento1 = new Entrenamiento();
		entrenamiento1.setTitulo("BiciMax");
		entrenamiento1.setDistancia(200);
		entrenamiento1.setFechaIni("11/01/2021");
		entrenamiento1.setDuracion(20);
		entrenamiento1.setHoraIni(12);
		entrenamiento1.setDeporte("bici");

		Entrenamiento entrenamiento2 = new Entrenamiento();
		entrenamiento2.setTitulo("Maraton");
		entrenamiento2.setDistancia(30);
		entrenamiento2.setFechaIni("12/11/2021");
		entrenamiento2.setDuracion(24);
		entrenamiento2.setHoraIni(20);
		entrenamiento2.setDeporte("correr");

		ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
		entrenamientos.add(entrenamiento2);
		entrenamientos.add(entrenamiento1);
		ArrayList<Entrenamiento> entrenamientos2 = new ArrayList<>();
		entrenamientos2.add(entrenamiento2);

		user.setEntrenamientos(entrenamientos);

		//Create Reto

		List<Reto> retosAceptados = new ArrayList<Reto>();

		user.setRetosAceptados(retosAceptados);


		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return assamblerUser.userToDTO(user);
		} else {
			return null;
		}

	}

	public float calcularEstado(RetoDTO reto, UserDTO user) {
		float resultado = 0;		
		for (EntrenamientoDTO entrenamientoDTO : user.getEntrenamientos()) {
			
			try {
				String retoIni = reto.getFechaInicio();
				Date df = new SimpleDateFormat("dd/MM/yyyy").parse(retoIni);
				
				
				String retoFin = reto.getFechaInicio();
				Date df1 = new SimpleDateFormat("dd/MM/yyyy").parse(retoFin);

				String entrenIni = entrenamientoDTO.getFechaIni();
				Date df2 = new SimpleDateFormat("dd/MM/yyyy").parse(entrenIni);
				
				JOptionPane.showMessageDialog(null, df2.after(df));

				float d = entrenamientoDTO.getDuracion();
				int duracion = (int) d;
				Date df3 = addHoursToJavaUtilDate(df2, duracion);

				if(reto.getDeporte().matches(entrenamientoDTO.getDeporte()) && df2.after(df) && df3.before(df1)) {
		
					float r = reto.getObjetivo();
					float cuantoHaHecho = entrenamientoDTO.getDistancia();
					// r ---> 100
					// d ---> x
					resultado = ((cuantoHaHecho * 100) / r);			
				} else {
					resultado = (float) 0.1;
				}

			} catch (ParseException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Hubo un probelma con las fechas.");
			}



		}	

		return resultado;
	}


	public Date addHoursToJavaUtilDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

}

