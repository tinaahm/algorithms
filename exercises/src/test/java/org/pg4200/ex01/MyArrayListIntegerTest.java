package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {

    @Test
    public void testEmpty() {
        MyArrayListInteger list = new MyArrayListInteger();

        assertEquals(0, list.size());
    }

    @Test
    public void testAddOneElement() {
        MyArrayListInteger list = new MyArrayListInteger();

        int n = list.size();
        list.add(345);
        assertEquals(n + 1, list.size());
    }

    @Test
    public void testAddAndRetrieveElement() {
        MyArrayListInteger list = new MyArrayListInteger();

        Integer value = 600;
        list.add(value);
        Integer ret = list.get(0);

        assertEquals(value, ret);
    }

    @Test
    public void testAdd5Elements() {

        MyArrayListInteger list = new MyArrayListInteger();

        assertEquals(0, list.size());
        Integer a = 56;
        Integer b = 7;
        Integer c = 432222;

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(a);
        list.add(a);

        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(a, list.get(3));
        assertEquals(a, list.get(4));
    }

    @Test
    public void testOutOfIndex() {

        MyArrayListInteger list = new MyArrayListInteger();

        assertNull(list.get(-5));
        assertNull(list.get(42));
    }

}
