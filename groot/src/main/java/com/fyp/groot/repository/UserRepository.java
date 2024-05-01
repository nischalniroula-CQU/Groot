
  package com.fyp.groot.repository;
  
  import java.util.Optional;
  
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.LocalUser;
import com.fyp.groot.entity.User; 
  import com.google.cloud.firestore.Firestore;
  
	@Repository 
	public interface UserRepository extends JpaRepository<LocalUser, Long>
	{
	
	//User findByUsernameAndPassword(String username, String password);
	//Optional<User> findByFirebaseId(String firebaseId);
	
	}
 
 








	/*
	 * @Repository public class UserRepository extends
	 * AbstractFirestoreRepository<User> { protected UserRepository(Firestore
	 * firestore) { super(firestore, "User"); } }
	 */
	 