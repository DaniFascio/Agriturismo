package controllers;

import com.sun.corba.se.spi.ior.ObjectId;
import models.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repositories.CameraRepository;
import repositories.CarrelloRepository;
import repositories.UtenteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserServlet {


    @Autowired
    private UtenteRepository ur;

    @Autowired
    private CarrelloRepository carrep;

    @Autowired
    private CameraRepository camrep;


    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView registrationget(){

        ModelAndView mw = new ModelAndView("insert");
        mw.addObject("");

        return mw;

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView registrationpost(@RequestParam String actors, @RequestParam String description,
                                   @RequestParam int duration, @RequestParam String genre, @RequestParam String languages,
                                   @RequestParam double price, @RequestParam int publishYear, @RequestParam String subtitles,
                                   @RequestParam String title){

        ModelAndView mw = new ModelAndView("insert");
        List<Utente> lista = Arrays.stream(actors.split(";")).map(Utente::new).collect(Collectors.toList());
     //   ur.insert(new Utente());



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
    public ModelAndView updatepost(@RequestParam String id, @RequestParam String actors, @RequestParam String description,
                                   @RequestParam int duration, @RequestParam String genre, @RequestParam String languages,
                                   @RequestParam double price, @RequestParam int publishYear, @RequestParam String subtitles,
                                   @RequestParam String title){

        ModelAndView mw;

        mw = new ModelAndView("update");

        List<Utente> lista = Arrays.stream(actors.split(";")).map(Utente::new).collect(Collectors.toList());
       // ur.save(new Utente(new ObjectId(id),lista,description,duration,genre,languages.split(";"),price,publishYear,subtitles.split(";"),title));


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
    public ModelAndView home(){

        ModelAndView mw = new ModelAndView("home");

        return mw;
    }


}
