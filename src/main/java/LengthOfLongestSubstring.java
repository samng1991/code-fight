/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
        int length = 1, longestLength = 1, charIndex;
        char c;
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            charIndex = sb.toString().indexOf(c);
            // if char appear in before substring
            if (charIndex != -1) {
                // substring length = total substring length - repeated substring length
                length = length - (charIndex + 1);
                // if char = a then gabc -> bc
                sb = new StringBuilder(sb.substring(charIndex + 1));
            }

            // append char, substring length + 1, compare with longestLength
            sb.append(c);
            length++;
            longestLength = Math.max(length, longestLength);
        }
        return longestLength;
    }

    public static void main(String args[]) throws Exception {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
