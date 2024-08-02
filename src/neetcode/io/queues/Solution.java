package neetcode.io.queues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        //initialize stack and queue
        for(int student : students) {
            queue.add(student);
        }
        for(int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        int loopCount = 0; 
        // if we loop through the queue fully, 
        // then we should break since no students want that sandwich
        while(!stack.isEmpty()) {
            System.out.println("queue: " + queue);
            System.out.println("stack: " + stack);
            int currStudent = queue.poll();;
            int currentSandwich = stack.peek();
            if(currStudent == currentSandwich) {
                stack.pop();
                loopCount = 0;
            } else {
                queue.add(currStudent);
                loopCount++;
            }
            if(loopCount > queue.size()) break; 
        }
        return queue.size();
    }
    /// create a hashmap from the string of counts
    // create a max priority queue based on the number of counts
    // create a result string, add to this string if the previous character is not the same or it is empty
    public String reorganizeString(String s) {
        char[] s_chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        // create map count 
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s_chars.length; i++) {
            if(!count.containsKey(s_chars[i])) {
                count.put(s_chars[i], 1);
            } else {
                count.put(s_chars[i], count.get(s_chars[i]) + 1);
            }
        }

        // create Max PriorityQueue with a comparator, reversing a and b entries
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.offer(entry);
        }
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> maxEntry = pq.poll();
            if(result.isEmpty() || result.charAt(result.length() - 1) != maxEntry.getKey()) {
                addToResultAndUpdateCount(result, pq, maxEntry);
            } else {
                if(pq.isEmpty()) return ""; // if the queue is empty then we return empty string as part of the requirements
                // we need to grab a letter from the second largest count
                Map.Entry<Character, Integer> secondLargestEntry = pq.poll();
                addToResultAndUpdateCount(result, pq, secondLargestEntry);
                pq.offer(maxEntry); // add back the maxEntry since we popped it earlier
            }
        }
        return result.toString(); 
    }

    private void addToResultAndUpdateCount(StringBuilder result, Queue<Map.Entry<Character, Integer>> pq,
            Map.Entry<Character, Integer> entry) {
        result.append(entry.getKey());
        entry.setValue(entry.getValue() - 1);
        if(entry.getValue() > 0) { // add back to queue if count is greater than one
            pq.offer(entry);
        }
    }
}
