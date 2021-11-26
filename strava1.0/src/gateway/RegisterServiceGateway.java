package gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.currency.remote.IRegistrationGoogle;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

public class RegisterServiceGateway {

	private static RegisterServiceGateway instance;
	private IRegistrationGoogle currencyConvService;
	
	public RegisterServiceGateway() {
		try {		
			String URL = "//127.0.0.1:1099/stravaGoogle";
			this.currencyConvService = (IRegistrationGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}
	}
	
	public static RegisterServiceGateway getInstance() {
		if(instance == null) {
			instance = new RegisterServiceGateway();
		}
		return instance;
	}
	

	public boolean checkCuentaGmail(String email, String contrasenya) {
		try {
			return this.currencyConvService.checkCuentaGmail(email, contrasenya);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	

}