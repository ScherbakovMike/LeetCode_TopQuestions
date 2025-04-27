package TwoPointers;

public class NextPalindromeUsingSameDigits {

    public static String findNextPalindrome(String numStr) {
        char[] arr = numStr.toCharArray();
        int rangeRight;
        rangeRight = arr.length / 2 - 1;
        int i = rangeRight - 1;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        int j = rangeRight;
        if (i >= 0) {
            // place at the ith position the next number
            while (j >= i && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        } else return "";
        int k = i + 1;
        int l = rangeRight;
        while (k < l) {
            swap(arr, k, l);
            k++;
            l--;
        }

        // mirror string
        for (k = 0; k < arr.length / 2; k++) {
            arr[arr.length - 1 - k] = arr[k];
        }
        return new String(arr);
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        Input
//                num =
//
//        "4534589961 9 1699854354
//        Use Testcase
//        Output
//        "4534589916 9 6199854354"
//        Expected
//        "4534591689 9 9861954354"
        String numStr = "1231321";
        String result = findNextPalindrome(numStr);
        System.out.println("Next palindrome using same digits: " + result);
        // 4534591689 9 9861954354
    }
}
