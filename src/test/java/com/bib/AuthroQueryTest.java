package com.bib;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bib.model.Author;
import com.bib.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;




@SpringBootTest
@AutoConfigureMockMvc
// @ContextConfiguration(classes = {WebConfig.class})
public class AuthroQueryTest {

	@TestConfiguration
	static class AuthorImplementation {
		@Bean
		public AuthorServices authorServiceIM(){
			return new AuthorServices();
		}
	}

    @Autowired
	MockMvc mockMvc;

    @Autowired
    AuthorServices authorServices;

	@Mock
	AuthorRepository authorRepository;

	@Autowired
  	private ObjectMapper objectMapper;

	// @MockBean
	// AuthorRepository authorRepository;

    
    private static final String GRAPHQL_PATH = "/graphql";


	@Test
	void findAllAuthorsTest() throws Exception {

		// when(authorRepository.findAll()).thenReturn(null);

        // // List<Author> found = authorServices.findAllAuthors();
		// // System.out.println("TESSSSSSSSSSSSSSt: "+ found.toString());

		String expectedResponseAuthors = "{\"data\":{\"findAllAuthors\":[" +
											"{\"id\":1,\"name\":\"Mueller\",\"vorname\":\"Max\"}," +
											"{\"id\":2,\"name\":\"Saia\",\"vorname\":\"Nico\"}," +
											"]}}";

		String query = "{ findAllAuthors{id name vorname } }";

		

		ResultActions request =  mockMvc.perform(MockMvcRequestBuilders.post(GRAPHQL_PATH)
				.content("{\"query\":\"{ findAllAuthors { id name vorname }}\"}")
				.content(toJSON(query))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                // .andExpect(jsonPath("$.findAllAuthors.id").valueOf("1"));
				.andExpect(content().json(expectedResponseAuthors));
				// .andReturn();
        request.andExpect(status().isOk());
	}

	

    private String toJSON(String query) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("query", query);
        return jsonObject.toString();
    }
}
