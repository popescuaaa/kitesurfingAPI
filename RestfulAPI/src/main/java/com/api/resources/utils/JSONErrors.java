package com.api.resources.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONErrors {
    private static JSONArray jsonArray = new JSONArray();
    private static JSONObject message = new JSONObject();
    private static JSONObject errorCode = new JSONObject();

    public static JSONArray NO_RECORD_WITH_ID() throws JSONException {


        message.put("message", "The index provided is not in range. The index must be greater than 1!");
        errorCode.put("errorCode", "IndexOutOfRange");
        jsonArray.put(message);
        jsonArray.put(errorCode);

        return jsonArray;
    }

    public static JSONArray NO_RECORDS_IN_DB() throws JSONException {


        message.put("message", "There are no records in the DB!");
        errorCode.put("errorCode", "EmptyDB");
        jsonArray.put(message);
        jsonArray.put(errorCode);

        return jsonArray;
    }

    public static JSONArray NO_USER_LOGGED() throws JSONException {


        message.put("message", "You are currently in Incognito Mode. There is no user logged!");
        errorCode.put("errorCode", "noUserLogged");
        jsonArray.put(message);
        jsonArray.put(errorCode);

        return jsonArray;
    }
}
