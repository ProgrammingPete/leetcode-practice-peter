package neetcode.io.queues;

import java.util.LinkedList;
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
}
