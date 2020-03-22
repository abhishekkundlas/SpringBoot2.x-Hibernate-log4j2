package in.sprl.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {	
	UserEntity findByUserName(String username);
    List<UserEntity> findByFirstName(String firstName);
    List<UserEntity> findByLastName(String lastName);
    
    
	/*
	 * Use this code to fetch data in JPQL STYLE
	 * Date : 19 MARCH 2020 
	 */
    /*
    @Query("select u from UserEntity u where u.userName = :username") 
   	UserEntity findByUserNameABH(@Param("username") String username);
   	*/   
   
    /*
	 * Use this code to fetch data in Native Query STYLE
	 * Date : 19 MARCH 2020 
	 */    
    @Query(value = "select * from users u where u.username = :username", nativeQuery = true) 
	UserEntity findByUserNameABH(@Param("username") String username);
	
}
