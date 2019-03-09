package algorithm.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int val: nums) {
            if(minHeap.size()<k||val>minHeap.peek()) minHeap.add(val);
            if(minHeap.size()>k) minHeap.poll();
        }
    }

    public int add(int val) {
        if(minHeap.size()<k||val>minHeap.peek()) minHeap.add(val);
        if(minHeap.size()>k) minHeap.poll();
        System.out.println(minHeap.peek());
        return minHeap.peek();
    }

}
