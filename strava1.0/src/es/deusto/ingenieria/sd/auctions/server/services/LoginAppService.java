package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserAssembler;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;


public class LoginAppService {

	private UserAssembler assamblerUser = new UserAssembler();
	
	public User login(String email, String password) {

		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");		

		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);

		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return user;
		} else {
			return null;
		}
	}
	


	public UserDTO getUser(String email, String password) {
		User user = new User();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setNickname("Thomas");		

		String sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex("$!9PhNz,");		
		user.setPassword(sha1);

		if (user.getEmail().equals(email) && user.checkPassword(password)) {		
			return assamblerUser.userToDTO(user);
		} else {
			return null;
		}

	}

}