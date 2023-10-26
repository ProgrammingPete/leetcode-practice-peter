package neetcode.io.core;

class DNode {
    int val;
    DNode next;
    DNode prev;
    public DNode(int val) {
        this.val = val;
    }
}

class Deque {
    // TODO use a doubly linked list to implement a deque
    DNode head = null;
    DNode tail = null;

    public Deque() {
        //create two dummy node
        head = new DNode(-1);
        tail = new DNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
 
    public void append(int value) {
       DNode node = new DNode(value);
       DNode lastNode = tail.prev; // insert between lastNode and the tail node
       lastNode.next = node; // lastNode is the node before the tail
       node.prev = lastNode;
       node.next = tail;
       tail.prev = node;
    }

    public void appendleft(int value) {
        DNode node = new DNode(value);
        //insert between the head node and nextNode, which is the node after head 
        DNode nextNode = head.next;
        // pointer manipulation
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = head;
    }

    public int popleft() {
        if(isEmpty()) return -1;
        // head = head.next ... this does not update the pointer on head,
        // so the dummy node will still point to the deletedNode
        DNode targetNode = head.next;
        DNode nextNode = targetNode.next;
        head.next = nextNode;
        nextNode.prev = head;

        //delete the node pointers so that it is picked up by garbage collection
        int val = targetNode.val;
        targetNode.next = null;
        targetNode.prev = null;

        return val;
    }

    public int pop() {
        if(isEmpty()) return -1;
        // tail = tail.next ... this does not update the pointer on tail,
        // so the dummy node will still point to the deletedNode, and we did not actually delete the node
        DNode targetNode = tail.prev;
        DNode prevNode = targetNode.prev;
        tail.prev = prevNode;
        prevNode.next = tail;

        int val = targetNode.val;
        targetNode.next = null;
        targetNode.prev = null;
        return val;
    }
}