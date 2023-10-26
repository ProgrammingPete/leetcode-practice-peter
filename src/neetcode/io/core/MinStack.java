package neetcode.io.core;

import java.util.ArrayList;
import java.util.List;


public class MinStack {

        List<Integer> list;
        List<Integer> minList;
        int min;
        public MinStack() {
            list = new ArrayList<>();
            minList = new ArrayList<>();
        }
        
        public void push(int val) {
            list.add(val);
            if(minList.isEmpty() || val <= min) {
                minList.add(val);
                min = val;
            } else {
                minList.add(minList.get(minList.size() - 1));
            }
        }
        
        public void pop() {
            if(list.isEmpty()) return;
            list.remove(list.size() - 1);
            minList.remove(minList.size() - 1);
            if(!minList.isEmpty())
                min = minList.get(minList.size() - 1);
        }
        
        public int top() {
            return list.get(list.size() - 1);
        }
        
        public int getMin() {
            return min;
        }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */