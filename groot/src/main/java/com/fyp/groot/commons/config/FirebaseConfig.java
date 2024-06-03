package com.fyp.groot.commons.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * FirebaseConfig class for configuring Firebase services such as Firebase Authentication and Firestore.
 */
@Configuration
public class FirebaseConfig {

    /**
     * Initializes the Firebase application using the service account credentials.
     * This method is called after the bean's properties have been set.
     */
    @PostConstruct
    public void initialize() {
        try {
            // Path to the service account key file
            FileInputStream serviceAccount =
              new FileInputStream("./src/main/resources/ServiceAccountKey.json");

            // Configure Firebase options
            FirebaseOptions options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .build();

            // Initialize the Firebase application if it hasn't been initialized yet
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs
            e.printStackTrace();
        }
    }

    /**
     * Provides a FirebaseAuth instance as a Spring Bean.
     * 
     * @return an instance of FirebaseAuth
     */
    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance());
    }

    /**
     * Provides a Firestore instance as a Spring Bean.
     * 
     * @param credentialPath the path to the service account key file
     * @return an instance of Firestore
     * @throws IOException if an input or output exception occurred
     */
    @Bean
    public Firestore getFireStore(@Value("./src/main/resources/ServiceAccountKey.json") String credentialPath) throws IOException {
        // Load the service account credentials
        var serviceAccount = new FileInputStream(credentialPath);
        var credentials = GoogleCredentials.fromStream(serviceAccount);

        // Configure Firestore options
        var options = FirestoreOptions.newBuilder()
                        .setCredentials(credentials).build();

        // Return the Firestore service instance
        return options.getService();
    }
}
