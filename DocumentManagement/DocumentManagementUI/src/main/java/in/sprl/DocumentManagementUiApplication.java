package in.sprl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocumentManagementUiApplication {	
	
	private static final Logger LOGGER = LogManager.getLogger(DocumentManagementUiApplication.class);	 
	public static void main(String[] args) {
		/*
		 * LOGGER.trace("This is a trace log example");
		 * LOGGER.info("This is an info log example");
		 * LOGGER.debug("This is a debug log example");
		 * LOGGER.error("This is an error log example");
		 * LOGGER.fatal("This is a fatal log example");
		 * LOGGER.warn("This is a warn log example");
		 */
		LOGGER.info("application started");		
		SpringApplication.run(DocumentManagementUiApplication.class, args);
	}

}
