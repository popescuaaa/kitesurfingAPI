package app.kitesurfing;

import app.kitesurfing.entities.Spot;
import app.kitesurfing.repositories.SpotsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KitesurfingApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitesurfingApplication.class, args);
	}

}
