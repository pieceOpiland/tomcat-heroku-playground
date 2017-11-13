package com.example.pie.rest;

import com.example.pie.rest.resource.TodoResource;
import com.example.pie.test.DatabaseRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoResourceTest {

    @Rule
    public final DatabaseRule rule = new DatabaseRule();

    @Test
    public void testGetTodoItems() {
        assertEquals(0, new TodoResource().getItems(0).size());
    }
}
