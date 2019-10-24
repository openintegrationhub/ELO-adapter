package com.elo.elastic;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

import com.elo.elastic.model.ExtendedEloObject;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.elastic.api.ExecutionParameters;

class DeleteAnyTest extends IxOperationTest {

	@Test
	void test() throws Exception {
		DeleteAny ixOp = new DeleteAny();
		
		Map<String,String> map = new HashMap<>();
		map.put("uid", "952");
		
		JsonObject config = Utils.toJsonObject(map);
		Void obj = ixOp.run(ix, config);
		System.out.println(Utils.toJsonString(obj));
	}

}
