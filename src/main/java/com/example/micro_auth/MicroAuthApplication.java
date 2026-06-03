package com.example.micro_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

@SpringBootApplication
=======
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
public class MicroAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAuthApplication.class, args);
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
