package com.fyp.groot.service;

import com.fyp.groot.entity.User;
import com.fyp.groot.model.SignupRequest;
import com.fyp.groot.repository.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * UserService handles the business logic for user-related operations.
 */
@Service
public class UserService {

    private static final String COLLECTION_NAME = "users";

    @Autowired
    private FirebaseUserService firebaseUserService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user in Firebase and links it with a local user entity.
     * 
     * @param signupRequest the signup request containing user details
     * @return the created UserRecord
     * @throws FirebaseAuthException if an error occurs while creating the user in Firebase
     */
    public UserRecord createUserAndLinkFirebaseUser(SignupRequest signupRequest) throws FirebaseAuthException {
        // Create user in Firebase
        UserRecord firebaseUser = firebaseUserService.createUser(signupRequest);

        // Create local user and link with Firebase user ID
        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setEmailId(signupRequest.getEmail());
        user.setUsername(signupRequest.getEmail());
        user.setStatus("active");
        user.setCity(signupRequest.getCity());
        user.setCountry(signupRequest.getCountry());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setUserType(signupRequest.getUserType());
        user.setAddress(signupRequest.getAddress());
        user.setCultureId(signupRequest.getCulture());
        user.setUniversityId(signupRequest.getUniversity());
        user.setFirebaseId(firebaseUser.getUid());
        // Set other properties of user

        // Save local user to the database
        userRepository.save(user);

        return firebaseUser;
    }

    /**
     * Retrieves a user by its ID.
     * 
     * @param id the ID of the user to retrieve
     * @return an Optional containing the user if found
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieves a user by its entity user ID.
     * 
     * @param id the entity user ID
     * @return an Optional containing the user if found
     */
    public Optional<User> getUserByUserId(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Retrieves user details from Firestore by Firebase ID.
     * 
     * @param id the Firebase ID of the user
     * @return the user details if found
     * @throws InterruptedException if the thread is interrupted while fetching user details
     * @throws ExecutionException if an error occurs while fetching user details
     */
    public User getUserDetails(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(User.class);
        } else {
            return null;
        }
    }

    /**
     * Retrieves user metadata by Firebase ID.
     * 
     * @param id the Firebase ID of the user
     * @return the user metadata if found
     * @throws InterruptedException if the thread is interrupted while fetching user metadata
     * @throws ExecutionException if an error occurs while fetching user metadata
     */
    public User getUserMeta(String id) throws InterruptedException, ExecutionException {
        Optional<User> optionalUser = userRepository.findByFirebaseId(id);
        return optionalUser.orElse(null);
    }

    /**
     * Deletes a user by its Firebase ID from Firestore.
     * 
     * @param id the Firebase ID of the user to delete
     * @return a message indicating successful deletion
     * @throws InterruptedException if the thread is interrupted while deleting the user
     * @throws ExecutionException if an error occurs while deleting the user
     */
    public String deleteUser(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "Document with user id " + id + " has been deleted successfully";
    }

    /**
     * Retrieves all user details.
     * 
     * @return a list of all users
     */
    public List<User> getAllUserDetails() {
        return userRepository.findAll();
    }

    /**
     * Counts the total number of users.
     * 
     * @return the total number of users
     */
    public long countUsers() {
        return userRepository.count();
    }
}
