package com.api.resources.utils;

import com.api.resources.entities.Spot;
import com.api.resources.entities.User;
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
    public static  JSONArray createJSONArray(List<Spot> spots) throws JSONException {
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

    /**
     *
     * @param country
     * @return
     * @throws JSONException
     */
    public static JSONObject createJSONObject(String country) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("country", country);
        return jsonObject;
    }

    /**
     *
     * @param countries
     * @return
     * @throws JSONException
     */
    public static JSONArray createJSONArrayFromStrings(List<String> countries) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (String string : countries) {
            jsonArray.put(createJSONObject(string));
        }

        return jsonArray;
    }

    /**
     *
     * @param integer
     * @return
     * @throws JSONException
     */
    public static JSONObject createJSONObject(Integer integer) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("windProbability", integer);
        return jsonObject;

    }

    /**
     *
     * @param integers
     * @return
     * @throws JSONException
     */
    public static JSONArray createJSONArrayFromIntegers(List<Integer> integers) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Integer integer :  integers) {
            jsonArray.put(createJSONObject(integer));
        }
        return jsonArray;
    }

    /**
     *
     * @param user
     * @return
     * @throws JSONException
     */
    public static JSONObject createJSONObject(User user) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user.getName());
        if (user.isLogedIn())
            jsonObject.put("status", "ACTIVE");
        else
            jsonObject.put("status", "INACTIVE");

        return jsonObject;
    }

    /**
     *
     * @param users
     * @return
     * @throws JSONException
     */
    public static JSONArray allUserInSystem(List<User> users) throws JSONException{
        JSONArray jsonArray = new JSONArray();
        for (User user : users) {
            jsonArray.put(createJSONObject(user));
        }

        return jsonArray;
    }

    public static JSONObject forgotPassword(String password) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Forgotten password", password);
        jsonObject.put("Status","Please require admin advice in future!");
        return jsonObject;
    }

}
