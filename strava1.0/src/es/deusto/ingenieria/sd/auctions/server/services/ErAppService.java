package es.deusto.ingenieria.sd.auctions.server.services;

import java.rmi.RemoteException;
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
import es.deusto.ingenieria.sd.auctions.server.data.domain.UserLocal;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//TODO: Implement Singleton Pattern
public class ErAppService {

	private List<Reto> retos = new ArrayList<>();
	private List<Reto> retosAceptados = new ArrayList<>();
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	private List<User> usuarios = new ArrayList<>();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private UserAssembler assamblerUser = new UserAssembler();
	private RetoAssembler assemblerReto = new RetoAssembler();


	public ErAppService() {
		this.initilizeData();
	}

	private void initilizeData() {
		//Create Users
		UserLocal user0 = new UserLocal();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNickname("Thomas");
		user0.setPassword("$!9PhNz,");

		UserLocal user1 = new UserLocal();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");		
		user1.setPassword("hqc`}3Hb");

		//Create Reto
		Reto reto1 = new Reto();
		reto1.setTitulo("Pedalear Muchisimo");
		reto1.setDescripcion("¡quema tu bici!");
		reto1.setCreador(user1);
		reto1.setFechaInicio("01/01/2021");
		reto1.setFechaFin("31/12/2021");
		reto1.setObjetivo(2800);
		reto1.setDeporte("bici");

		Reto reto2 = new Reto();
		reto2.setTitulo("Correr Muchisimo");
		reto2.setDescripcion("Huye de la policia");
		reto2.setCreador(user0);
		reto2.setFechaInicio("31/10/2021");
		reto2.setFechaFin("31/12/2021");
		reto2.setObjetivo(300);
		reto2.setDeporte("correr");

		retos.add(reto1);
		retos.add(reto2);

	}

	

	public ArrayList<RetoDTO> getRetos(String deporte) {
		ArrayList<RetoDTO> retosArray = new ArrayList<>();
		for (Reto r : this.retos) {
			if (r.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerReto.getInstance();
				RetoDTO dto = assemblerReto.retoToDTO(r);
				retosArray.add(dto);
			}
		}	
		return retosArray;
	}

	public List<Reto> getRetosNormales() {
		return retos;
	}

	public void anyadirRetoARetos(RetoDTO reto, UserDTO user) {
		Reto r = new Reto();
		User u = new User();
		u.setNickname(user.getNickname());
		r.setCreador(u);
		r.setDeporte(reto.getDeporte());
		r.setDescripcion(reto.getDescripcion());
		r.setFechaInicio(reto.getFechaInicio());
		r.setFechaFin(r.getFechaFin());
		r.setObjetivo(reto.getObjetivo());
		r.setTitulo(reto.getTitulo());

		this.retos.add(r);


	}

	public void quitarRetoARetos(String tituloReto) {

		List<Reto> retosNuevos = new ArrayList<>();
		for (Reto reto : this.retos) {
			if(!reto.getTitulo().matches(tituloReto)) {
				retosNuevos.add(reto);
			}
		}

		this.retos = retosNuevos;			
	}
	
	
public UserDTO getCheckedUsuario(String email, String password) {

		
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
		usuarios.add(uT);
		
		JOptionPane.showMessageDialog(null, "aqui1");

		for (User usuario : usuarios) {
			if(usuario.getClass().getSimpleName().matches("UserLocal")) {
				UserLocal u = (UserLocal) usuario;
				if(u.getEmail().matches(email) && u.checkPassword(password)) {
					JOptionPane.showMessageDialog(null, "aqui2");
					return assamblerUser.userToDTO(u);
				}
			} else if(usuario.getClass().getSimpleName().matches("User")) {
				JOptionPane.showMessageDialog(null, "aqui3");
				return assamblerUser.userToDTO(usuario);		
			}

		}

		return null;


	}

	public void calcularEstado(RetoAceptadoDTO reto, UserDTO user) {
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

		reto.setPorcentajeCompletado(resultado);

	}


	public Date addHoursToJavaUtilDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}




}
