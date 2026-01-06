package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication //main entry point for Spring Boot application.
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}

@RestController// tells Spring that this class will handle HTTP requests.
class HelloController{
	
	@GetMapping("/hello") //a GET request is made to /hello, this method will return "Hello, Spring Boot!".
	public String sayHello() {
		return "Hello, Spring Boot!";
	}

	//When a POST request is made to /greet, the name sent in the request body will be returned in the response as "Hello, [name]!".
	@PostMapping("/greet")
	public String greet(@RequestBody String name) { //@RequestBody binds the request body to the method parameter (name in this case).
		return "Hello, "+ name+ "!";
	}
}
