package com.fyp.groot.commons.utility;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class Utility {
	
	/*
	 * private static void fetchFirestoreData() throws IOException,
	 * InterruptedException { // Create the HttpClient HttpClient client =
	 * HttpClient.newHttpClient();
	 * 
	 * // Create the HttpRequest HttpRequest request = HttpRequest.newBuilder()
	 * .uri(URI.create(
	 * "https://firestore.googleapis.com/v1/projects/groot-a00c7/databases/(default)/documents/users/"
	 * )) .GET() // GET is default and can be omitted .build();
	 * 
	 * // Send the request and get the response HttpResponse<String> response =
	 * client.send(request, BodyHandlers.ofString());
	 * 
	 * // Output the response System.out.println(response.statusCode());
	 * System.out.println(response.body()); }
	 */

}
