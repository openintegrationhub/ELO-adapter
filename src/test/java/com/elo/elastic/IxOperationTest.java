package com.elo.elastic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.elo.ix4dummies.IX;
import com.elo.ix4dummies.IxServer;

import byps.BTransport;
import byps.RemoteException;

public class IxOperationTest {

	protected static IxServer ixServer;
	protected static IX ix;
	
	static long t;
	
	@BeforeAll
	static void init() throws RemoteException {
		t = System.currentTimeMillis();
		// let's log less...
		java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.WARNING); //(BTransport.class.getName()).setLevel(java.util.logging.Level.WARNING);
		ixServer = new IxServer("http://testing.fancy.ovh:9090/ix-ELO/ix", "OIH Test Suite", "latest");
		ix = ixServer.login("Administrator", "elo", "en");
	}
	
	@AfterAll
	static void terminate() {
		ix.logout();
		ixServer.terminate();
	}
}
