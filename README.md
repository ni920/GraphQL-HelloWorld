[![Java Build](https://github.com/ni920/GraphQL-HelloWorld/actions/workflows/gradle.yml/badge.svg)](https://github.com/ni920/GraphQL-HelloWorld/actions/workflows/gradle.yml)
[![Build DockerImage](https://github.com/ni920/GraphQL-HelloWorld/actions/workflows/buildImage.yml/badge.svg)](https://github.com/ni920/GraphQL-HelloWorld/actions/workflows/buildImage.yml)

# GraphQL-HelloWorld

- [GraphQL-HelloWorld](#graphql-helloworld)
    - [Bauen des Projekts:](#bauen-des-projekts)
    - [Starten des Projekts:](#starten-des-projekts)
    - [Abfragen mittels Query:](#abfragen-mittels-query)
    - [Schema:](#schema)
    - [DataFetchers:](#datafetchers)

Dieses Repository dient dem Aufsetzen eines GraphQL Hello-Worlds.

### Bauen des Projekts:
```
gradle build
```

---

### Starten des Projekts:
```
gradle bootRun
```
Sollte der Port bereits belegt sein kann dieser in `src/main/resources/application.properties` geändert werden.

Standardmäßig lautet der Port `8090`.

---

### Abfragen mittels Query:
+ Tools die genutzt werden können:
  + GraphQL Playground (https://github.com/graphql/graphql-playground)
  + Postman (https://www.postman.com/downloads/)
  + GraphiQL (https://github.com/graphql/graphiql)
  

+ Für `graphql-playground` folgenden Link verwenden:

  + http://localhost:8090/graphql

+ `GraphIQL` kann im Web-Browser aufgerufen werden:

  + http://localhost:8090/graphiql

**Test Query**:
```
{
  definitionByID(id: "1") {
    term
    definition
  }
  definitionByTerm(term: "Erbstatut"){
    definition
  }
}
```

**Ausgabe**: 
```
{
  "data": {
    "definitionByID": {
      "term": "Erbstatut",
      "definition": "Das auf die Form des Rechtsgeschäfts anwendbare Recht"
    },
    "definitionByTerm": {
      "definition": "Das auf die Form des Rechtsgeschäfts anwendbare Recht"
    }
  }
}
````

---

### Schema:

Das Schema wird in einer Datei `schema.graphql` gespeichert.
Diese befindet sich im Ordner `src/main/resources`.

---

### DataFetchers:

Die Daten werden aktuell in der Klasse `GraphQLDataFetchers` angelegt.


--- 

### Docker:

Die Docker-Images werden durch das Gradle Jib Plugin erstellt.

#### Lokales erstellen eines Docker Images:

**Vorraussetzung**:
+ Docker ist installiert
+ Docker Desktop ist am lausten

```
gradle jibDockerBuild
```

Das Docker Image wird daraufhin gebaut und kann via 
cli gestartet werden.

#### Automatische Docker Image Builds:

Das bauen der Docker Images kann optional über eine 
GitHub Action erfolgen. 
Hierbei wird ein Image erstellt und automatisch in die 
GitHub Registry gepusht.

#### Starten des Docker Images:

Das Docker Image kann über die Compose Datei gestartet werden.

Hier für folgenden Befehl im Ordner der Datei ausführen:

```
docker-compose up
```
