package com.elo.elastic;

import javax.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.elo.ix.client.IXConnFactory;
import de.elo.ix.client.IXConnection;
import io.elastic.api.CredentialsVerifier;
import io.elastic.api.InvalidCredentialsException;

public class EloCredentialsVerifier implements CredentialsVerifier {

    private static final Logger logger = LoggerFactory.getLogger(EloCredentialsVerifier.class);

    @Override
    public void verify(final JsonObject configuration) throws InvalidCredentialsException {
        logger.info("Verifying ELO credentials...");
        try {
        	IxWrapper wrapper = new IxWrapper(configuration);
        	wrapper.close();
        	
        } catch (Exception e) {
            throw new InvalidCredentialsException("Failed to verify credentials", e);
        }
    }
}
