package com.elo.elastic;

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
import com.elo.ix4dummies.IX;

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

public class CreateDoc extends IxOperation<Integer> {

	@Override
	protected Integer run(IX ix, JsonObject config) throws Exception {
		String parentId = Utils.getGuidOrId(config);
		String name = Utils.getString(config, "label");
		String maskId = Utils.getString(config, "maskId");
		int type = Utils.getInt(config, "type");
		
		String url = config.getString("url");
		String filename = Utils.getString(config, "filename");
		String mimetype = Utils.getString(config, "mimetype");
		String versionLabel = Utils.getString(config, "versionLabel");
		
		
		URL urlConn = new URL(url);
		InputStream stream = urlConn.openStream();
		
		int id = ix.sords.addDoc(parentId, name, maskId, type);
		ix.sords.upload("" + id, stream, filename, mimetype, versionLabel);
		return id;
	}
	

}