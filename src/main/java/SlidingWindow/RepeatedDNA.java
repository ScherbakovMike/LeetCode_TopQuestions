package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/repeated-dna-sequences/description/

187. Repeated DNA Sequences
Medium
Topics
conpanies icon
Companies
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

Constraints:
1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class RepeatedDNA {

  //  public List<String> findRepeatedDnaSequences(String str) {
  //  // {21824=AACCCCCAAA, 86017=CCCCAAAAAC, 87296=CCCCCCAAAA, 87040=CCCCCAAAAA, 87360=ACCCCCCAAA,
  // 86018=CCCCAAAAAG, 81925=CCCAAAAACC, 81930=CCCAAAAAGG, 65578=CCAAAAAGGG, 171=CAAAAAGGGT,
  // 687=AAAAAGGGTT, 5456=AAACCCCCAA, 21840=AACCCCCCAA, 1364=AAAACCCCCA, 65557=CCAAAAACCC,
  // 5460=AAACCCCCCA, 341=AAAAACCCCC, 85=CAAAAACCCC, 1365=AAAACCCCCC}
  // {21824=AACCCCCAAA, 344069=CCCAAAAACC, 87296=ACCCCCAAAA, 87360=ACCCCCCAAA, 348161=CCCCAAAAAC,
  // 349184=CCCCCAAAAA, 349440=CCCCCCAAAA, 348162=CCCCAAAAAG, 344074=CCCAAAAAGG, 327722=CCAAAAAGGG,
  // 262315=CAAAAAGGGT, 687=AAAAAGGGTT, 5456=AAACCCCCAA, 327701=CCAAAAACCC, 21840=AACCCCCCAA,
  // 262229=CAAAAACCCC, 1364=AAAACCCCCA, 5460=AAACCCCCCA, 341=AAAAACCCCC, 1365=AAAACCCCCC,
  // 2751=AAAAGGGTTT}
  /*
  CCCAAAAACC
  1110000011
  1*4^9 + 1*4^8+1*4^7+1*4 + 1 =
   */
  //    final int DNA_LENGTH = 10;
  //    if (str.length() < DNA_LENGTH * 2) {
  //      return List.of();
  //    }
  //    List<String> results = new ArrayList<>();
  //    int hash = -1;
  //    Map<Integer, String> seen = new HashMap<>();
  //    for (int i = 0; i < (str.length() - DNA_LENGTH); i++) {
  //      hash = calculateHash(str, i, i + DNA_LENGTH - 1, hash);
  //      String subString = str.substring(i, i + DNA_LENGTH);
  //      if (subString.equals(seen.get(hash))) {
  //        results.add(subString);
  //      } else {
  //        seen.put(hash, subString);
  //      }
  //    }
  //    System.out.println(seen);
  //    return results;
  //  }
  //
  //  private int getCi(String str, int i) {
  //    return switch (str.charAt(i)) {
  //      case 'A' -> 0;
  //      case 'C' -> 1;
  //      case 'G' -> 2;
  //      case 'T' -> 3;
  //      default -> throw new IllegalStateException("Unexpected value: " + str.charAt(i));
  //    };
  //  }
  //
  //  private int calculateHash(String str, int start, int end, int previousHash) {
  //    int hash = 0;
  //    if (previousHash == -1) {
  //      for (int pos = end; pos >= start; pos--) {
  //        int degree = end - pos;
  //        hash += (int) (getCi(str, pos) * Math.pow(4, degree));
  //      }
  //    } else {
  //      int degreeStartMinus = end - start;
  //      hash = previousHash * 4;
  //      hash -= (int) (getCi(str, start) * Math.pow(4, degreeStartMinus));
  //      hash += getCi(str, end);
  //    }
  //    return hash;
  //  }
  public List<String> findRepeatedDnaSequences(String s) {
    int L = 10, n = s.length();
    if (n <= L) return new ArrayList();

    // rolling hash parameters: base a
    int a = 4, aL = (int) Math.pow(a, L);

    // convert string to array of integers
    Map<Character, Integer> toInt =
        new HashMap() {
          {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
          }
        };
    int[] nums = new int[n];
    for (int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

    int h = 0;
    Map<Integer, String> seen = new HashMap();
    Set<String> output = new HashSet();
    // iterate over all sequences of length L
    for (int start = 0; start < n - L + 1; ++start) {
      // compute hash of the current sequence in O(1) time
      if (start != 0) h = h * a - nums[start - 1] * aL + nums[start + L - 1];
      // compute hash of the first sequence in O(L) time
      else for (int i = 0; i < L; ++i) h = h * a + nums[i];

      // update output and hashset of seen sequences
      if (seen.containsKey(h)) output.add(s.substring(start, start + L));
      seen.put(h, s.substring(start, start + L));
    }
    System.out.println(seen);
    return new ArrayList<String>(output);
  }

  public static void main(String[] args) {
    assertThat(
        new RepeatedDNA().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),
        containsInAnyOrder("AAAAACCCCC", "CCCCCAAAAA"));
  }
}
