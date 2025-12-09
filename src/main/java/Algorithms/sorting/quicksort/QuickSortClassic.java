package Algorithms.sorting.quicksort;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;

import static CommonAlgorithms.Util.swap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortClassic {

    private static SecureRandom random = new SecureRandom();
    private int[] sort(int[] nums) {

        if (nums.length < 2) {
            return nums;
        }
        int low = 0;
        int high = nums.length - 1;
        sortRecursively(nums, low, high);
        return nums;
    }

    private void sortRecursively(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = random.nextInt(low, high+1);
        int i = low;
        int j = high;
        int k = low;
        int pivot = nums[pivotIndex];
        while (k<=j) {
            if(nums[k] < pivot) {
                swap(nums, k, i);
                i++;
                k++;
            } else if(nums[k] > pivot) {
                swap(nums, k, j);
                j--;
            } else k++;
        }

        sortRecursively(nums, low, i - 1);
        sortRecursively(nums, j + 1, high);
    }

    @Test
    void test() {
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6, 7}, sort(new int[]{7, 6, 5, 4, 3, 2, 1})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{1, 2, 3, 4, 6, 5})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{2, 1, 3, 4, 5, 6})));
        assertEquals(0, Arrays.compare(new int[]{1, 3, 5}, sort(new int[]{5, 1, 3})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 2}, sort(new int[]{2, 2, 1})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3}, sort(new int[]{3, 1, 2})));
        assertEquals(0, Arrays.compare(new int[]{1, 2, 3}, sort(new int[]{3, 2, 1})));
    }
}
