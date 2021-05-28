package it.faraday.agriturismo;

import it.faraday.agriturismo.repositories.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	@Autowired
	private CameraRepository camerarepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	private void postConstruct() {
		camerarepo.findAll()
				.forEach(System.out::println);
	}

}
