package neetcode.io.core;

class DynamicArray {
    int capacity = 0;
    int size = 0;
    int[] internal = null;
    public DynamicArray(int capacity) {
        this.internal = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return internal[i];
    }

    public void insert(int i, int n) {
        internal[i] = n; // assuming i is valid
    }

    public void pushback(int n) {
        this.size = this.getSize() + 1;
        if(this.getSize()> this.getCapacity()) {
            this.resize();
        }
        internal[this.getSize() - 1] = n;
    }

    public int popback() {
        this.size = this.getSize() - 1;
        int temp = internal[this.getSize()];
        internal[this.getSize()] = 0;
        return temp;
    }

    private void resize() {
        int newCapacity = this.getCapacity() * 2;
        int[] newArr = new int[newCapacity];
        System.arraycopy(this.internal, 0, newArr, 0, this.internal.length);
        this.internal = newArr;
        this.capacity = newCapacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
