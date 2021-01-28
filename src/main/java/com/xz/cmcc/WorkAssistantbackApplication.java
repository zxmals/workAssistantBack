package com.xz.cmcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class WorkAssistantbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAssistantbackApplication.class, args);
	}
	
	@GetMapping(value= "/getstart/index")
	public String index() {
		return "/index";
	}

}
