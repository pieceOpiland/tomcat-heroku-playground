package com.example.pie.rest.mapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonParseHandler implements ExceptionMapper<JsonParseException> {

    @Override
    public Response toResponse(JsonParseException e) {
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Malformed Request")
                .build();
    }
}
