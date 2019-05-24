import java.util.Arrays;

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

        char[] c1 = s.toCharArray();

        String longestPalindrome = "";
        StringBuilder palindromeStringBuilder;
        int middleLeft, middleRight, length = c1.length, longestLength = 0, tempIndex;
        for (int i = 0; i < length; i++) {
            palindromeStringBuilder = new StringBuilder();
            middleLeft = i;
            middleRight = i;
            tempIndex = i + 1;

            // find all next char same as current char, set middleRight index, skip i to middleRight index + 1
            palindromeStringBuilder.append(c1[middleLeft]);
            while (tempIndex < length) {
                if (c1[middleLeft] == c1[tempIndex]) {
                    middleRight = tempIndex;
                    palindromeStringBuilder.append(c1[tempIndex]);
                    tempIndex++;
                    i++;
                } else {
                    break;
                }
            }

            // find the min compare times, it should be min of current char to left or right bounding
            int compareTimes = Math.min(middleLeft, length - middleRight - 1);

            // start from middle char, compare left and right hand side char until reach min compare time
            // if same, prepend and append to palindromeStringBuilder
            // if not same break the loop
            for (int j = 1; j <= compareTimes; j++) {
                if (c1[middleLeft - j] == c1[middleRight + j]) {
                    palindromeStringBuilder.insert(0, c1[middleLeft - j]);
                    palindromeStringBuilder.append(c1[middleRight + j]);
                } else {
                    break;
                }
            }

            if (palindromeStringBuilder.length() > longestLength) {
                longestPalindrome = palindromeStringBuilder.toString();
                longestLength = palindromeStringBuilder.length();
            }
        }
        return longestPalindrome;
    }

    public static void main(String args[]) throws Exception {
        long start = System.nanoTime();
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(longestPalindrome("ccc7"));
        System.out.println(longestPalindrome("99ab8ba77"));
        System.out.println(System.nanoTime() - start);
    }

}
