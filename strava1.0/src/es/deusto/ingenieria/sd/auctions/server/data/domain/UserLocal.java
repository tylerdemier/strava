package es.deusto.ingenieria.sd.auctions.server.data.domain;

public class UserLocal extends User {
	
	private String password;
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
