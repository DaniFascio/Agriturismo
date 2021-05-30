package it.faraday.agriturismo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/home")
	private ModelAndView home() {
		return new ModelAndView("homepage");
	}

}
