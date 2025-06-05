package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class RepeatedDNARolingHash {

  public List<String> findRepeatedDnaSequences(String str) {
    final int DNA_LEN = 10;
    final int HASH_BASE = 4;
    Set<String> result = new HashSet<>();
    Set<Integer> seen = new HashSet<>();
    int hash = 0;
    for (int start = 0; start <= (str.length() - DNA_LEN); start++) {
      hash = calculateRollingHash(str, start, DNA_LEN, HASH_BASE, hash);
      if (!seen.add(hash)) {
        result.add(str.substring(start, start + DNA_LEN));
      }
    }
    return new ArrayList<>(result);
  }

  private int calculateRollingHash(String str, int start, int dnaLength, int hashBase, int hash) {
    if (hash == 0) {
      for (int i = start; i < (start + dnaLength); i++) {
        int degree = dnaLength - 1 - (i - start);
        int symbol = getCi(str, i);
        hash += (int) (symbol * Math.pow(hashBase, degree));
      }
    } else {
      hash *= hashBase;
      int leftmostSymbol = getCi(str, start - 1);
      hash -= (int) (leftmostSymbol * Math.pow(hashBase, dnaLength));
      int rightmostSymbol = getCi(str, start + dnaLength - 1);
      hash += rightmostSymbol;
    }
    return hash;
  }

  private int getCi(String str, int pos) {
    return switch (str.charAt(pos)) {
      case 'A' -> 0;
      case 'C' -> 1;
      case 'G' -> 2;
      case 'T' -> 3;
      default -> 0;
    };
  }

  public static void main(String[] args) {
    assertThat(
        new RepeatedDNARolingHash().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),
        is(List.of("AAAAACCCCC", "CCCCCAAAAA")));
    assertThat(
        new RepeatedDNARolingHash().findRepeatedDnaSequences("AAAAAAAAAAAAA"),
        is(List.of("AAAAAAAAAA")));
  }
}
