package practice.divideAndConquer;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int count = pq.size() - k;
        while (count != 0) {
            count--;
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        KthLargestElement kth = new KthLargestElement();
        System.out.println(kth.findKthLargest(nums, k));

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println(kth.findKthLargest(nums, k));
    }
}
