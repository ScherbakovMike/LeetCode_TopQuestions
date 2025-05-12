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
        for (int start = 0; start < nums.length; start++) {
            boolean positiveCycle = nums[start] > 0;
            int slow = start;
            int fast = start;
            int count = 1;
            boolean validCycle;
            do {
                slow = getNext(slow, nums[slow], nums.length);
                validCycle = validateCycle(positiveCycle, nums[slow], nums.length);
                if (!validCycle)
                    break;
                fast = getNext(fast, nums[fast], nums.length);
                validCycle = validateCycle(positiveCycle, nums[fast], nums.length);
                if (!validCycle)
                    break;
                fast = getNext(fast, nums[fast], nums.length);
                if (fast == slow && count == 1) {
                    break;
                }
                validCycle = validateCycle(positiveCycle, nums[fast], nums.length);
                if (!validCycle)
                    break;
                count++;
            } while (slow != fast);
            if (fast == slow && count > 1 && validCycle) {
                return true;
            }
        }
        return false;
    }

    private static int getNext(int pos, int change, int length) {
        change = change % length;
        if (change >= 0) return (pos + change) % length;
        int result = pos + change;
        if (result < 0) {
            return length + result;
        } else return result;
    }

    private static boolean validateCycle(boolean positiveCycle, int num, int length) {
        if (num == length || num==-length) return false;
        if (positiveCycle && num <= 0)
            return false;
        return positiveCycle || num < 0;
    }

    public static void main(String[] args) {
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1,-1,-3}));
    }
}
