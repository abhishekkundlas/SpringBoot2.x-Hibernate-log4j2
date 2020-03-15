package in.sprl.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {

	public static String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);  
	}	
}
