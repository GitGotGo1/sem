package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDBManagerFactory {
    @Test
    void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<DBManagerFactory> constructor = DBManagerFactory.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    void testGetInstanceMySQL() {
        DBManagerFactory.getInstance("mysql");
    }

    @Test
    void testGetInstanceException() {
        assertThrows(IllegalArgumentException.class, () -> {
            DBManagerFactory.getInstance("");
        });
    }
}