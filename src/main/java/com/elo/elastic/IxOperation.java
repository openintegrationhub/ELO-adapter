package com.elo.elastic;

import javax.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elo.elastic.model.EloObject;
import com.elo.elastic.model.EloObject.BaseType;
import com.elo.ix4dummies.IX;
import com.elo.ix4dummies.IxServer;

import byps.RemoteException;
import de.elo.ix.client.LockC;
import de.elo.ix.client.Sord;
import de.elo.ix.client.SordZ;
import io.elastic.api.ExecutionParameters;
import io.elastic.api.Message;
import io.elastic.api.Module;

public abstract class IxOperation<R> implements Module {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadDoc.class);
	
	
	/**
	 * Executes the trigger's logic.
	 *
	 * @param parameters execution parameters
	 */
	@Override
	public void execute(final ExecutionParameters parameters) {
		logger.info("Extracting parameters...");
		
		JsonObject config = parameters.getConfiguration();
		
		String ixUrl = config.getString("ixUrl");
		IxServer ixServer = new IxServer(ixUrl, "OIH", "1.0");
    	
		IX ix = null;
    	try {
    		logger.info("Connecting to IX...");
        	String username = config.getString("username");
        	String password = config.getString("password");
        	String language = config.getString("language");
    		ix = ixServer.login(username, password, language);
    		
    		logger.info("Running " + this.getClass() + "...");
			R result = run(ix, config);
			
			if( result != null ) {
				logger.info("Sending response...");
				JsonObject jsonObj = Utils.toJsonObject(result);
				Message data = new Message.Builder().body(jsonObj).build();
				parameters.getEventEmitter().emitData(data);
			}
			
		} catch (Exception e) {
			logger.error("Operation failed", e);
			throw new RuntimeException(e);
		}
		finally {
			logger.info("Closing IX connection...");
			if( ix != null )
				ix.logout();
			ixServer.terminate();
		}

		logger.info("Done");
	}

	protected abstract R run(IX ix, JsonObject config) throws Exception;
}
