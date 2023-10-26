package neetcode.io.heapsprqs;

public class Solution {
	public static void main(String[] args){
		KthLargest kthLargest = new KthLargest(7, new int[]{-10,1,3,1,4,10,3,9,4,5,1});
		System.out.println("Adding to Kth largest from outside constructor now");
		System.out.println(kthLargest.add(3));   // return 3
		System.out.println(kthLargest);
		System.out.println(kthLargest.add(2));   // return 3
		System.out.println(kthLargest);
		System.out.println(kthLargest.add(3));  // return 3
		System.out.println(kthLargest);
		// System.out.println(kthLargest.add(1));   // return 3
		// System.out.println(kthLargest);
		// System.out.println(kthLargest.add(2));   // return 3
		// System.out.println(kthLargest);
		// System.out.println(kthLargest.add(4));   // return 3
		// System.out.println(kthLargest);
		// System.out.println(kthLargest.add(5));   // return 3
		// System.out.println(kthLargest);		
	}
	
}
