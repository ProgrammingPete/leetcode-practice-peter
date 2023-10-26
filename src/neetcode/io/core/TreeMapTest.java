package neetcode.io.core;

import org.junit.jupiter.api.Test;


/**
 * 
 * Design Binary Search Tree
Design a Binary Search Tree class.

You will design a Tree Map, which maps an integer key to an integer value. Your Tree class should support the following operations:

Tree() will initialize an binary search tree map.
void insert(int key, int val) will map the key to the value and insert it into the tree.
int get(int key) will return the value mapped with the key. If the key is not present in the tree, return -1.
int getMin() will return the value mapped to the smallest key in the tree. If the tree is empty, return -1.
int getMax() will return the value mapped to the largest key in the tree. If the tree is empty, return -1.
void remove(int key) will remove the key-value pair with the given key from the tree.
int[] getInorderKeys() will return an array of the keys in the tree in ascending order.
Note:

The tree should be ordered by the keys.
The tree should not contain duplicate keys. If the key is already present in the tree, the original key-value pair should be overridden with the new key-value pair.
Example 1:

Input:
["insert", 1, 2, "get", 1, "insert", 4, 0, "getMin", "getMax"]

Output:
[null, 2, null, 2, 0]
Example 2:

Input:
["insert", 1, 2, "insert", 4, 2, "insert", 3, 7, "insert", 2, 1, "getInorderKeys", "remove", 1, "getInorderKeys"]

Output:
[null, null, null, null, [1, 2, 3, 4], null, [2, 3, 4]] */
public class TreeMapTest {
    @Test
    void testGet() {

    }

    @Test
    void testGetInorderKeys() {

    }

    @Test
    void testGetMax() {

    }

    @Test
    void testGetMin() {

    }

    @Test
    void testInsert() {

    }

    @Test
    void testRemove() {

    }
}
