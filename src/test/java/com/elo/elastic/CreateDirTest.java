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

class CreateDirTest extends IxOperationTest {

	@Test
	void test() throws Exception {
		CreateDir ixOp = new CreateDir();
		
		Map<String,String> map = new HashMap<>();
		map.put("parentUid", "1");
		map.put("label", "My folder");
		map.put("maskId", "1");
		map.put("type", "1");
		
		JsonObject config = Utils.toJsonObject(map);
		IdResult obj = ixOp.run(ix, config);
		System.out.println(Utils.toJsonString(obj));
		
	}

}
