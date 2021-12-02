package factory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookSocketClient implements ILoginGateway {
	
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public FacebookSocketClient (String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
	}

	@Override
	public boolean checkCuenta(String email, String contrasenya) {
		String message = email + DELIMITER + contrasenya;
		String translation = null;
		
		try (Socket socket = new Socket(serverIP, serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
			
			out.writeUTF(message);			
			System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + message + "'");
			
			translation = in.readUTF();			
			System.out.println(" - Getting info from '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + translation + "'");
			return Boolean.parseBoolean(translation);
		} catch (Exception e) {
			System.out.println("# Trans. SocketClient error: " + e.getMessage());	
		}
		return false; 	
	}
}