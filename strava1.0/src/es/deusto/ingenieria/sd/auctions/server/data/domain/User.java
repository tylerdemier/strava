package es.deusto.ingenieria.sd.auctions.server.data.domain;

import java.util.ArrayList;
import java.util.List;

public class User {	
	private String nickname;
	private String password;
	private String email;
	private List<Reto> retosAceptados = new ArrayList<>();
	private List<Entrenamiento> entrenamientos = new ArrayList<>();
	//Lo opcional
	private float peso;
	private float altura;
	private float freqcardiacamax;
	private float freqcardireposo;
	private float rpm;
		
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reto> getRetosAceptados() {
		return retosAceptados;
	}

	public void setRetosAceptados(List<Reto> retosAceptados) {
		this.retosAceptados = retosAceptados;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public String getPassword() {
		return password;
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getFreqcardiacamax() {
		return freqcardiacamax;
	}

	public void setFreqcardiacamax(float freqcardiacamax) {
		this.freqcardiacamax = freqcardiacamax;
	}

	public float getFreqcardireposo() {
		return freqcardireposo;
	}

	public void setFreqcardireposo(float freqcardireposo) {
		this.freqcardireposo = freqcardireposo;
	}

	public float getRpm() {
		return rpm;
	}

	public void setRpm(float rpm) {
		this.rpm = rpm;
	}
	

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nickname);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
		result.append(this.retosAceptados.size());
		result.append(" Retos) - (");
		result.append(this.entrenamientos.size());
		result.append(" Entrenamientos)");
		result.append(this.peso);
		result.append(" - Peso)");
		result.append(this.altura);
		result.append(" - Altura)");
		result.append(this.freqcardiacamax);
		result.append(" - Frecuencia cardiaca maxima)");
		result.append(this.freqcardireposo);
		result.append(" - Frecuencia cardiaca en reposo)");
		result.append(this.rpm);
		result.append(" - RPM)");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((User)obj).email);
		}
		
		return false;
	}
}