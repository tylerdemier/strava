package gateway;

import java.rmi.Naming;  

import es.deusto.ingenieria.sd.auctions.currency.remote.IRegistration;

public class RegisterServiceGateway {

	private static RegisterServiceGateway instance;
	private IRegistration currencyConvService;
	
	private RegisterServiceGateway() {
		try {		
			String URL = "//127.0.0.1:1099/CurrencyExchange";
			this.currencyConvService = (IRegistration) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}
	}
	
	public static RegisterServiceGateway getInstance() {
		if(instance == null) {
			instance = new RegisterServiceGateway();
		}
		
		return instance;
	}
	
	public float getUSDRate() {
		System.out.println("   - Get USD rate from Currency Service Gateway");
		
		try {
			return this.currencyConvService.getUSDRate();
		} catch (Exception ex) {
			System.out.println("   $ Error getting USD rate: " + ex.getMessage());
			return -1f;
		}		
	}

	public float getGBPRate() {
		System.out.println("   - Get GBP rate from Currency Service Gateway");
		
		try {
			return this.currencyConvService.getGBPRate();
		} catch (Exception ex) {
			System.out.println("   $ Error getting GBP rate: " + ex.getMessage());
			return -1f;
		}
	}

}