package com.example.pie.rest.resource;

import com.example.pie.model.MyInt;
import com.example.pie.persistance.HibernateInit;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Session sesh = HibernateInit.getSession();
        Transaction txn = sesh.beginTransaction();
        sesh.save(newValue);
        txn.commit();
        value.setValue(newValue.getValue());
    }

}
