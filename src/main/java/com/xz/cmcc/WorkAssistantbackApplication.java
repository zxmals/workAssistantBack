package com.xz.cmcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WorkAssistantbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAssistantbackApplication.class, args);
	}
	
	@RequestMapping(value= "/index",method=RequestMethod.GET)
	public String hello(String username) {
		return " 欢迎 !";
	}

}
