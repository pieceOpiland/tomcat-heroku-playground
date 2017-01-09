package com.example.pie.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JacksonProvider implements ContextResolver<ObjectMapper> {
    private final ObjectMapper mapper;

    public JacksonProvider() {
        mapper = new ObjectMapper();

        // Serializes private fields without getters, for better or for worse.
        // mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
