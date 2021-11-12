package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class EntrenamientoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String titulo;	
	private String deporte;	
	private float distancia;
	private long duracion;

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
	
	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	
	public Long getDuracion() {
		return duracion;
	}
	
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
}
