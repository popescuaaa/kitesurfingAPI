/**
 *  This class purpoe is to help with representing the jsonObjects
 */
package com.kite.api.utils;

import com.kite.api.entities.Spot;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JSONHelper {
    /**
     *
     * @param spots
     * @return new JSONArray with JSONObjects mapping the spot objects
     * @throws JSONException
     */
    public static JSONArray createJSONArray(List<Spot> spots) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Spot spot : spots) {
            jsonArray.put(createJSONObject(spot));
        }
        return jsonArray;
    }

    /**
     *
     * @param spot
     * @return new JSONObject with spot parameters
     * @throws JSONException
     */
    public static JSONObject createJSONObject(Spot spot) throws JSONException {
        JSONObject jsonObject  = new JSONObject();

        // Mapping process for the JSONObject
        jsonObject.put("id", spot.getId());
        jsonObject.put("name", spot.getName());
        jsonObject.put("latitude", spot.getLatitude());
        jsonObject.put("longitude", spot.getLongitude());
        jsonObject.put("country" , spot.getCountry());
        jsonObject.put("windProbability", spot.getWindProbability());
        jsonObject.put("whenToGo", spot.getWhenToGo());

        return jsonObject;
    }

    /**
     *
     * @param jsonObject
     * @return new spot with json parameters
     * @throws JSONException
     */
    public static Spot createSpot(Object jsonObject) throws JSONException{
        JSONObject _jsonObject = (JSONObject) jsonObject;
        return new Spot(_jsonObject.get("name").toString(),
                        Double.parseDouble(_jsonObject.get("latitude").toString()),
                        Double.parseDouble(_jsonObject.get("longitude").toString()),
                        Integer.parseInt(_jsonObject.get("windProbability").toString()),
                        _jsonObject.get("country").toString(),
                        _jsonObject.get("whenToGo").toString());
    }
}
