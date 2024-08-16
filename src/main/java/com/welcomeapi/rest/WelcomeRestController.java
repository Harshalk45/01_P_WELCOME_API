package com.welcomeapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.welcomeapi.GreetClient;
import com.welcomeapi.Pet;
import com.welcomeapi.response.WelcomeResponse;


public class WelcomeRestController {
    
	@Autowired
	private GreetClient greetClient;
	
	@GetMapping("/welcome")
	public WelcomeResponse getWelcomeMSgString() {
		
		String welcomeMsg = "Welcome To Ashok It...!!";
		
		// interservice communication
		String greetMsg = greetClient.invokeGreetApi();
		
		// external service communication
		RestTemplate rt = new RestTemplate();
		String petEndPointUrl = "URL";
		ResponseEntity<Pet> entity = rt.getForEntity(petEndPointUrl, Pet.class);
		Pet petData = entity.getBody();
		
		WelcomeResponse finalResponse = new WelcomeResponse();
		finalResponse.setGreetMsg(greetMsg);
		finalResponse.setWelcomeMsg(welcomeMsg);
		finalResponse.setPet(petData);
		
		
		return finalResponse;	
	}
}
