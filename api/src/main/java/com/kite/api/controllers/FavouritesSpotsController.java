package com.kite.api.controllers;

import com.kite.api.entities.Spot;
import com.kite.api.services.ISpotService;
import netscape.javascript.JSException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/favourites")
public class FavouritesSpotsController {
    @Autowired
    ISpotService iSpotService;

    @GetMapping("spots")
    public String getAllFavouritesSpots() throws JSONException {
        List<Spot> favouriteSpots = iSpotService.findFavouritesSpots();
        JSONArray jsonArray = new JSONArray();
        for (Spot spot : favouriteSpots) {
            JSONObject jsonObject =  new JSONObject();
            jsonObject.put("name", spot.getName());
            jsonObject.put("country", spot.getCountry());
            jsonObject.put("latitude", spot.getLatitude());
            jsonObject.put("longitude", spot.getLongitude());
            jsonObject.put("id", spot.getId());
            jsonObject.put("windProbability", spot.getWindProbability());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString(4);
    }

    @GetMapping("add/{id}")
    public String addNewSpotToFavourites(@PathVariable(value = "id") Integer id) throws JSONException{
        if (id > iSpotService.findAll().size()) {
            return "Error not in range!";
        }

        List<Spot> spots = iSpotService.findAll();
        JSONArray jsonArray = new JSONArray();
        for (Spot spot : spots) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", spot.getId());
            jsonObject.put("name", spot.getName());
            jsonObject.put("latitude", spot.getLatitude());
            jsonObject.put("longitude",spot.getLongitude());
            jsonObject.put("country", spot.getCountry());
            jsonObject.put("windProbability", spot.getWindProbability());

        }



    }
}
