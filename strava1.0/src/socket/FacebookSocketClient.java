package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class FacebookSocketClient {
	
	private String serverIP;
	private int serverPort;
	private static String DELIMITER = "#";
	
	public FacebookSocketClient (String servIP, int servPort) {
		serverIP = servIP;
		serverPort = servPort;
	}
	
	public void sendMessage(String source, String target, String text){
		String message = source + DELIMITER + target + DELIMITER + text;
		String translation = null;
		
		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket socket = new Socket(serverIP, serverPort);
			//Streams to send and receive information are created from the Socket
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
			
			//Send request (one String) to the server
			out.writeUTF(message);			
			System.out.println(" - Sending data to '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + message + "'");
			
			//Read response (one String) from the server
			translation = in.readUTF();			
			System.out.println(" - Getting translation from '" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "' -> '" + translation + "'");
		} catch (Exception e) {
			System.out.println("# Trans. SocketClient error: " + e.getMessage());	
		} 	
	}
}