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

Standardmäßig ist der Port `8090`.

---

### Abfragen mittels Query:
+ Tools die genutzt werden können:
  + GraphQL Playground (https://github.com/graphql/graphql-playground)
  + Postman (https://www.postman.com/downloads/)
  

+ Hier genutzt `graphql-playground`:

+ Adresse für die Abfrage: http://localhost:8090/graphql

**Test Query**:
```
{
  bookById(id: "book-1") {
    id
    name
    pageCount
  }
}
```

**Ausgabe**: 
```
{
  "data": {
    "bookById": {
      "id": "book-1",
      "name": "Harry Potter und der Orden des Phönix",
      "pageCount": 544
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

