package com.graphqljava.tutorial.glossardetails;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class GlossarDetailsApplicationTests {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlossarDetailsApplicationTests.class);

    @Autowired
    private WebApplicationContext wac;

    MockMvc mockMvc;

    private static final String GRAPHQL_PATH = "/graphql";

    final static Stream<Arguments> parameterList(){
        return Stream.of(
                Arguments.of("{definitionByID(id:1){ id definition } }", "{\"data\":{\"definitionByID\":{\"id\":\"1\",\"definition\":\"Das auf die Form des Rechtsgeschaefts anwendbare Recht\"}}}"),
                Arguments.of("{definitionByID(id:2){ id definition } }", "{\"data\":{\"definitionByID\":{\"id\":\"2\",\"definition\":\"Schnittstelle zum kommunikativen Austausch von Daten über Rest\"}}}"),
                Arguments.of("{definitionByID(id:3){ id definition } }", "{\"data\":{\"definitionByID\":{\"id\":\"3\",\"definition\":\"Ein GraphQL-Server ist ein Webserver, der die REST-Schnittstelle zum Austausch von Daten über GraphQL erweitert\"}}}"),
                Arguments.of("{definitionByID(id:4){ id definition } }", "{\"data\":{\"definitionByID\":{\"id\":\"4\",\"definition\":\"Moving Picture Experts Group\"}}}")
        );
    }



    @ParameterizedTest
    @MethodSource("parameterList")
    void testQueries(String query, String expected) throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(GRAPHQL_PATH)
                        .content(toJSON(query))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.asyncDispatch(mvcResult))
                .andExpect(content().json(expected));
    }

    private String toJSON(String query) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", query);
        return jsonObject.toString();
    }

}
