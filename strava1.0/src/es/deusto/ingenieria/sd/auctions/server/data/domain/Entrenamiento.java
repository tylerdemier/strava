package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Entrenamiento {
	private String titulo;	
	private String deporte;	
	private float distancia;
	private Date fechaIni;	
	private long horaIni;
	private long duracion;
	private User hacedor;
	
	
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

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public long getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(long horaIni) {
		this.horaIni = horaIni;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public User getHacedor() {
		return hacedor;
	}

	public void setHacedor(User hacedor) {
		this.hacedor = hacedor;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-YY - hh:mm");
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault()); 

		StringBuffer result = new StringBuffer();
		
		result.append(this.titulo);
		result.append(" # '");
		result.append(this.deporte);
		result.append("' # Distancia: ");
		result.append(numberFormatter.format(this.distancia));
		result.append("/");
		result.append(dateFormatter.format(this.fechaIni));
		result.append(" (");
		result.append(" # FechaFin end: ");
		result.append(dateFormatter.format(this.fechaIni));
		result.append(" (");
		result.append("' # HoraIni: ");
		result.append(numberFormatter.format(this.horaIni));
		result.append("' # Duracion: ");
		result.append(numberFormatter.format(this.duracion));
		result.append("' # Usuario: ");
		result.append(numberFormatter.format(this.hacedor.getNickname()));
		
		return result.toString();		
	}
	
}