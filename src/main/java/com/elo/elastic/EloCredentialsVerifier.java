package com.elo.elastic;

import javax.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elo.ix4dummies.IX;
import com.elo.ix4dummies.IxServer;

import de.elo.ix.client.IXConnFactory;
import de.elo.ix.client.IXConnection;
import io.elastic.api.CredentialsVerifier;
import io.elastic.api.InvalidCredentialsException;
import io.elastic.api.Message;

public class EloCredentialsVerifier implements CredentialsVerifier {

    private static final Logger logger = LoggerFactory.getLogger(EloCredentialsVerifier.class);

    @Override
    public void verify(final JsonObject config) throws InvalidCredentialsException {
        logger.info("Verifying ELO credentials...");
        
        String ixUrl = config.getString("ixUrl");
    	IxServer ixServer = new IxServer(ixUrl, "OIH", "1.0");
    	
    	IX ix = null;
    	try {
    		logger.info("Connecting to IX...");
    		String username = config.getString("username");
        	String password = config.getString("password");
        	String language = config.getString("language");
    		ix = ixServer.login(username, password, language);
        }
    	catch (Exception e) {
            throw new InvalidCredentialsException("Failed to verify credentials", e);
        }
    	finally {
			logger.info("Closing IX connection...");
			if( ix != null )
				ix.logout();
			ixServer.terminate();
		}
    }
}
