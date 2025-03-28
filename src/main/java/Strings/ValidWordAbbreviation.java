package Strings;

/*
408. Valid Word Abbreviation
Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise, return FALSE.

A certain word "calendar" can be abbreviated as follows:

"cal3ar" ("cal end ar" skipping three characters "end" from the word "calendar" still matches the provided abbreviation)

"c6r" ("c alenda r" skipping six characters "alenda" from the word "calendar" still matches the provided abbreviation)
 */
public class ValidWordAbbreviation {

    public static boolean validWordAbbreviation(String word, String abbr) {
        int posWord = 0;
        int posAbbr = 0;
        StringBuilder skip = new StringBuilder();
        while (posAbbr < abbr.length()) {
            if (charIsDigit(abbr.charAt(posAbbr))) {
                if (skip.length()==0 && abbr.charAt(posAbbr) == '0') {
                    return false;
                }
                skip.append(abbr.charAt(posAbbr));
                posAbbr++;
                continue;
            }
            if (skip.length()!=0 && !charIsDigit(abbr.charAt(posAbbr))) {
                posWord += Integer.parseInt(skip.toString());
                if (posWord > word.length()) return false;
                skip.setLength(0);
                continue;
            }
            if (skip.length()==0 && !charIsDigit(abbr.charAt(posAbbr))) {
                if (abbr.charAt(posAbbr) != word.charAt(posWord)) return false;
                posAbbr++;
                posWord++;
            }
        }
        if (skip.length() != 0) {
            posWord += Integer.parseInt(skip.toString());
        }
        return posWord == word.length();
    }

    private static boolean charIsDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void main(String[] args) {
//        System.out.println(validWordAbbreviation("calendar", "cal3ar"));
//        System.out.println(validWordAbbreviation("calendar", "c6r"));
//        System.out.println(validWordAbbreviation("calendar", "8"));
//        System.out.println(validWordAbbreviation("calendar", "cale0ndar"));
//        System.out.println(validWordAbbreviation("calendar", "c24r"));

        System.out.println(validWordAbbreviation("kkusiyrkmr", "10"));
    }
}
