/**
 *  For non logged in users we'll keep a temporary favourites spots list
 *  which will be deleted at the end of session
 */
package com.kite.api.services;


import com.kite.api.entities.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotService implements ISpotService {
    private static final Integer INITIAL_SIZE_TEMPORARY_ARRAY = 10;
    private JSONArray favouritesSpots = new JSONArray();



    @Autowired
    JdbcTemplate jdbcTemplate;

    public SpotService() {
        super();
    }


    @Override
    public List<Spot> findAll() {
        String sql = "SELECT * FROM spots";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Spot.class));
    }

    @Override
    public List<String> findAllCountries() {
        String sql = "SELECT * FROM spots";
        List<Spot> spots = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Spot.class));
        List<String> countries = new ArrayList<>();
        for (Spot spot : spots) countries.add(spot.getCountry());
        return countries;
    }

    @Override
    public Boolean addNewSpotToFavourites(JSONObject spot) {
        if (spot == null) {
            return false;
        } else {
            favouritesSpots.put(spot);
            return true;
        }
    }

    @Override
    public Boolean deleteFromFavourites(Integer id) {
        try {

            if (favouritesSpots.get(id) == null) {
                return false;
            } else {
                favouritesSpots.remove(id);
                return true;
            }
        } catch (JSONException e) {
            return false;
        }
    }

    @Override
    public List<Spot> findFavouritesSpots() {
        return favouritesSpots;
    }


}
