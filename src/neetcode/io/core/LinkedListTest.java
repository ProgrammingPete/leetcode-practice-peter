package neetcode.io.core;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    LinkedList linkedList = null;

    @BeforeEach
    void setUp(){
        linkedList = new LinkedList();
    }

    @Test
    void testCase6() {
        linkedList.insertHead(1);
        linkedList.insertHead(2);
        linkedList.insertTail(3);
        linkedList.insertTail(4);
        linkedList.insertHead(5);
        assertEquals(5, linkedList.get(0));
        assertEquals(1, linkedList.get(2));
        assertEquals(4, linkedList.get(4));
        assertEquals(true, linkedList.remove(2));
        assertEquals(true, linkedList.remove(0));
        linkedList.insertHead(6);
        linkedList.insertTail(7);
        List<Integer> expected = List.of(6, 2, 3, 4, 7);
        assertEquals(expected, linkedList.getValues());
        assertEquals(-1, linkedList.get(5));
        System.out.println(linkedList);

    }
    @Test
    void testCase11() {
        linkedList.insertHead(1);
        linkedList.insertTail(2);
        linkedList.insertHead(0);
        assertEquals(true, linkedList.remove(1));
        List<Integer> expected = List.of(0,2);
        assertEquals(expected, linkedList.getValues());

    }
    @Test
    void testCase12() {
        linkedList.insertHead(1);
        linkedList.insertHead(3);
        assertEquals(-1, linkedList.get(5));
    }
    @Test
    void testCase13() {
        linkedList.insertHead(1);
        linkedList.insertHead(2);
        assertEquals(true, linkedList.remove(0));
        assertEquals(true, linkedList.remove(0));
        List<Integer> expected  = new ArrayList<>();
        assertEquals(expected, linkedList.getValues());
        System.out.println(linkedList);
    }
    @Test
    void testCase14() {
        linkedList.insertTail(1);
        linkedList.insertHead(2);
        linkedList.insertHead(3);
        linkedList.insertTail(4);
        List<Integer> expected  = List.of(3,2,1,4);
        assertEquals(expected, linkedList.getValues());
        System.out.println(linkedList);

    }
}
