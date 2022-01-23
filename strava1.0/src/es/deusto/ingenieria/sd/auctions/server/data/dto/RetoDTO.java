package es.deusto.ingenieria.sd.auctions.server.data.dto;

import java.io.Serializable;
import java.util.Date;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class RetoDTO implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String titulo;
	private String descripcion;
	private String deporte;
	private String fechaInicio;
	private String fechaFin;
	private long objetivo;	
	private UserDTO creador;	

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public UserDTO getCreador() {
		return creador;
	}

	public void setCreador(UserDTO dto) {
		this.creador = dto;
	}

	public void setObjetivo(long objetivo) {
		this.objetivo = objetivo;
	}
	

	
}




