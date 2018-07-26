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

import com.google.gson.Gson;

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

public class GetSord implements Module {
	private static final Logger logger = LoggerFactory.getLogger(GetSord.class);

	final static long DEFAULT_MEMBERS = SordC.mbDesc | SordC.mbXDate | SordC.mbIDate | SordC.mbDocVersion;
	
	/**
	 * Executes the trigger's logic by sending a request to the Petstore API and
	 * emitting response to the platform.
	 *
	 * @param parameters execution parameters
	 */
	@Override
	public void execute(final ExecutionParameters parameters) {
		logger.info("Getting SORD...");

		JsonObject jsonObj = null;
		try {
			Sord sord = getSord(parameters);
			jsonObj = Utils.toJsonObject(sord);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		logger.info("Emitting data");
		Message data = new Message.Builder().body(jsonObj).build();
		parameters.getEventEmitter().emitData(data);
	}

	public Sord getSord(ExecutionParameters parameters) throws RemoteException {
		final JsonObject configuration = parameters.getConfiguration();
		String id = parameters.getConfiguration().getString("id");
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("ID is required");
		}
		logger.info("Getting SORD id=" + id);
		IxWrapper wrapper = new IxWrapper(configuration);
		Sord sord = wrapper.ix().checkoutSord(id, new SordZ(DEFAULT_MEMBERS), LockC.NO);
		wrapper.close();
		return sord;
	}

}