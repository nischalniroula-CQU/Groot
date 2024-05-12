package com.fyp.groot.repository;

import com.fyp.groot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// User findByUsernameAndPassword(String username, String password);
	// Optional<User> findByFirebaseId(String firebaseId);

}

/*
 * @Repository public class UserRepository extends
 * AbstractFirestoreRepository<User> { protected UserRepository(Firestore
 * firestore) { super(firestore, "User"); } }
 */
