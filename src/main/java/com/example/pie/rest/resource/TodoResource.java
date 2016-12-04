package com.example.pie.rest.resource;

import com.example.pie.model.TodoItem;
import com.example.pie.persistance.HibernateInit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("todo")
public class TodoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getItems() {
        Session session = HibernateInit.getSession();
        Transaction txn = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TodoItem> query = builder.createQuery(TodoItem.class);
        Root<TodoItem> item = query.from(TodoItem.class);
        query.select(item);
        query.orderBy(builder.asc(item.get("id")));
        List result = session.createQuery(query).getResultList();
        txn.commit();
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoItem makeItem(TodoItem newItem){
        Session session = HibernateInit.getSession();
        Transaction txn = session.beginTransaction();
        session.save(newItem);
        txn.commit();
        return newItem;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoItem updateItem(@PathParam("id") Integer id){
        Session session = HibernateInit.getSession();
        Transaction txn = session.beginTransaction();
        TodoItem theItem = session.find(TodoItem.class, id);
        theItem.setDone(true);
        session.update(theItem);
        txn.commit();
        return theItem;
    }
}
