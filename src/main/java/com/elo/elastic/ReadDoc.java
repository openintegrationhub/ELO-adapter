package com.elo.elastic;

import java.io.StringReader;

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
import com.elo.ix4dummies.sords.SordFeature;

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

public class ReadDoc extends IxOperation<ExtendedEloObject> {

	@Override
	protected ExtendedEloObject run(IX ix, JsonObject config) throws Exception {
		String guid = Utils.getString(config, "uid");		
		SimpleSord ss = ix.sords.get(guid, SordFeature.INFO, SordFeature.CONTENT);
		ExtendedEloObject obj = Utils.toEloObject(ss);
		obj.url = ss.content.url;
		return obj;
	}
}