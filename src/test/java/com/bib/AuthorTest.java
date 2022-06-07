// package com.bib;

// import org.assertj.core.api.Assertions;
// import org.json.JSONException;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;


// import java.io.IOException;

// import com.graphql.spring.boot.test.GraphQLTestTemplate;

// @SpringBootTest
// public class AuthorTest {

//     private static final String GRAPHQL_QUERY_PATH = "%s.graphql";
//     private static final String GRAPHQL_RESPONSE_PATH = "%s.json";
    
//     @Autowired
//     GraphQLTestTemplate graphQLTestTemplate;

    
//     @Test
//     void AuthorQueryTest() throws IOException, JSONException{
//         var testName = "bankAccount";
//         String rq = response();
//         String q = query();
//         var graphQLResponse  = graphQLTestTemplate
//             .postForResource(String.format(GRAPHQL_QUERY_PATH, testName));

        
//         Assertions.assertThat(graphQLResponse.getRawResponse().getBody()).isEqualToIgnoringNewLines(rq);

//         // assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody(), true);

//     }



//     private String response() {
//         return "{\"data\":{\"findAllAuthors\":[" +
//                 "{\"id\":1,\"name\":\"Mueller\",\"vorname\":\"Max\"}," +
//                 "{\"id\":2,\"name\":\"Saia\",\"vorname\":\"Nico\"}," +
//                 "]}}";
//     }

//     private String query(){
//         return "{ findAllAuthors{ id name vorname }}";
//     }
// }





