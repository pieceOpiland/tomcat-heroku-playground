package com.example.pie.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TodoItemTest {
    private TodoItem testObj;

    @Before
    public void setup() {
        testObj = new TodoItem();
    }

    @Test
    public void testGettersAndSetters() {
        Boolean isDone = false;
        Integer id = 23;
        String task = "Do some testing.";
        testObj.setDone(isDone);
        testObj.setId(id);
        testObj.setTask(task);

        Assert.assertEquals(isDone, testObj.isDone());
        Assert.assertEquals(id, testObj.getId());
        Assert.assertEquals(task, testObj.getTask());
    }

    @Test
    public void testComplete() {
        testObj.setTask("Test more stuff.");
        testObj.setId(34);
        testObj.setDone(false);

        testObj.complete();
        Assert.assertTrue(testObj.isDone());
    }
}
