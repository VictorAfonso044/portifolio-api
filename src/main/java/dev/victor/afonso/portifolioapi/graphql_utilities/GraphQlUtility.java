package dev.victor.afonso.portifolioapi.graphql_utilities;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import dev.victor.afonso.portifolioapi.dataFetchers.AllPersonsDataFetcher;
import dev.victor.afonso.portifolioapi.dataFetchers.PersonDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQlUtility {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;
    
    @Autowired
    private AllPersonsDataFetcher allPersonsDataFetcher;
    
    @Autowired
    private PersonDataFetcher personDataFetcher;

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, buildRuntimeWiring());
        return newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                    .dataFetcher("persons", allPersonsDataFetcher)
                    .dataFetcher("person", personDataFetcher))
                .build(); // TODO Experiences
    }
}
