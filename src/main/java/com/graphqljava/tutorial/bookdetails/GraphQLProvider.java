package com.graphqljava.tutorial.bookdetails;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    private GraphQL graphQL;

    // Initialisierung des GraphQL-Servers
    @PostConstruct
    public void init() throws IOException {
        // Definieren des GraphQL-Schemas
        URL url = Resources.getResource("schema.graphql");
        // Decodieren des Schemas
        String decodiertesSchema = Resources.toString(url, Charsets.UTF_8);
        // Erzeugen des Schemas
        GraphQLSchema graphQLSchema = buildSchema(decodiertesSchema);
        // Erzeugen des GraphQL-Objekts
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    // Baue das Schema aus dem GraphQL String
    private GraphQLSchema buildSchema(String decodiertesSchema) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(decodiertesSchema);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    // Definieren der Querys in diesem Hello-World 2-Stück
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("definitionByID", graphQLDataFetchers.getDefinitionByID()))
                .type(newTypeWiring("Query")
                        .dataFetcher("definitionByTerm", graphQLDataFetchers.getDefinitionByTerm()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

}