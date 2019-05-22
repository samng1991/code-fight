/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] c = s.toCharArray();

//        String reverse = "";
        String longestPalindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                boolean valid = true;
                String palindrome = s.substring(i, j);
                for (int k = i; k <= j / 2; k++) {
                    if (c[k] != c[j - k]) {
                        valid = false;
                        break;
                    }
                }

                if (valid && palindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = palindrome;
                }

//                reverse = "";
//                String testString = s.substring(i, j + 1);
//                int length = testString.length();
//
//                if ((length & 1) == 0) {
//                    for (int k = length - 1; k >= length / 2; k--)
//                        reverse = reverse + testString.charAt(k);
//
//                    if (testString.substring(0, length / 2).equals(reverse) && length > longestPalindrome.length()) {
//                        longestPalindrome = testString;
//                    }
//                } else {
//                    for (int k = length - 1; k >= length / 2 + 1; k--)
//                        reverse = reverse + testString.charAt(k);
//
//                    if (testString.substring(0, length / 2).equals(reverse) && length > longestPalindrome.length()) {
//                        longestPalindrome = testString;
//                    }
//                }
            }
        }
        return longestPalindrome;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(longestPalindrome("yyhhoabcbaop"));
    }

}
