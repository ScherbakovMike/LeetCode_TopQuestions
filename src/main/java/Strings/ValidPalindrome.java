package Strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        var cleanedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return cleanedString.equals(new StringBuilder(cleanedString).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
