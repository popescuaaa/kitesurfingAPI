package app.kitesurfing.controllers;

import app.kitesurfing.entities.Spot;
import app.kitesurfing.repositories.SpotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class spotsController {
    @Autowired(required = true)
    private SpotsRepository repository;

    @ResponseBody
    @GetMapping("/api/spots")
    public Iterable<Spot> spotsResponseAll(){
       return this.repository.findAll();
    }


}
