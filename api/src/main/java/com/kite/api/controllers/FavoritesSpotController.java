package com.kite.api.controllers;

import com.kite.api.entities.Spot;
import com.kite.api.services.IFavoriteSpotsService;
import com.kite.api.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/favorites")
public class FavoritesSpotController {
    @Autowired
    private IFavoriteSpotsService iFavoriteSpotsService;

    // -------------------Retrieve all favorites spots----------------------------------------

    @GetMapping(value = "", produces = "application/json")
    public String getAllFavorites() throws JSONException {
        return JSONHelper.createJSONArray(iFavoriteSpotsService.findAll())
                        .toString(4);
    }

    // -------------------Add to favorites specific spot by id-----------------------------------

    @GetMapping(value = "{id}", produces = "application/json")
    public String addSpotToFavorites(@PathVariable(value = "id") Integer id) throws JSONException{
        return iFavoriteSpotsService.addSpot(id);
    }


    // -------------------Delete from  favorites specific spot by id-----------------------------

    @GetMapping(value = "del/{id}")
    public String deleteFromFavorites(@PathVariable(value = "id") Integer id) throws JSONException{
        return iFavoriteSpotsService.deleteSpot(id);
    }
}
