package com.example.pie.rest.resource;

import com.example.pie.model.MyInt;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("int")
public class IntResource {

    private static MyInt value = new MyInt();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MyInt getValue() {
        return value;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void setValue(MyInt newValue) {
        value.setValue(newValue.getValue());
    }

}
