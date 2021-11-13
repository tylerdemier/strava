package es.deusto.ingenieria.sd.auctions.server.services;

import es.deusto.ingenieria.sd.auctions.server.data.domain.User;


public class LoginAppService {
		
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
}