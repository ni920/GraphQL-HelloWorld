package com.graphqljava.tutorial.glossardetails;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.json.JSONException;
import org.json.JSONObject;


@SpringBootTest
@AutoConfigureMockMvc
class GlossarDetailsApplicationTests {

	@Autowired
	MockMvc mockMvc;

	private static final String GRAPHQL_PATH = "/graphql";

	@Test
	void contextLoads() throws Exception{

		String excpectedRpns = "{\"data\":{\"definitionByID\":" +
								"{\"id\":1,\"definition\":" +
								"\"Das auf die Form des Rechtsgeschäfts anwendbare Recht\"}" +
			  					"}}";

		String query = "{ definitionByID(id:1){ id definition } }";

		mockMvc.perform(MockMvcRequestBuilders.post(GRAPHQL_PATH)
				.content(toJSON(query))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                // .andExpect(content().json(excpectedRpns))
				
				// .andExpect(jsonPath("$.id").value("1"))
                // .andReturn();
				System.out.println("=================' "+jsonPath("$.id").value(1));
        
	}

	private String toJSON(String query) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", query);
        return jsonObject.toString();
    }

}
