package com.elo.elastic;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

import com.elo.elastic.model.ExtendedEloObject;
import com.elo.elastic.model.IdResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.elastic.api.ExecutionParameters;

class CreateDocTest extends IxOperationTest {

	@Test
	void test() throws Exception {
		CreateDoc ixOp = new CreateDoc();
		
		Map<String,String> map = new HashMap<>();
		map.put("parentUid", "1");
		map.put("label", "oih");
		map.put("url", "https://www.openintegrationhub.org/");
		map.put("filename", "oih.html");
		
		JsonObject config = Utils.toJsonObject(map);
		IdResult obj = ixOp.run(ix, config);
		System.out.println(Utils.toJsonString(obj));
	}

}
