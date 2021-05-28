package it.faraday.agriturismo;

import it.faraday.agriturismo.repositories.CameraRepository;
import it.faraday.agriturismo.repositories.PersonaleRepository;
import it.faraday.agriturismo.repositories.PiattoRepository;
import it.faraday.agriturismo.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	@Autowired
	private PizzaRepository piattorepo;

	@Autowired
	private PiattoRepository pizzarepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void postConstruct() {
		piattorepo.findAll()
				.forEach(System.out::println);
		pizzarepo.findAll()
				.forEach(System.out::println);
	}

}
