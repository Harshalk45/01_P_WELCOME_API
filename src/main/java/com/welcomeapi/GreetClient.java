package com.welcomeapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetClient {
   
	@GetMapping("/greet")
	public String invokeGreetApi();
}
