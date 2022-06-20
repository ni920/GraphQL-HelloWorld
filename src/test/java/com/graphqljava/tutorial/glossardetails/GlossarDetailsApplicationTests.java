package com.graphqljava.tutorial.glossardetails;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GlossarDetailsApplicationTests {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlossarDetailsApplicationTests.class);

    @Autowired
    private WebApplicationContext wac;

    MockMvc mockMvc;

    private static final String GRAPHQL_PATH = "/graphql";

    @Test
    void contextLoads() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        String expectedRpns = "{\"data\":{\"definitionByID\":{\"id\":\"1\",\"definition\":\"Das auf die Form des Rechtsgeschaefts anwendbare Recht\"}}}";

        String query = "{definitionByID(id:1){ id definition } }";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(GRAPHQL_PATH)
                        .content(toJSON(query))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(content().json(expectedRpns));


    }

    private String toJSON(String query) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", query);
        return jsonObject.toString();
    }

}
