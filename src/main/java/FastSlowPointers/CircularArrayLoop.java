package FastSlowPointers;

/*
https://leetcode.com/problems/circular-array-loop/description/
457. Circular Array Loop
Attempted
Medium
Topics
Companies
You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.



Example 1:


Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).
Example 2:


Input: nums = [-1,-2,-3,-4,-5,6]
Output: false
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
The only cycle is of size 1, so we return false.
Example 3:


Input: nums = [1,-1,5,1,4]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 1 --> 0 --> ..., and while it is of size > 1, it has a node jumping forward and a node jumping backward, so it is not a cycle.
We can see the cycle 3 --> 4 --> 3 --> ..., and all of its nodes are white (jumping in the same direction).
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        boolean positiveCycle = nums[0] > 0;
        for (int start = 0; start < nums.length; start++) {
            int slow = start;
            int fast = start;
            int count = 1;
            do {
                slow = getNext(slow, nums[slow], nums.length);
                if (!validateCycle(positiveCycle, nums[slow]))
                    break;
                fast = getNext(fast, nums[fast], nums.length);
                if (!validateCycle(positiveCycle, nums[fast]))
                    break;
                fast = getNext(fast, nums[fast], nums.length);
                if (fast == slow && count == 1) {
                    break;
                }
                if (!validateCycle(positiveCycle, nums[fast]))
                    break;
                count++;
            } while (slow != fast);
            if (fast == slow && count > 1) {
                return true;
            }
        }

        return false;
    }

    private static int getNext(int pos, int change, int length) {
        int nextPos = pos + change;
        if(nextPos>=0) return nextPos % length;
        return length - (-(nextPos % length));
    }

    private static boolean validateCycle(boolean positiveCycle, int num) {
        if (positiveCycle && num <= 0)
            return false;
        return positiveCycle || num < 0;
    }

    public static void main(String[] args) {
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2,2,2,2,2,4,7}));
    }
}
