package in.sprl.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public UserEntity getUserInformation(Long id);
	public List<UserEntity> getUserList();
	public UserEntity createOrSaveUser(User user);
	public void deleteUser(Long id) ;
	public UserEntity updateUser(User user, Long id);	
	public UserEntity findByUserName(String username);
}
