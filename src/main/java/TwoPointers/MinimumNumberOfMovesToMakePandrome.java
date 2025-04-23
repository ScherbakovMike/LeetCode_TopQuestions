package TwoPointers;

import java.util.*;

/*
2193. Minimum Number of Moves to Make Palindrome
You are given a string s consisting only of lowercase English letters.
In one move, you can select any two adjacent characters of s and swap them.
Return the minimum number of moves needed to make s a palindrome.
Note that the input will be generated such that s can always be converted to a palindrome.

Example 1:

Input: s = "aabb"
Output: 2
Explanation:
We can obtain two palindromes from s, "abba" and "baab".
- We can obtain "abba" from s in 2 moves: "aabb" -> "abab" -> "abba".
- We can obtain "baab" from s in 2 moves: "aabb" -> "abab" -> "baab".
Thus, the minimum number of moves needed to make s a palindrome is 2.
Example 2:

Input: s = "letelt"
Output: 2
Explanation:
One of the palindromes we can obtain from s in 2 moves is "lettel".
One of the ways we can obtain it is "letelt" -> "letetl" -> "lettel".
Other palindromes such as "tleelt" can also be obtained in 2 moves.
It can be shown that it is not possible to obtain a palindrome in less than 2 moves.
 */
public class MinimumNumberOfMovesToMakePandrome {

    public static int minMovesToMakePalindrome(String s) {
//        char[] chars = s.toCharArray();
//        int moves = 0;
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j) {
//            if (chars[i] == chars[j]) {
//                i++;
//                j--;
//                continue;
//            }
//            // looking the symbol in backward
//            int indexFromRight = j;
//            while ((indexFromRight > i) && chars[i] != chars[indexFromRight]) {
//                indexFromRight--;
//            }
//            // looking the symbol in forward
//            int indexFromLeft = i;
//            while ((indexFromLeft < j) && chars[j] != chars[indexFromLeft]) {
//                indexFromLeft++;
//            }
//            if (indexFromRight == i) {
//                // chars[i] is the center of the odd-length string.
//                // this char should be moved to the center
//                int centerPosition = s.length() / 2;
//                for (int l = i; l < centerPosition; l++) {
//                    swap(chars, l, l + 1);
//                    moves++;
//                }
//            } else {
//                if ((indexFromLeft - i) < (j - indexFromRight)) {
//                    for (int l = indexFromLeft; l > i; l--) {
//                        swap(chars, l, l - 1);
//                        moves++;
//                    }
//                } else {
//                    for (int l = indexFromRight; l < j; l++) {
//                        swap(chars, l, l + 1);
//                        moves++;
//                    }
//                }
//                i++;
//                j--;
//            }
//        }
//        return moves;
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) chars.add(c);

        int moves = 0;
        while (chars.size() > 1) {
            int lastIndex = chars.size() - 1;

            if (chars.get(0).equals(chars.get(lastIndex))) {
                // already matching
                chars.remove(lastIndex);
                chars.remove(0);
            } else {
                int k = lastIndex;
                while (k > 0 && !chars.get(k).equals(chars.get(0))) {
                    k--;
                }

                if (k == 0) {
                    // No match for chars[0] — move it to center
                    Collections.swap(chars, 0, 1);
                    moves++;
                } else {
                    // Bring match to the end
                    for (int i = k; i < lastIndex; i++) {
                        Collections.swap(chars, i, i + 1);
                        moves++;
                    }
                    chars.remove(lastIndex); // matched pair
                    chars.remove(0);
                }
            }
        }

        return moves;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s = "skwhhaaunskegmdtutlgtteunmuuludii";
        System.out.println(minMovesToMakePalindrome(s));
    }
}
