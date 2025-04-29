package TwoPointers;

public class ValidPalindromeII {
    public static boolean isPalindrome(String string) {

        int low = 0;
        int high = string.length() - 1;
        int errors = 0;
        while (low < high && errors <= 1) {
            if (string.charAt(low) == string.charAt(high)) {
                low++;
                high--;
                continue;
            }

            if (string.charAt(low + 1) == string.charAt(high)
            ) {
                low += 2;
                high--;
                errors++;
            } else if (
                    string.charAt(low) == string.charAt(high - 1)
            ) {
                high -= 2;
                low++;
                errors++;
            } else return false;
        }
        return errors <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().isPalindrome("ABBAB"));
    }
}