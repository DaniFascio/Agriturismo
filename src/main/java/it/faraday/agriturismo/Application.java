package it.faraday.agriturismo;

import it.faraday.agriturismo.models.AttivitaIppica;
import it.faraday.agriturismo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	@Autowired
	private AttivitaIppicaRepository attivitarepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void postConstruct() {

		attivitarepo.findAll()
				.forEach(System.out::println);

	}

}
