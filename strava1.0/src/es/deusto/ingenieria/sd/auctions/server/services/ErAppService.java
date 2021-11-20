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
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAceptadoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.RetoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

//TODO: Implement Singleton Pattern
public class ErAppService {

	private List<Reto> retos = new ArrayList<>();
	private List<Reto> retosAceptados = new ArrayList<>();
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	private EntrenamientoAssembler assemblerEntrenamiento = new EntrenamientoAssembler();
	private UserAssembler assamblerUser = new UserAssembler();
	private RetoAssembler assemblerReto = new RetoAssembler();
	private RetoAceptadoAssembler aceptadoAssembler = new RetoAceptadoAssembler();


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
		r.setFechaFin(reto.getFechaFin());
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


	public float calcularEstado(RetoAceptadoDTO reto, UserDTO user) {
		float resultado = 0;	


		for (EntrenamientoDTO entrenamiento : user.getEntrenamientos()) {

			float cuantoHaHecho = 0;

			String retoIni = reto.getFechaInicio();
			Date df = null;
			try {
				df = new SimpleDateFormat("dd/MM/yyyy").parse(retoIni);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String retoFin = reto.getFechaFin();
			Date df1 = null;
			try {
				df1 = new SimpleDateFormat("dd/MM/yyyy").parse(retoFin);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String entrenIni = entrenamiento.getFechaIni();
			Date df2 = null;
			try {
				df2 = new SimpleDateFormat("dd/MM/yyyy").parse(entrenIni);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			float d = entrenamiento.getDuracion();
			int duracion = (int) d;
			Date df3 = addHoursToJavaUtilDate(df2, duracion);

			if(entrenamiento.getDeporte().matches(reto.getDeporte()) && df2.after(df) && df3.before(df1)) {
				cuantoHaHecho = cuantoHaHecho + entrenamiento.getDistancia();
				long objetivo = reto.getObjetivo();
				// o ---> 100
				// c ---> x
				resultado = ((cuantoHaHecho * 100) / objetivo);	
				System.out.println("Resultado:" + resultado + "		-	" + reto.getTitulo());
				return resultado;
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
