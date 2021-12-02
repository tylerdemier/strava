package factory;

import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;


public class LoginFactory {
	public static ILoginGateway crearLoginService(String metodo) {
		if (metodo.equals("Google")) {
			return (ILoginGateway) new GoogleServiceGateway();
		} else if (metodo.equals("Facebook")) {
			final String serverIP = "127.0.0.1";
			final int serverPort = 35600;
			return new FacebookSocketClient(serverIP, serverPort);
		} else {
			return null;
		}
	}

}


