package com.example.pie.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyIntTest {

    private MyInt testObj;

    @Before
    public void setUp() {
        testObj = new MyInt();
    }

    @Test
    public void testGettersAndSetters() {
        Integer value = 23;
        testObj.setValue(value);

        Assert.assertEquals(value, testObj.getValue());
    }
}
