package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;

public class EntrenamientoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int number;
	private String titulo;	
	private String deporte;	
	private float distancia;
	private String fechaIni;	
	private String horaIni;
	private long duracion;	

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
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

	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	
	
	
}
