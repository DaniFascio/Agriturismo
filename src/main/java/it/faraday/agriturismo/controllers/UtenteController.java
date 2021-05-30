package it.faraday.agriturismo.controllers;

import it.faraday.agriturismo.models.Utente;
import it.faraday.agriturismo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/utente")
public class UtenteController {

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
	private ModelAndView accedi_view(){

		ModelAndView mav = new ModelAndView("utente/accesso");

		return mav;

	}

	@GetMapping("/registrati")
	private ModelAndView registrati_view() {

		ModelAndView mav = new ModelAndView("utente/registrazione");

		return mav;
	}

	@PostMapping("/registrati/submit")
	private String registrati_submit(Utente utente) {

		utenterepo.save(utente);

		return "redirect:/paziente/accedi?message=" + "Utente registrato con successo";
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
