package es.deusto.ingenieria.sd.auctions.server.services;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.ingenieria.sd.auctions.server.data.dao.RetoDAO;
import es.deusto.ingenieria.sd.auctions.server.data.dao.UserDAO;
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

	//	private List<Reto> retos = new ArrayList<>();
	private RetoAssembler assemblerReto = new RetoAssembler();

	public ErAppService() {
		this.initilizeData();
	}

	private void initilizeData() {			}



	public ArrayList<RetoDTO> getRetos(String deporte) {
		ArrayList<RetoDTO> retosArray= new ArrayList<>();
		for (Reto r : RetoDAO.getInstance().getAll()) {
			if (r.getDeporte().equalsIgnoreCase(deporte)) {
				assemblerReto.getInstance();
				RetoDTO dto = assemblerReto.retoToDTO(r);
				retosArray.add(dto);
			}
		}	
		return retosArray;
	}



	public void quitarRetoARetos(String tituloReto) {

		for (Reto reto : RetoDAO.getInstance().getAll()) {
			if(reto.getTitulo().matches(tituloReto)) {
				RetoDAO.getInstance().delete(reto);
			}
		}		
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


	public void crearReto(UserDTO user, String deporte, String titulo, String descripcion, String fechaIni, String fechaFin, int objetivo){
		Reto reto = new Reto();

		User u = new User();
		u.setNickname(user.getNickname());


		reto.setCreador(u);
		reto.setDescripcion(descripcion);
		reto.setDeporte(deporte);
		reto.setTitulo(titulo);
		reto.setDescripcion(descripcion);
		reto.setFechaFin(fechaFin);
		reto.setFechaInicio(fechaIni);
		reto.setObjetivo(objetivo);


		RetoDAO.getInstance().save(reto);
	}


	public void crearEntrenamiento(UserDTO usuarioDTO, String deporte, String titulo, String fechaIni, int distancia, String horaIni, int duracion) {

		User u = new User();
		u = UserDAO.getInstance().find(usuarioDTO.getNickname());

		UserDAO.getInstance().delete(UserDAO.getInstance().find(usuarioDTO.getNickname()));
		u = UserDAO.getInstance().find(usuarioDTO.getNickname());
//		for (User user : UserDAO.getInstance().getAll()) {
//			if(user.getNickname().matches(usuarioDTO.getNickname())) {
//				UserDAO.getInstance().delete(user);
//					u = user;
	//				u.setEmail(user.getEmail());
	//				u.setNickname(user.getNickname());
	//				try {
	//					((UserLocal)u).setPassword(((UserLocal)u).getPassword()); 
	//				} catch (Exception e) {
	//					// TODO: handle exception
	//				}
	//				
	//				u.setPeso(user.getPeso());
	//				u.setRpm(user.getRpm());
	//				u.setFreqcardiacamax(user.getFreqcardiacamax());
	//				u.setFreqcardireposo(user.getFreqcardireposo());
	//				u.setAltura(user.getAltura());
	//				
	//				u.setEntrenamientos(user.getEntrenamientos());
	//				u.setRetosAceptados(user.getRetosAceptados());
	//				u.setTipoUsuario(user.getTipoUsuario());
//			
//			}
//		}
		
		Entrenamiento e2 = new Entrenamiento();
		e2.setDeporte(deporte);
		e2.setDistancia(distancia);
		e2.setDuracion(duracion);
		e2.setFechaIni(fechaIni);
		e2.setHoraIni(horaIni);
		e2.setTitulo(titulo);

		u.getEntrenamientos().add(e2);
		

		UserDAO.getInstance().save(u);

	}

	
	
	
	
	






}
