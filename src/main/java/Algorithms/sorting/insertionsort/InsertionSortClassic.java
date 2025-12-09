package Algorithms.sorting.insertionsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortClassic {

    private int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // considering that all previous elements is a sorted sequence
            int buf = nums[i];
            int pos = i - 1;
            while (pos >= 0 && nums[pos] > buf) {
                nums[pos+1] = nums[pos];
                pos--;
            }
            nums[pos+1] = buf;
        }
        return nums;
    }

    @Test
    void test() {
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{6, 5, 4, 3, 2, 1})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{1, 2, 3, 4, 6, 5})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{2, 1, 3, 4, 5, 6})));
    }
}
