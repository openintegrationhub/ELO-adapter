package com.elo.elastic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elo.elastic.model.EloObject;
import com.elo.elastic.model.EloObject.BaseType;
import com.elo.elastic.model.ExtendedEloObject;
import com.elo.ix4dummies.IX;
import com.elo.ix4dummies.sords.SimpleSord;
import com.elo.ix4dummies.sords.SordInfo;

import byps.RemoteException;
import de.elo.ix.client.EditInfoC;
import de.elo.ix.client.IXConnFactory;
import de.elo.ix.client.IXConnection;
import de.elo.ix.client.LockC;
import de.elo.ix.client.Sord;
import de.elo.ix.client.SordC;
import de.elo.ix.client.SordZ;
import io.elastic.api.ExecutionParameters;
import io.elastic.api.Message;
import io.elastic.api.Module;

public class UpdateObj extends IxOperation<Void> {

	@Override
	protected Void run(IX ix, JsonObject config) throws Exception {
		// input should match attributes of ExtendedEloObject
		SimpleSord ss = new SimpleSord();
		ss.info = new SordInfo();
		ss.info.id = Utils.getInt(config, "id");
		ss.info.guid = Utils.getString(config, "guid");
		ss.info.desc = Utils.getString(config, "description");
		ss.info.name = Utils.getString(config, "label");
		ss.info.parentId = Utils.getInt(config, "parentUid");
		
		// ignore the rest
		
		ix.sords.set(ss);
		
		return null;
	}
	
}