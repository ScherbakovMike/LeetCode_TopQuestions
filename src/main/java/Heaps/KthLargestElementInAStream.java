package Heaps;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
703. Kth Largest Element in a Stream
Easy

You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.

Implement the KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 */
public class KthLargestElementInAStream {
    private final PriorityQueue<Integer> tops = new PriorityQueue<>();
    private final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        for (var num : nums) {
            tops.offer(num);
        }
        while (this.tops.size() > k) this.tops.poll();
        this.k = k;
    }

    public int add(int val) {
        var min = this.tops.peek();
        if (this.tops.size() >= k && val < min) return min;
        this.tops.offer(val);
        if (this.tops.size() > k) this.tops.poll();
        return this.tops.peek();
    }
}
