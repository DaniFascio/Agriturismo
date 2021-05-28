package it.faraday.agriturismo.controllers;

import it.faraday.agriturismo.repositories.CameraRepository;
import it.faraday.agriturismo.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserServlet {


    @Autowired
    private UtenteRepository ur;

    @Autowired
    private CameraRepository camrep;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public ModelAndView registrationget(){

        ModelAndView mw = new ModelAndView("insert");
        mw.addObject("");

        return mw;

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView registrationpost(){

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
    public ModelAndView updatepost(){

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
    public ModelAndView home(){

        ModelAndView mw = new ModelAndView("home");

        return mw;
    }


}
