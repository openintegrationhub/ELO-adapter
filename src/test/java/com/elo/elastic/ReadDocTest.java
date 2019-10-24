package com.elo.elastic;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

import com.elo.elastic.model.ExtendedEloObject;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.elastic.api.ExecutionParameters;

class ReadDocTest extends IxOperationTest {

	@Test
	void test() throws Exception {
		ReadDoc ixOp = new ReadDoc();
		
		Map<String,String> map = new HashMap<>();
		map.put("uid", "950");
		
		JsonObject config = Utils.toJsonObject(map);
		ExtendedEloObject obj = ixOp.run(ix, config);
		System.out.println(Utils.toJsonString(obj));
	}

}
