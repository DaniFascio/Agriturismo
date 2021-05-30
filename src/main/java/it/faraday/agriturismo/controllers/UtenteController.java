package it.faraday.agriturismo.controllers;

import it.faraday.agriturismo.Alert;
import it.faraday.agriturismo.models.Utente;
import it.faraday.agriturismo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static it.faraday.agriturismo.Application.encode;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	private static final String COOKIE_UTENTE = "utente.cod";

	@Autowired
	private UtenteRepository utenterepo;
	@Autowired
	private PrenotazioneAttivitaIppicaRrepository prenoattivitarepo;
	@Autowired
	private PrenotazioneEscursioneRepository prenoescursionerepo;
	@Autowired
	private PrenotazioneSoggiornoRepository prenosoggiornorepo;
	@Autowired
	private CameraRepository camrepo;

	private final DateFormat timestampFormatter;
	private final DateTimeFormatter dateTimeFormatter;

	public UtenteController() {
		timestampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	@RequestMapping("/accedi")
	private ModelAndView accedi_view(Alert alert, Model model,
			@CookieValue(name = COOKIE_UTENTE, required = false) String codUtente){

		ModelAndView mav = new ModelAndView("utente/accesso");

		if(alert.getMessage() == null)
			alert = null;
		else if(alert.getType() == null)
			alert.setType("primary");

		mav.addObject("alert", alert);

		return mav;
	}

	@PostMapping("/accedi/submit")
	private String accedi_submit(Utente utente, HttpServletResponse response, Model model) {

		String action;
		Optional<Utente> utenteOpt = utenterepo.findById(utente.getId());

		if(!utenteOpt.isPresent())
			action = "redirect:/utente/accedi?message=" + encode("Utente non registrato") + "&type=danger";
		else {

			Utente utenteDb = utenteOpt.get();
			String password = utenteDb.getPassword();

			if(password.equals(utente.getPassword())) {

				utenterepo.save(utenteDb);

				Cookie cookie = new Cookie(COOKIE_UTENTE, String.valueOf(utenteDb.getId()));
				cookie.setPath("/utente");
				response.addCookie(cookie);

				model.addAttribute("title", "Login Area Clienti");
				model.addAttribute("message", "Login effettuato");
				model.addAttribute("nextUrl", "/utente/areaClienti");
				action = "action_success";

			} else
				action = "redirect:/utente/accedi?message=" + encode("Password errata") + "&type=danger";
		}

		return action;
	}

	@GetMapping("/registrati")
	private ModelAndView registrati_view(Alert alert) {

		ModelAndView mav = new ModelAndView("utente/registrazione");

		if(alert.getMessage() == null)
			alert = null;
		else if(alert.getType() == null)
			alert.setType("primary");

		mav.addObject("alert", alert);

		return mav;
	}

	@PostMapping("/registrati/submit")
	private String registrati_submit(Utente utente) {

		utenterepo.save(utente);

		return "redirect:/utente/accedi?message=" + encode("Utente registrato con successo");
	}


	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView registrationpost() {

		ModelAndView mw = new ModelAndView("insert");
		return new ModelAndView("redirect:/home");
	}

/*
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateget(@RequestParam String id){


        ModelAndView mw;
        Optional<Movie> mo = mr.findById(new ObjectId(id));
        if(mo.isPresent()){
            mw = new ModelAndView("update");
            mw.addObject("movie",mo.get());
        }
        else
            mw = new ModelAndView("error404");

        return mw;
    }
*/

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatepost() {

		ModelAndView mw;

		mw = new ModelAndView("update");


		return new ModelAndView("redirect:/home");
	}


 /*
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam String id) {


       ModelAndView mw;
        Optional<Utente> mo = ur.findById(new ObjectId(id));
        if(mo.isPresent()) {
            mw = new ModelAndView("home");
            mw.addObject("movies", ur.findAll());
            ur.delete(mo.get());
        }
        else
            new ModelAndView("error404");

        return new ModelAndView("confirmdel");
    }
*/

	@RequestMapping("/home")
	public ModelAndView home() {

		ModelAndView mw = new ModelAndView("home");

		return mw;
	}

}
