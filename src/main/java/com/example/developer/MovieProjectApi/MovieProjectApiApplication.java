package com.example.developer.MovieProjectApi;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.developer.MovieProjectApi.controller.FilmCLI;

@SpringBootApplication
public class MovieProjectApiApplication {

	// public static void main(String[] args) {
	// 	SpringApplication.run(MovieProjectApiApplication.class, args);
	// }

	public static void main(String[] args) {
		FilmCLI filmCLI = new FilmCLI();
		filmCLI.loginPage();
	}

}
