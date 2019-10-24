package com.elo.elastic;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.elo.elastic.model.EloObject;
import com.elo.elastic.model.EloObject.BaseType;
import com.elo.elastic.model.ExtendedEloObject;
import com.elo.ix4dummies.sords.SimpleSord;
import com.elo.ix4dummies.sords.SordInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.elo.ix.client.Sord;

public class Utils {

	static final ObjectMapper MAPPER = new ObjectMapper(); 
	/**
	 * Since this stupid javax.json API cannot convert a java object to a json one, or vice versa, this serves as stupid workaround.
	 * Object --jackson--> JSON String --javax--> JsonObject
	 * It's ugly, inefficient, but still better than writing pages of code.
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException 
	 */
	public static JsonObject toJsonObject(Object obj) throws JsonProcessingException {
		String jsonString = Utils.toJsonString(obj);
        JsonObject jsonObject = toJsonObject(jsonString);
        return jsonObject;
	}
	
	public static JsonObject toJsonObject(String jsonString) throws JsonProcessingException {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
	}
	
	public static String toJsonString(Object obj) throws JsonProcessingException {
		String jsonString = MAPPER.writeValueAsString(obj);
        return jsonString;
	}
	
	public static String getString(JsonObject config, String key) {
		if (!config.containsKey(key) || config.getString(key).isEmpty())
			return null;
		else
			return config.getString(key);
	}
	
	public static Integer getInt(JsonObject config, String key) {
		String val = getString(config, key);
		return val != null ? Integer.valueOf(config.getString(key)) : 0;
	}
	/*
	public static String getGuidOrId(JsonObject config) {
		if( config.containsKey("guid") )
			return config.getString("guid");
		else if( config.containsKey("id") )
			return config.getString("id");
		else if( config.containsKey("path") )
			return config.getString("path");
		else
			throw new IllegalArgumentException("Missing guid, id or path in config parameters: " + config);
	}
	*/
	
	public static ExtendedEloObject toEloObject(SimpleSord ss) {
		ExtendedEloObject eloObj = toEloObject(ss.info);
		eloObj.setPath(ss.raw().getRefPaths()[0].getPathAsString());
		//eloObj.setMetadata(null);
		return eloObj;
	}
	
	public static ExtendedEloObject toEloObject(SordInfo info) {
		ExtendedEloObject eloObj = new ExtendedEloObject();
		eloObj.id = info.id;
		eloObj.guid = info.guid;
		eloObj.setLabel(info.name);
		eloObj.setDescription(info.desc);
		eloObj.setBaseType(info.isDir ? BaseType.FOLDER : BaseType.DOCUMENT);
		eloObj.setParentUid("" + info.parentId);
		
		eloObj.setMetadata(null);
		return eloObj;
	}
	
	
}
