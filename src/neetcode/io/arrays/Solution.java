package neetcode.io.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        // sort the array using quicksort in asc order
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        // return the kth largest element
        return nums[k -1];
    }
    
    private int[] quickSort(int[] arr, int s, int e) {
        //base case. is length of arr is 1. We get the length of the subarry by comparing the start and end pointers
        if (e - s + 1 <= 1) {
            return arr;
        }

        int pivot = arr[e]; // choose the last element as the pivot
        int left = s; // pointer for the left side

        for(int i = s; i < e; i++) { // i pointer
            if(arr[i] > pivot) {
                // swap the left and the ith numbers
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                left++; // increment left since we know that everything to the left should be somaller than the pivot
            }
        }
        
        //move pivot between the left and right sides
        arr[e] = arr[left];
        arr[left] = pivot;

        // Quick sort left side
        quickSort(arr, s, left - 1);

        // Quick sort right side
        quickSort(arr, left + 1, e);

        return arr;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) == -1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
            } else {
                map.put(s.charAt(i), 1);
            }
            if(map.containsKey(t.charAt(i))) {
                if(map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                map.put(t.charAt(i), -1);
            }

        }
        return map.isEmpty();
    }
    public int[] findDiagonalOrder(int[][] mat) {
        // Check for empty matrices
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;

        int row = 0, column = 0;

        int[] result = new int[m*n];
        int r = 0;
        boolean up = true;
        while(row < m && column < n) {
            if (up) {
                while(row >= 0 && column < n) {
                    result[r++] = mat[row][column];
                    row--;
                    column++;
                }
                row++;
                if(column == n) {
                    row++;
                    column--;
                }
                up = false;
            } else {
                while(column >= 0 && row < m) {
                    result[r++] = mat[row][column];
                    row++;
                    column--;
                }
                column++;
                if(row == m) {
                    row--;
                    column++;
                }
                up = true;
            }
        }
        return result;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
       
       // create circular linked list with Nodes
        Node[] directions = new Node[] { 
            new Node("right"),
            new Node("down"),
            new Node("left"),
            new Node("up")
        };
        for(int i = 0; i < directions.length; i++) {
            if(i + 1 == directions.length) {
                directions[i].next = directions[0];
            } else {
                directions[i].next = directions[i + 1];
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        Node currentDirection = directions[0];
        while(result.size() < m*n) {
            if(!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            } 


            if(currentDirection.direction.equals("right") && j + 1 < n && visited[i][j + 1] == false) {
                j++;
            } else if(currentDirection.direction.equals("right") && (j + 1 >= n || visited[i][j + 1] == true)) {
                currentDirection = currentDirection.next;
            } else if(currentDirection.direction.equals("down")  && i + 1 < m && visited[i+1][j] == false) {
                i++;
            } else if(currentDirection.direction.equals("down")  && (i + 1 >= m || visited[i+1][j] == true)) {
                currentDirection = currentDirection.next;
            } else if(currentDirection.direction.equals("left")  && j - 1 >= 0 && visited[i][j - 1] == false) {
                j--;
            } else if(currentDirection.direction.equals("left")  && (j - 1 < 0 || visited[i][j - 1] == true)) {
                currentDirection = currentDirection.next;
            } else if(currentDirection.direction.equals("up")    && i - 1 >= 0 && visited[i - 1][j] == false) {
                i--;
            } else if(currentDirection.direction.equals("up")    && (i - 1 <= 0 || visited[i - 1][j] == true)) {
                currentDirection = currentDirection.next;
            }
        }

        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if(numRows == 1) return result;
        result.add(List.of(1,1));
        if(numRows == 2) return result;

        for(int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = result.get(i - 2);
            for(int j = 1; j < i; j++) {
                if(j == i - 1) {
                    row.add(1);
                } else {
                    int val = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(val);
                }
            }
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> uniqueNums1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> uniqueNums2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Set<Integer> temp = new HashSet<>();
        temp.addAll(uniqueNums1);
        uniqueNums1.removeAll(uniqueNums2);
        uniqueNums2.removeAll(temp);
        

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(uniqueNums1));
        result.add(new ArrayList<>(uniqueNums2));
        Collections.copy(null, null);
        return result;
    }

    public int[] sortKMessedArray(int[] arr, int k) {
        // insertion sort
        // for(int i = 1, j = i - 1; i < arr.length; i++, j = i - 1) {
        //     while(j >= 0 && arr[j+1] < arr[j]) {
        //         //execute swap
        //         int temp = arr[j];
        //         arr[j] = arr[j+1];
        //         arr[j + 1] = temp;

        //         j--;
        //     }
        // }

        // alternate way of completing the program
        // we can create a min heap (min Priority Queue) and add k + 1 elements to it. 
        // we then pop and add one element to the heap, adding the popped element back to the original array
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a,b));
        for(int i = 0; i <= Math.min(arr.length - 1, k); i++) { // math min is required if k > arr.length
            pq.offer(arr[i]);
        }
        int replaceIndex = 0; 

        //iterate through the rest of the array
        for(int i = k + 1; i < arr.length; i++) {
            arr[replaceIndex++] = pq.poll();
            pq.offer(arr[i]);
        }

        // pop the rest of the value in the heap until it is empty
        while(!pq.isEmpty()) {
            arr[replaceIndex++] = pq.poll();
        }
        return arr;
    }
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        if(pairs.isEmpty()) return result; //edge case for empty array

        addToResult(result, pairs); // add inital state of pairs


        int j = 0;
        for(int i = 1; i < pairs.size(); i++) {
            j = i - 1;
            while(j >= 0 && pairs.get(j+1).key < pairs.get(j).key) { // swap when the next value is less than the previous value
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                // decrement by one and then check if this is sorted
                j--;
            }
            // take snapshot after each insertion
            addToResult(result, pairs);
        }
        return result;
    }

    private void addToResult(List<List<Pair>> result, List<Pair> state) {
            List<Pair> snapshot = new ArrayList<>();
            for(Pair pair : state) {
                snapshot.add(pair); 
            }
            result.add(snapshot);
    }

}
