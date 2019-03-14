package com.kite.api.controllers;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.kite.api.entities.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kite.api.services.ISpotService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/spots")
public class SpotController {
    @Autowired
    private ISpotService iSpotService;

    // -------------------Filter methods explained----------------------------------------
    @GetMapping("filters")
    public String getFilterMethods() throws JSONException{
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keyword"," - > effect");
        jsonObject.put("countries", "get all spots countries");
        jsonObject.put("windProbability", "get all spots windProbability");
        jsonObject.put("windProbability%lowerBound%upperBound",
                "filter windProbability in specific interval");
        jsonObject.put("%id", "get specific spot with specific id");
        jsonObject.put("coordinates", "get all spots coordinates - latitude and longitude");
        jsonObject.put("coordinates%aproximateLatitude%aproximateLogitude",
                "filter all spots coordinates in specific range");

        jsonArray.put(jsonObject);
        return jsonArray.toString(4);

    }

    // -------------------Retrieve All Spots-----------------------------------------------

    @GetMapping(value = "", produces = "application/json")
    public String getAllSpots() throws JSONException{
               List<Spot> spots = iSpotService.findAll();
        if (spots.isEmpty()) {
            return "ERROR 404!";
        }

        JSONArray jsonArray = new JSONArray();
        for (Spot spot : spots) {
            JSONObject jsonObject = new JSONObject();

            // Mapping the Spot Object to JSON
            jsonObject.put("name", spot.getName());
            jsonObject.put("longitude", spot.getLongitude());
            jsonObject.put("latitude", spot.getLatitude());
            jsonObject.put("windProbability", spot.getWindProbability());
            jsonObject.put("country", spot.getCountry());
            jsonObject.put("whenToGo", spot.getWhenToGo());

            // inserting into response
            jsonArray.put(jsonObject);
        }

        return jsonArray.toString(4);
    }

    // Filters

    // -------------------Retrieve All Spots Countries--------------------------------------

    @GetMapping(value = "countries", produces = "application/json")
    public String getAllSpotsCountries() throws JSONException{
        List<String> countries  = iSpotService.findAllCountries();

        if (countries.isEmpty()) {
            return "NO COUNTRY AVAILABLE!";
        }

        JSONArray jsonArray = new JSONArray();
        for (String country : countries) {
            JSONObject jsonObject = new JSONObject();

            // Mapping the Country Object to JSON
           jsonObject.put("country", country);

            // inserting into response
            jsonArray.put(jsonObject);
        }

        return jsonArray.toString(4);
    }

    // -------------------Retrieve Spot By Index--------------------------------------------

    @GetMapping("{id}")
    public String getSpotById(@PathVariable(value = "id") Integer id) throws JSONException{
        List<Spot> spots = iSpotService.findAll();
        if (spots.isEmpty()) {
            return "NO SPOTS IN DB WITH THIS ID!";
        }

        JSONArray iterableSpots =  new JSONArray();
        for (Spot spot : spots) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", spot.getId());
            jsonObject.put("name", spot.getName());
            jsonObject.put("country", spot.getCountry());
            jsonObject.put("windProbability", spot.getWindProbability());
            jsonObject.put("whenToGo", spot.getWindProbability());
            jsonObject.put("latitude", spot.getLatitude());
            jsonObject.put("longitude", spot.getLongitude());
            iterableSpots.put(jsonObject);
        }
        return iterableSpots.get(id).toString();
    }

    // -------------------Retrieve All Spots WindProbability---------------------------------

    @GetMapping("windProbability")
    public String getAllSpotsWindProbability() throws JSONException{
        List<Spot> spots = iSpotService.findAll();
        JSONArray jsonArray = new JSONArray();
        for (Spot spot : spots) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("windProbability", spot.getWindProbability());
            jsonArray.put(jsonObject);
        }

        return jsonArray.toString(4);
    }



}
