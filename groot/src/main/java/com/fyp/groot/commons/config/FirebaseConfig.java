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

@Configuration
public class FirebaseConfig {
	
    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
              new FileInputStream("./src/main/resources/ServiceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public FirebaseAuth firebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance());
    }
    
    
    @Bean
	public Firestore getFireStore(@Value("./src/main/resources/ServiceAccountKey.json") String credentialPath) throws IOException {
		var serviceAccount = new FileInputStream(credentialPath);
		var credentials = GoogleCredentials.fromStream(serviceAccount);

		var options = FirestoreOptions.newBuilder()
						.setCredentials(credentials).build();

		return options.getService();
	}


}
