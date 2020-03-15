package in.sprl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {
	private static final Logger LOGGER = LogManager.getLogger(JsonUtil.class);	

	public static String convertJavaObjectToJson(Object object) {
		ObjectMapper objectMapper = new ObjectMapper(); 
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return jsonString;
	} 

}
