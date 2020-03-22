package in.sprl.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sprl.handler.ExceptionJsonInfo;
import in.sprl.util.JsonUtil;

@RestController
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);	

	@Autowired
	UserService userService;	

	@GetMapping("/users")
	public ResponseEntity<Object> getUserList() {
		LOGGER.info("UserController getUserList");
		ResponseEntity<Object> responseEntity = null;
		try {
			responseEntity =  new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.getUserList()), HttpStatus.OK);
		}  catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity;
	} 

	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getUserInformation(@PathVariable Long id) {
		LOGGER.info("UserController getUserInformation");
		ResponseEntity<Object> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.getUserInformation(id)), HttpStatus.OK);
		} catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity;
	} 
	
	
	@GetMapping("/users/findByUserName/{username}")
	public ResponseEntity<Object> findByUserName(@PathVariable String username) {
		LOGGER.info("UserController findUserInformation");
		ResponseEntity<Object> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<>(userService.findByUserName(username), HttpStatus.OK);
		} catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity;
	} 



	@PostMapping("/user")
	public ResponseEntity<Object> createOrSaveUser(@RequestBody User newUser) {
		LOGGER.info("UserController createOrSaveUser");
		ResponseEntity<Object> responseEntity = null;
		try {
			responseEntity =  new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.createOrSaveUser(newUser)), HttpStatus.OK);
		} catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity;   
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		LOGGER.info("UserController deleteUser");
		ResponseEntity<Object> responseEntity = null;
		try {
			userService.deleteUser(id);
			responseEntity =  new ResponseEntity<>("User Deleted", HttpStatus.OK);
		} catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity;   
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User newUser, @PathVariable Long id) {
		LOGGER.info("UserController updateUser");
		ResponseEntity<Object> responseEntity = null;
		try {
			return new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.updateUser(newUser, id)), HttpStatus.OK);
		}catch (Exception exception) { 
			LOGGER.error(exception.getMessage(), exception);
			responseEntity = new ResponseEntity<>(new ExceptionJsonInfo(exception), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return responseEntity; 
	}

}
