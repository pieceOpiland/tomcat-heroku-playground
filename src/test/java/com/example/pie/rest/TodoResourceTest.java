package com.example.pie.rest;

import com.example.pie.rest.resource.TodoResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoResourceTest {

    @Test
    public void testGetTodoItems() {
        assertEquals(0, new TodoResource().getItems(0).size());
    }
}
