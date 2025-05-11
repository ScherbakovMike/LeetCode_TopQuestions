package FastSlowPointers;

/*
https://leetcode.com/problems/happy-number/
202. Happy Number
Easy
Topics
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slowRunner = getNext(n);
        int fastRunner = getNext(slowRunner);
        while (slowRunner != 1 && fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return slowRunner == 1 || fastRunner == 1;
    }

    private int getNext(int n) {
        int result = 0;
        while (n != 0) {
            int digit = n % 10;
            result += (digit * digit);
            n = n / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }
}
