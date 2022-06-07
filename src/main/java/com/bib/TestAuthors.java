// package com.bib;


// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// @SpringBootTest
// @AutoConfigureMockMvc
// public class TestAuthors {
//     @Autowired
// 	MockMvc mockMvc;

// 	@TestAuthors
// 	void findAllAuthors() throws Exception {
// 		String expectedResponseAuthors = "{\"data\":{\"findAllAuthors\":[" +
// 											"{\"id\":1,\"name\":\"Mueller\",\"vorname\":\"Max\"}," +
// 											"{\"id\":2,\"name\":\"Saia\",\"vorname\":\"Nico\"}," +
// 											"]}}";

// 		mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
// 				.content("{\"query\":\"{ findAllAuthors { id name vorname }}\"}")
// 				.contentType(MediaType.APPLICATION_JSON)
// 				.accept(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk())
// 				.andExpect(content().json(expectedResponseAuthors))
// 				.andReturn();

// 	}
// }


