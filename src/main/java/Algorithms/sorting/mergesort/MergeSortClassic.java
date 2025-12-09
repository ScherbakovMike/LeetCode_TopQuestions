package Algorithms.sorting.mergesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static CommonAlgorithms.Util.merge;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortClassic {

    private int[] sort(int[] nums) {
        // until nums.length is greater than 1
        if(nums.length <= 1){ return nums;}

        // divide it to 2 parts
        var leftPart = Arrays.copyOfRange(nums, 0, nums.length/2);
        var rightPart = Arrays.copyOfRange(nums, nums.length/2, nums.length);

        // sort them recursively
        leftPart = sort(leftPart);
        rightPart = sort(rightPart);

        // and merge back
        nums = merge(leftPart, rightPart);
        return nums;
    }

    @Test
    void test() {
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6, 7}, sort(new int[]{7, 6, 5, 4, 3, 2, 1})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{1, 2, 3, 4, 6, 5})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{2, 1, 3, 4, 5, 6})));
    }
}
