package com.elo.elastic;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.google.gson.Gson;

public class Utils {

	/**
	 * Since this stupid javax.json API cannot convert a java object to a json one, this serves as stupid workaround.
	 * Object --gson--> String --javax--> JsonObject
	 * It's ugly, inefficient, but still better than writing pages of code.
	 * 
	 * @param obj
	 * @return
	 */
	public static JsonObject toJsonObject(Object obj) {
		Gson gson = new Gson();
        String jsonString = gson.toJson(obj);
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
	}
}
