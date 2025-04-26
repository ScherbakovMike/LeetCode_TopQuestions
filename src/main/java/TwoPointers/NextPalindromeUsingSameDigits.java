package TwoPointers;

public class NextPalindromeUsingSameDigits {

    public static String findNextPalindrome(String numStr) {
        char[] arr = numStr.toCharArray();
        int rangeRight = 0;
        if (arr.length % 2 == 0) {
            rangeRight = arr.length / 2;
        } else {
            rangeRight = arr.length / 2 - 1;
        }
        int i = rangeRight - 1;
        // find the place where we can swap digits
        // 12321
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "";
        }
        // find ar right the digit that is slightly bigger than arr[i]
        int j = i + 1;
        int diff = Integer.MAX_VALUE;
        int nextBiggerIndex = i + 1;
        while (j <= rangeRight) {
            if ((arr[j] - arr[i]) < diff) {
                nextBiggerIndex = j;
                diff = arr[j] - arr[i];
            }
            j++;
        }
        // swap arr[i] and arr[nextBiggerIndex]
        char buf = arr[i];
        arr[i] = arr[nextBiggerIndex];
        arr[nextBiggerIndex] = buf;

        // mirror string
        for (int k = 0; k < arr.length / 2; k++) {
            arr[arr.length - 1 - k] = arr[k];
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String numStr = "23143034132";
        String result = findNextPalindrome(numStr);
        System.out.println("Next palindrome using same digits: " + result);
        // 23314 041332
    }
}
