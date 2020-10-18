package algoritms.leetcode.contest;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(5, new int[]{4, 5, 8});
    }

    int k;
    public PriorityQueue<Integer> p;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        p = new PriorityQueue<>();

        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        p.offer(val);

        if (p.size() > k) {
            p.poll();
        }
        return p.peek();
    }
}
