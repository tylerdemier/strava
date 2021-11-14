package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.Reto;

//This class implements DTO pattern
public class UserDTO implements Serializable {	
	//This attribute is needed to implement the "Serializable" interface.
	private static final long serialVersionUID = 1L;	
	private String nickname;
	private String email;
	private List<RetoDTO> retosAceptados = new ArrayList<>();
	private List<EntrenamientoDTO> entrenamientos = new ArrayList<>();


	public List<RetoDTO> getRetosAceptados() {
		return retosAceptados;
	}

	public void setRetosAceptados(List<RetoDTO> retosAceptados) {
		this.retosAceptados = retosAceptados;
	}
	

	public List<EntrenamientoDTO> getEntrenamientos() {
		return entrenamientos;
	}

	public ArrayList<EntrenamientoDTO> getEntrenamientosD(String deporte) {
		ArrayList<EntrenamientoDTO> entrenamientosArray = new ArrayList<>();
				
		for (EntrenamientoDTO e : this.getEntrenamientos()) {
			if (e.getDeporte().equalsIgnoreCase(deporte)) {
				entrenamientosArray.add(e);
			}
		}	
		return entrenamientosArray;
	}

	public void setEntrenamientos(List<EntrenamientoDTO> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nickname);
		result.append(" # '");
		result.append(this.email);
		result.append("' # Email: ");
		result.append(this.email);
		
		return result.toString();
	}
}