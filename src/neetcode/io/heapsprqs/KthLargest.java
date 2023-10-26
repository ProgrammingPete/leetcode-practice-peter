package neetcode.io.heapsprqs;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
	private List<Integer> minHeaplist=  new ArrayList<>();
	private int k;
	private java.util.Comparator<? super Integer> c;
	public KthLargest(int k, int[] nums){
		//to save the kth largest element,
		//save this element in a minheap of size k 
		this.k = k;
		//create the heap
		for(int i = 0; i < nums.length; i++){
			this.push(nums[i]);
		}
		while(minHeaplist.size() > this.k){
			this.remove();
		}
		System.out.println(this);
	}
	public int add(int val){
		minHeaplist.add(val);
		heapify_up();
		if(minHeaplist.size() > k)
			this.remove(); // needed to keep k elements in the heap
		
		return minHeaplist.get(0);
	}
	
	public void push(int val){
		// System.out.println("Adding val: " + val);
		minHeaplist.add(val);
		heapify_up();
	}
	public void heapify_up(){
		int currentIndex = minHeaplist.size() - 1;
		// System.out.println("currentIndex: " + currentIndex);
		while(currentIndex > 0){
			int parentIndex = (currentIndex - 1) / 2;
			// Swap if the current object is smaller than its parent. THIS IS A MIN HEAP! 
			if(minHeaplist.get(currentIndex) < minHeaplist.get(parentIndex)){
				int temp = minHeaplist.get(currentIndex);
				minHeaplist.set(currentIndex, minHeaplist.get(parentIndex));
				minHeaplist.set(parentIndex, temp);
			} else{
				break;
			}
			currentIndex = parentIndex;
		}
	}
	//remove the root of the heap. This is now never needed
	public int remove(){
		if(minHeaplist.size() == 0) return 0;
		
		//remove the root
		int removedRoot = minHeaplist.get(0);
		//grab last element and make this the temp root, and delete the leaf
		minHeaplist.set(0, minHeaplist.get(minHeaplist.size() - 1));
		this.removeLast();
		
		//adjust the tree
		int currentIndex = 0;
		while(currentIndex < minHeaplist.size()){
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			//find the minimum b/t two children
			if(leftChildIndex >= minHeaplist.size()) break;
			int minIndex = leftChildIndex;
			if(rightChildIndex < minHeaplist.size()){
				if(minHeaplist.get(rightChildIndex) < minHeaplist.get(minIndex)){
					minIndex = rightChildIndex;
				}
			}
			//swap if the current know is greater than the minimum
			if(minHeaplist.get(currentIndex) > minHeaplist.get(minIndex)){
				int temp = minHeaplist.get(currentIndex);
				minHeaplist.set(currentIndex, minHeaplist.get(minIndex));
				minHeaplist.set(minIndex, temp);
			} else 
				break;
		}
		System.out.println("Removed Root: " + removedRoot);
		return removedRoot;			
	}
	
	public int removeLast(){
		return minHeaplist.remove(minHeaplist.size() - 1);
	}
	@Override
	public String toString() {
		return "KthLargest [minHeaplist=" + minHeaplist + "]";
	}
	
}
