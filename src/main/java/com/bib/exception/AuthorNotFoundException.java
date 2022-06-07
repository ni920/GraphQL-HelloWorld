package com.bib.exception;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class AuthorNotFoundException extends RuntimeException implements GraphQLError {


    private Map<String, Object> extensions = new HashMap<>();

    public AuthorNotFoundException(String message, Integer invalidAuthorId){
        super(message);
        extensions.put("invalidAuthorId", invalidAuthorId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorClassification getErrorType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}