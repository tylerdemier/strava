package factory;

import java.rmi.Naming; 
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.currency.remote.IRegistrationGoogle;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

public class GoogleServiceGateway implements ILoginGateway {

	private static GoogleServiceGateway instance;
	private IRegistrationGoogle currencyConvService;
	
	public GoogleServiceGateway() {
		try {		
			String URL = "//127.0.0.1:1099/stravaGoogle";
			this.currencyConvService = (IRegistrationGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}
	}
	
	public static GoogleServiceGateway getInstance() {
		if(instance == null) {
			instance = new GoogleServiceGateway();
		}
		return instance;
	}

	@Override
	public boolean checkCuenta(String email, String contrasenya) {
		try {
			return this.currencyConvService.checkCuentaGmail(email, contrasenya);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	


}