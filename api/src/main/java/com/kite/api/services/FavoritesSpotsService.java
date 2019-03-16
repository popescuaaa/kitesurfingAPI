package com.kite.api.services;

import com.kite.api.entities.Spot;
import com.kite.api.utils.JSONHelper;
import org.json.JSONArray;
import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoritesSpotsService implements IFavoriteSpotsService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    ISpotService iSpotService;

    public FavoritesSpotsService() {
        super();
    }

    @Override
    public List<Spot> findAll() {
        String sql = "SELECT * FROM favorites";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Spot.class));
    }

    @Override
    public String addSpot(Integer id) throws JSONException {
        String sql_mother = "SELECT * FROM spots";
        JSONArray jsonArray = JSONHelper
                .createJSONArray(jdbcTemplate.query(sql_mother, new BeanPropertyRowMapper<>(Spot.class)));
        Spot spot =  JSONHelper.createSpot(jsonArray.get(id));
        String sql = "INSERT INTO favorites(name,longitude,latitude,windProbability,country,whenToGo) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,spot.getName(),
                                spot.getLongitude(),
                                spot.getLongitude(),
                                spot.getWindProbability(),
                                spot.getCountry(),
                                spot.getWhenToGo());
        return JSONHelper.createJSONObject(spot).toString(4);
    }


    @Override
    public String deleteSpot(Integer id) throws JSONException {
        JSONArray jsonArray = JSONHelper.createJSONArray(findAll());
        String sql = "DELETE FROM favorites WHERE name=?";
        jdbcTemplate.update(sql,JSONHelper.createSpot(jsonArray.get(id)).getName());
        return JSONHelper.createJSONObject(JSONHelper.createSpot(jsonArray.get(id))).toString(4);
    }
}
