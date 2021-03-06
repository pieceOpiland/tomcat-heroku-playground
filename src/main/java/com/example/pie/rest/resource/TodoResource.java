package com.example.pie.rest.resource;

import com.example.pie.model.TodoItem;
import com.example.pie.persistance.PersistenceManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("todo")
public class TodoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // It'd be nice to go ahead and have date here.
    // Jackson claims to support it: http://wiki.fasterxml.com/JacksonFAQDateHandling
    public List getItems(@QueryParam("ts")long epoch) {
        Date timestamp = new Date(epoch);
        Session session = PersistenceManager.getInstance().getSession();
        Transaction txn = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TodoItem> query = builder.createQuery(TodoItem.class);
        Root<TodoItem> item = query.from(TodoItem.class);

        query.select(item)
                .where(builder.and(
                        builder.equal(item.get("visible"), true)),
                        builder.greaterThan(item.get("timestamp"), timestamp))
                .orderBy(builder.asc(item.get("id")));

        List result = session.createQuery(query).getResultList();
        txn.commit();
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List makeItem(List<TodoItem> newItems){
         Session session = PersistenceManager.getInstance().getSession();
         Transaction txn = session.beginTransaction();
         for(TodoItem newItem : newItems) {
             session.save(newItem);
         }
         txn.commit();
        return newItems;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List clearDoneItems(){
        Session session = PersistenceManager.getInstance().getSession();
        Transaction txn = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<TodoItem> query = builder.createCriteriaUpdate(TodoItem.class);
        Root<TodoItem> item = query.from(TodoItem.class);

        query.where(builder.equal(item.get("done"), true))
                .set(item.get("visible"), false);

        session.createQuery(query).executeUpdate();
        txn.commit();
        return getItems(0);
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoItem updateItem(@PathParam("id") Integer id){
        Session session = PersistenceManager.getInstance().getSession();
        Transaction txn = session.beginTransaction();
        TodoItem theItem = session.find(TodoItem.class, id);
        theItem.complete();
        session.update(theItem);
        txn.commit();
        return theItem;
    }
}
