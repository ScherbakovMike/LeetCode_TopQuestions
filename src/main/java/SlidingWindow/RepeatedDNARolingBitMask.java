package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
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
public class RepeatedDNARolingBitMask {

  public List<String> findRepeatedDnaSequences(String str) {
    final int DNA_LEN = 10;
    Set<String> result = new HashSet<>();
    Set<Integer> seen = new HashSet<>();
    int bitMask = 0;
    for (int start = 0; start <= (str.length() - DNA_LEN); start++) {
      bitMask = calculateRollingHash(str, start, DNA_LEN, bitMask);
      if (!seen.add(bitMask)) {
        result.add(str.substring(start, start + DNA_LEN));
      }
    }
    return new ArrayList<>(result);
  }

  private int calculateRollingHash(String str, int start, int dnaLength, int bitMask) {
    if (bitMask == 0) {
      for (int i = start; i < (start + dnaLength); i++) {
        int symbol = getCi(str, i);
        bitMask = bitMask << 2;
        bitMask |= symbol;
      }
    } else {
      int symbol = getCi(str, start + dnaLength - 1);
      bitMask = bitMask << 2;
      bitMask &= (~(3 << 2 * dnaLength));
      bitMask |= symbol;
    }
    return bitMask;
  }

  private int getCi(String str, int pos) {
    return switch (str.charAt(pos)) {
      case 'A' -> 0b00;
      case 'C' -> 0b01;
      case 'G' -> 0b10;
      case 'T' -> 0b11;
      default -> 0b00;
    };
  }

  public static void main(String[] args) {
    assertThat(
        new RepeatedDNARolingBitMask().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),
        is(List.of("AAAAACCCCC", "CCCCCAAAAA")));
    assertThat(
        new RepeatedDNARolingBitMask().findRepeatedDnaSequences("AAAAAAAAAAAAA"),
        is(List.of("AAAAAAAAAA")));
    assertThat(
        new RepeatedDNARolingBitMask()
            .findRepeatedDnaSequences(
                "GGCCATTGCCTGAACCCGGACCGGTACGGACCGGTAACCCCCGCCGTAGGCCGCCGTAGGCAAAGGAAATGGGAGTATCGCAAAATGCTGTAAAATGCTGTCCCATCACTTCAGACGCGCAGAGCGATGTTCGCGCGTATTTCCTCTCGAACCCGCAATGACGGGAGCCACCCCTTTCCATATTAGTCTCGAAAACTCCT"),
        containsInAnyOrder("AAAATGCTGT", "CCGCCGTAGG", "CGCCGTAGGC", "CGGACCGGTA"));
  }
}
