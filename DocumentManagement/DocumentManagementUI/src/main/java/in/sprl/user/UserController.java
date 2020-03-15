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
	public ResponseEntity<String> getUserList() {
		LOGGER.info("UserController getUserList");
		try {
			return new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.getUserList()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 

	@GetMapping("/users/{id}")
	public ResponseEntity<String> getUserInformation(@PathVariable Long id) {
		LOGGER.info("UserController getUserInformation");
		try {
			return new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.getUserInformation(id)), HttpStatus.OK);
		} catch (Exception e) { 
			return new ResponseEntity<>(new ExceptionJsonInfo(exception), httpStatus.);
		}
	} 



	@PostMapping("/user")
	public ResponseEntity<String> createOrSaveUser(@RequestBody User newUser) {
		LOGGER.info("UserController createOrSaveUser");
		try {
			return new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.createOrSaveUser(newUser)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}      
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		LOGGER.info("UserController deleteUser");
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>("User Deleted", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User newUser, @PathVariable Long id) {
		LOGGER.info("UserController updateUser");
		try {
			return new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(userService.updateUser(newUser, id)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
