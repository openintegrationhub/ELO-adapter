package com.elo.elastic;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

import com.elo.elastic.model.ExtendedEloObject;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.elastic.api.ExecutionParameters;

class UpdateDocTest extends IxOperationTest {

	@Test
	void test() throws Exception {
		UpdateDoc ixOp = new UpdateDoc();
		
		Map<String,String> map = new HashMap<>();
		map.put("uid", "950");
		map.put("url", "https://www.openintegrationhub.org/");
		map.put("filename", "oih.html");
		
		JsonObject config = Utils.toJsonObject(map);
		Void obj = ixOp.run(ix, config);
		System.out.println(Utils.toJsonString(obj));
	}

}
