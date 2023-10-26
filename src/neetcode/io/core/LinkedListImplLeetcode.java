package neetcode.io.core;

class MyLinkedList {
    Node head = null;
    Node tail = null;
    int length;
    public MyLinkedList() {
        head = new Node(-1);
        tail = head;
        length = 0;
    }
    
    public int get(int index) {
        if(index > length - 1) return -1;
        Node curr = head;
        int i = 0; 
        while(curr != null) {
            if(i == index) {
                // getValues("get");
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        // getValues("get");
        return -1;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
        // getValues("addAtHead");

    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
        // getValues("addAtTail");

    }
    
    public void addAtIndex(int index, int val) {
        if(index > length) return;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == length) {
            addAtTail(val);
            return;
        }

        //go to the node before the index to be added
        int i = 0;
        Node curr = head;
        while(i < (index - 1)) {
            curr = curr.next;
            i++;
        }

        Node node = new Node(val);
        Node temp = curr.next;
        curr.next = node;
        node.next = temp;
        length++;
        // getValues("addAtIndex");

    }
    
    public void deleteAtIndex(int index) {
        if(index > length - 1) {
            // getValues("deleteAtIndex");
            return;
        } 
        if(index == 0) {
            head = head.next;
            length--;
            // getValues("deleteAtIndex");
            return;
        }
        //go to the node before the index to be added
        int i = 0;
        Node curr = head;
        while(i < (index - 1)) {
            curr = curr.next;
            i++;
        }
        if(curr.next.next == null) { // if on the second to last element, then this element will now be tail
            tail = curr;
            tail.next = null;
        } else {
            curr.next = curr.next.next;
        }
        length--;
        // getValues("deleteAtIndex");
    }

    public void getValues(String command) {
        Node curr = this.head;
        System.out.print("After Command " + command+ ":");
        while(curr != null) {
            System.out.print(curr + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */