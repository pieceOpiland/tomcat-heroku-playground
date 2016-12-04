package com.example.pie.rest.resource;

import com.example.pie.model.MyInt;
import com.example.pie.persistance.HibernateInit;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IntResource {

    private static MyInt value = new MyInt();

    public MyInt getValue() {
        return value;
    }

    public void setValue(MyInt newValue) {
        Session sesh = HibernateInit.getSession();
        Transaction txn = sesh.beginTransaction();
        sesh.save(newValue);
        txn.commit();
        value.setValue(newValue.getValue());
    }

}
