package com.elo.elastic;

import javax.json.JsonObject;

import byps.RemoteException;
import de.elo.ix.client.IXConnFactory;
import de.elo.ix.client.IXConnIXServicePortIF_2;
import de.elo.ix.client.IXConnection;

public class IxWrapper {
	
	IXConnFactory ixConnFact;
	IXConnection conn;
	
	public IxWrapper(JsonObject configuration) throws RemoteException {
		
		String ixUrl = configuration.getString("ixUrl");
    	String username = configuration.getString("username");
    	String password = configuration.getString("password");
    	
		ixConnFact = new IXConnFactory(ixUrl, username, password);
    	conn = ixConnFact.create(username, password, null, null);
	}
	
	public IXConnIXServicePortIF_2 ix() {
		return conn.ix();
	}
	
	public void close() {
		conn.close();
    	ixConnFact.done();
	}
}
