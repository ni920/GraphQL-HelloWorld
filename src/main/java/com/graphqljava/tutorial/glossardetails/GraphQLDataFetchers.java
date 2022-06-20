package com.graphqljava.tutorial.glossardetails;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {


    // Array Liste welche in diesem Hello-World als Datenquelle fungiert.
    private static final List<Map<String, String>> glossar = Arrays.asList(
            ImmutableMap.of(
                    "id", "1",
                    "term", "Erbstatut",
                    "definition", "Das auf die Form des Rechtsgeschaefts anwendbare Recht"),
            ImmutableMap.of(
                    "id", "2",
                    "term", "Rest",
                    "definition", "Schnittstelle zum kommunikativen Austausch von Daten über Rest"),
            ImmutableMap.of(
                    "id", "3",
                    "term", "GraphQL",
                    "definition", "Ein GraphQL-Server ist ein Webserver, der die REST-Schnittstelle zum Austausch von Daten über GraphQL erweitert"),
            ImmutableMap.of(
                    "id", "4",
                    "term", "MPEG",
                    "definition", "Moving Picture Experts Group")
    );


    // get Methode für Query
    public DataFetcher getDefinitionByID() {
         return dataFetchingEnvironment -> {
            String glossarID = dataFetchingEnvironment.getArgument("id");
            return glossar
                    .stream()
                    .filter(entry -> entry.get("id").equals(glossarID))
                    .findFirst()
                    .orElse(null);
        };
    }

    // get Methode für Query
    public DataFetcher getDefinitionByTerm() {
        return dataFetchingEnvironment-> {
            String glossarTerm = dataFetchingEnvironment.getArgument("term");
            return glossar
                    .stream()
                    .filter(entry -> entry.get("term").equals(glossarTerm))
                    .findFirst()
                    .orElse(null);
        };
    }
}