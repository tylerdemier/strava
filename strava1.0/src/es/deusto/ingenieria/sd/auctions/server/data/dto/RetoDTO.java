package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class RetoDTO implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	private String titulo;
	private String deporte;
	private long objetivo;

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDeporte() {
		return deporte;
	}
	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public Long getObjetivo() {
		return objetivo;
	}
	
	public void setObjetivo(Long objetivo) {
		this.objetivo = objetivo;
	}
	
	

	
}




