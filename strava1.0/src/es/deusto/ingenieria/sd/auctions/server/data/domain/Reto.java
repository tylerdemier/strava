package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.text.NumberFormat; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Reto {	
	private String titulo;
	private String descripcion;
	private String deporte; 
	private String fechaInicio;
	private String fechaFin;
	private long objetivo;	
	
	@Persistent(defaultFetchGroup="true")
	private User creador;	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
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

	public long getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(long objetivo) {
		this.objetivo = objetivo;
	}

	public User getCreador() {
		return creador;
	}

	public void setCreador(User creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-YY - hh:mm");
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault()); 

		StringBuffer result = new StringBuffer("Titulo:");
		
		result.append(this.getTitulo());
		result.append(" - Descripcion:");
		result.append(this.getDescripcion());
		result.append(" - Deporte:");
		result.append(this.getDeporte());
		result.append(" - FechaInicio:");
		result.append(dateFormatter.format(this.fechaInicio));
		result.append(" - FechaFin:");
		result.append(dateFormatter.format(this.fechaFin));
		result.append(" - Objetivo:");
		result.append(numberFormatter.format(this.objetivo));
		result.append(" - Creador:");
		result.append(this.creador.getNickname());
		
		return result.toString();
	}
	

}