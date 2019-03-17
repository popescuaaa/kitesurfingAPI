package com.api.resources.controllers;

import com.api.resources.services.ISpotService;
import com.api.resources.utils.JSONErrors;
import com.api.resources.utils.JSONHelper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "api")
public class SpotController {
    @Autowired
    ISpotService iSpotService;

    @GetMapping(value = "spots", produces = "application/json")
    public String findAllSpots() throws JSONException {
        return JSONHelper.createJSONArray(iSpotService.findAll()).toString(4);
    }

    @GetMapping(value = "spots/countries", produces = "application/json")
    public String findAllCountries() throws JSONException {
        return JSONHelper.createJSONArrayFromStrings(iSpotService.findAllCountries()).toString(4);
    }

    @GetMapping(value = "spots/windProbabilities", produces = "application/json")
    public String findAllWindProbabilities() throws JSONException {
        return JSONHelper.createJSONArrayFromIntegers(iSpotService.findAllWindProbability()).toString(4);
    }

    @GetMapping(value = "spots/{id}", produces = "application/json")
    public String getSpotById(@PathVariable(value = "id") Integer id) throws JSONException {
        if (id < 1)
            return JSONErrors.NO_RECORD_WITH_ID().toString(4);
        else
            return JSONHelper.createJSONObject(iSpotService.findById(id)).toString(4);
    }

    @GetMapping(value = "favorites/spots", produces = "application/json")
    public String findAllFavorites() throws JSONException{
        if (iSpotService.findAllFavorites().size() == 0)
            return JSONErrors.NO_RECORDS_IN_DB().toString(4);
        else
            return JSONHelper.createJSONArray(iSpotService.findAllFavorites()).toString(4);
    }

    @GetMapping(value = "favorites/spots/{id}")
    public String addToFavorite(@PathVariable(value = "id") Integer id) throws JSONException{
        if (id < 0)
            return JSONErrors.NO_RECORD_WITH_ID().toString(4);
        else {
            iSpotService.addToFavorite(id);
            return "Success!";
        }
    }

    @GetMapping(value = "favorites/spots/del/{id}")
    public String deleteFromFavorites(@PathVariable(value = "id") Integer id) throws JSONException{
        if (id < 0)
            return JSONErrors.NO_RECORD_WITH_ID().toString(4);
        else {
            iSpotService.deleteFromFavorites(id);
            return "Success!";
        }
    }
}
