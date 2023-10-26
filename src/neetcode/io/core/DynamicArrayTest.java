package neetcode.io.core;

import org.junit.jupiter.api.Test;

/**
 * 
 * Design Dynamic Array (Resizable Array) https://neetcode.io/problems/dynamicArray
Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.

Your DynamicArray class should support the following operations:

DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
int get(int i) will return the element at index i. Assume that index i is valid.
void insert(int i, int n) will insert the element n at index i. Assume that index i is valid.
void pushback(int n) will push the element n to the end of the array.
int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
void resize() will double the capacity of the array.
int getSize() will return the number of elements in the array.
int getCapacity() will return the capacity of the array.
If we call void pushback(int n) but the array is full, we should resize the array first.

Example 1:

Input:
["Array", 1, "getSize", "getCapacity"]

Output:
[null, 0, 1]
Example 2:

Input:
["Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"]

Output:
[null, null, 1, null, 2]
Example 3:

Input:
["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "insert", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]

Output:
[null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2]
Note:

The index i provided to get(int i) and insert(int i) is guranteed to be greater than or equal to 0 and less than the number of elements in the array.
 * 
 */
public class DynamicArrayTest {

    
    @Test
    void testGet() {

    }

    @Test
    void testGetCapacity() {

    }

    @Test
    void testGetSize() {

    }

    @Test
    void testInsert() {

    }

    @Test
    void testPopback() {

    }

    @Test
    void testPushback() {

    }
}
