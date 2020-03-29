package in.sprl.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {
	
	private SecurityUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static String encodePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);  
	}	
}
