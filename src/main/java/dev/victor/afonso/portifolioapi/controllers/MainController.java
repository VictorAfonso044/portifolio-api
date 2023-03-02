package dev.victor.afonso.portifolioapi.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.victor.afonso.portifolioapi.graphql_utilities.GraphQlUtility;
import graphql.ExecutionResult;
import graphql.GraphQL;

@RestController
public class MainController {

    private final GraphQL graphQL;
    private final GraphQlUtility graphQlUtility;
    
    MainController(GraphQlUtility graphQlUtility) throws IOException {
        this.graphQlUtility = graphQlUtility;
        this.graphQL = this.graphQlUtility.createGraphQlObject();
    }

    @PostMapping(value = "/query")
    public ResponseEntity<?> query(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);
        return ResponseEntity.ok(result.getData());
    }
}
