package neetcode.io.core;
import java.util.ArrayList;

class Node {
    int val = 0;
    Node next = null;
    public Node(int val) {
        this.val = val;
    }
    @Override
    public String toString(){
        return "[" + val + "]";
    }
}

class LinkedList {
    Node head = null;
    int length = 0;
    public LinkedList() {

    }

    public int get(int index) {
        if(head == null) return -1;
        if((index) > (this.length - 1) || index < 0) return -1;
        Node curr = head;
        int i = 0;
        while(curr != null) {
            if(index == i) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1; // this is just for brevity
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if(head == null) {
            this.head = node;
        } else {
            node.next = head;
            this.head = node;
        }
        this.length++;
    }

    public void insertTail(int val) {
        if(this.head == null) {
            this.head = new Node(val);
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(val);
        }
        this.length++;
    }

    public boolean remove(int index) {
        if((index) > (this.length - 1) || index < 0) return false;
        if(head == null) return false;
        if(index == 0) {
            this.head = this.head.next;
            this.length--;
            return true;
        }
        if(index == 0 && head != null && head.next == null) {
            head = null;
            return true;
        }
        
        Node curr = this.head;
        int i = 0;
        while(i < (index - 1) && curr != null) {
            i++;
            curr = curr.next;
        }
        // remove the node ahead of curr
        if(curr != null && curr.next != null) {
            if(index == (this.length -  1)) { //if this is the last element, then point the node before to null, which is curr
                curr.next = null;
            }
            curr.next = curr.next.next;
            this.length--;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        Node curr = this.head;
        ArrayList<Integer> list = new ArrayList<>();
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node curr = head;
        if(curr == null) return "[]";
        while(curr != null) {
            builder.append("[");
            builder.append(curr.val);
            builder.append("]");
            if(curr.next != null) {
                builder.append("->");
            }
            curr = curr.next;
        }
        builder.append(" Length: " +this.length);
        return builder.toString();
    }
}

