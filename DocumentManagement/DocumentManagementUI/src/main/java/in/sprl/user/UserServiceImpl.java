package in.sprl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sprl.util.SecurityUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity getUserInformation(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<UserEntity> getUserList() {
		return userRepository.findAll();
	}

	public UserEntity createOrSaveUser(User user) {

		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(SecurityUtil.encodePassword(user.getPassword()));
		return userRepository.saveAndFlush(userEntity);
	}

	public void deleteUser(Long id) { 
		userRepository.deleteById(id); 
	}

	public UserEntity updateUser(User newUser, Long id) { 
		return
				userRepository.findById(id)
				.map(userEntity -> {
					userEntity.setFirstName(newUser.getFirstName());
					userEntity.setLastName(newUser.getLastName());
					userEntity.setUsername(newUser.getUsername()); 
					return userRepository.save(userEntity); 
				})
				.orElseGet(UserEntity :: new);
	}

	@Override
	public UserEntity findByUserName(String username) {
		return userRepository.findByUserNameABH(username);		
	}	
}
