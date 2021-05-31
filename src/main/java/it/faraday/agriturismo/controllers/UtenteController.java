package it.faraday.agriturismo.controllers;

import it.faraday.agriturismo.Alert;
import it.faraday.agriturismo.models.*;
import it.faraday.agriturismo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static it.faraday.agriturismo.Application.*;

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
	private OrdinazionePiattoRepository ordinazionepiattorepo;
	@Autowired
	private OrdinazionePizzaRepository ordinazionepizzarepo;
	@Autowired
	private MetaRepository metarepo;
	@Autowired
	private TipoCameraRepository tipocamerarepo;
	@Autowired
	private CameraRepository camerarepo;
	@Autowired
	private AttivitaIppicaRepository attivitarepo;
	@Autowired
	private EscursioneRepository escursionerepo;
	@Autowired
	private PizzaRepository pizzarepo;
	@Autowired
	private PiattoRepository piattorepo;

	private final DateFormat timestampFormatter;
	private final DateTimeFormatter dateTimeFormatter;

	public UtenteController() {
		timestampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	@RequestMapping("/accedi")
	private ModelAndView accedi_view(Alert alert, Model model,
			@CookieValue(name = COOKIE_UTENTE, required = false) String usernameUtente) {

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
		Optional<Utente> utenteOpt = utenterepo.findByUsername(utente.getUsername());

		if(!utenteOpt.isPresent())
			action = "redirect:/utente/accedi?message=" + encode("Utente non registrato") + "&type=danger";
		else {

			Utente utenteDb = utenteOpt.get();
			String password = utenteDb.getPassword();

			if(password.equals(utente.getPassword())) {

				utenterepo.save(utenteDb);

				Cookie cookie = new Cookie(COOKIE_UTENTE, utenteDb.getUsername());
				cookie.setPath("/utente");
				response.addCookie(cookie);

				model.addAttribute("title", "Login Area Clienti");
				model.addAttribute("message", "Login effettuato");
				model.addAttribute("nextUrl", "/utente/areaCliente");
				return "success";

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

	@GetMapping("/areaCliente")
	private String areaCliente(Model model, Alert alert,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		//noinspection OptionalGetWithoutIsPresent
		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		if(alert.getMessage() == null)
			alert = null;
		else if(alert.getType() == null)
			alert.setType("primary");

		model.addAttribute("utente", utente);
		model.addAttribute("alert", alert);

		return "utente/areaCliente";
	}

	@GetMapping("/prenotazioneSoggiorno")
	private String prenotaSoggiorno_view(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("camere", camerarepo.findAll());
		model.addAttribute("tipi", tipocamerarepo.findAll());

		return "utente/prenotazioneSoggiorno";
	}

	@PostMapping("/prenotazioneSoggiorno/submit")
	private String prenotaSoggiorno_submit(Camera camera, Date dataCheckin, Date dataCheckout,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();
		Camera cameradb = camerarepo.findById(camera.getNumero())
				.get();

		Date datacheckin = dataCheckin;

		Date datacheckout = dataCheckout;


		PrenotazioneSoggiorno prenotazione = new PrenotazioneSoggiorno().setUtente(utente)
				.setCamera(camera)
				.setDataCheckin(datacheckin)
				.setDataCheckout(datacheckout);

		prenosoggiornorepo.save(prenotazione);


		return "redirect:/utente/areaCliente?message=" + encode("Prenotazione effettuata") + "&type=success";
	}

	@GetMapping("/prenotazioneAttivitaIppica")
	private String prenotaAttivitaIppica_view(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("attivitaippica", attivitarepo.findAll());

		return "utente/prenotazioneAttivitaIppica";
	}

	@PostMapping("/prenotazioneAttivitaIppica/submit")
	private String prenotaAttivitaIppica_submit(AttivitaIppica attivitaIppica,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();
		AttivitaIppica attivitaIppicadb = attivitarepo.findById(attivitaIppica.getId())
				.get();

		Date data = new Date();

		PrenotazioneAttivitaIppica prenotazione = new PrenotazioneAttivitaIppica().setUtente(utente)
				.setAttivitaIppica(attivitaIppica)
				.setData(data);

		prenoattivitarepo.save(prenotazione);

		return "redirect:/utente/areaCliente?message=" + encode("Prenotazione effettuata") + "&type=success";
	}

	@GetMapping("/prenotazioneEscursione")
	private String prenotaEscursione_view(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("escursioni", escursionerepo.findAll());
		model.addAttribute("mete", metarepo.findAll());

		return "utente/prenotazioneEscursione";
	}

	@PostMapping("/prenotazioneEscursione/submit")
	private String prenotaEscursione_submit(Escursione escursione,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();
		Escursione escursioneDb = escursionerepo.findById(escursione.getId())
				.get();

		Date data = new Date();

		PrenotazioneEscursione prenotazione = new PrenotazioneEscursione().setUtente(utente)
				.setEscursione(escursione)
				.setData(data);

		prenoescursionerepo.save(prenotazione);

		return "redirect:/utente/areaCliente?message=" + encode("Prenotazione effettuata") + "&type=success";
	}

	@GetMapping("/ordinazioneRistorante")
	private String ordinaRistorante_view(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("camera", camerarepo.findAll());

		return "utente/ordinazioneRistorante";
	}

	@PostMapping("/ordinazioneRistorante/submit")
	private String ordinaRistorante_submit(Piatto piatto,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();
		Piatto piattoDb = piattorepo.findById(piatto.getId())
				.get();

		Date data;
/*
		OrdinazionePiatto ordinazionePiatto = new OrdinazionePiatto().setUtente(utente)
				.setPiatto(piatto)
				.setData(data);

		ordinazionepiattorepo.save(ordinazionePiatto);
*/
		return "redirect:/utente/areaCliente?message=" + encode("Ordinazione effettuata") + "&type=success";
	}

	@GetMapping("/ordinazionePizzeria")
	private String ordinaPizzeria_view(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("camera", camerarepo.findAll());

		return "utente/ordinazionePizzeria";
	}

	@PostMapping("/ordinazionePizzeria/submit")
	private String ordinaPizzeria_submit(Pizza pizza,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();
		Pizza pizzaDb = pizzarepo.findById(pizza.getId())
				.get();

		Date data;
/*
		OrdinazionePizza ordinazionePizza = new OrdinazionePizza().setUtente(utente)
				.setPizza(pizza)
				.setData(data);

		ordinazionepizzarepo.save(ordinazionePizza);
*/
		return "redirect:/utente/areaCliente?message=" + encode("Ordinazione effettuata") + "&type=success";
	}

	@GetMapping("/visualizzaPrenotazioniPiatti")
	private String viewPrenotazioniPiatti(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("piatto", piattorepo.findAll());

		return "utente/visualizzaPrenotazioniPiatti";
	}

	@GetMapping("/visualizzaPrenotazioniPizze")
	private String viewPrenotazioniPizze(Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		if(usernameUtente == null)
			return "redirect:/utente/accedi";

		Utente utente = utenterepo.findByUsername(usernameUtente)
				.get();

		model.addAttribute("utente", utente);
		model.addAttribute("pizza", pizzarepo.findAll());

		return "utente/visualizzaPrenotazioniPiatti";
	}

	@GetMapping("/logout")
	private String logout(HttpServletResponse response, Model model,
			@CookieValue(value = COOKIE_UTENTE, required = false) String usernameUtente) {

		Cookie cookie = new Cookie(COOKIE_UTENTE, "");
		cookie.setMaxAge(1);
		response.addCookie(cookie);

		model.addAttribute("title", "Logout pazienti");
		model.addAttribute("message", "Logout effettuato correttamente");
		model.addAttribute("nextUrl", "/");

		return "success";
	}

	@RequestMapping("/home")
	public ModelAndView home() {

		ModelAndView mw = new ModelAndView("home");

		return mw;
	}

}
