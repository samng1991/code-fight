public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     * Example 1:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * <p>
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */

    public static String convert(String s, int numRows) {
        int length = s.length();
        if (numRows <= 1) {
            return s;
        }

        /**
         * P   A   H   N
         * A P L S I I G
         * Y   I   R
         *
         * P     I    N
         * A   L S  I G
         * Y A   H R
         * P     I
         *
         * 0: (numRows + numRows - 1)
         * 1: (numRows + numRows - 1) - 2
         * 2: (numRows + numRows - 1)
         *
         * 0: (numRows + numRows - 1)
         * 1: (numRows + numRows - 1) - 2
         * 2: (numRows + numRows - 1) - 2 - 2
         * 3: (numRows + numRows - 1)
         */
        char[] c1 = s.toCharArray();
        char[] c2 = new char[length];
        int index = 0, indexInRow, currentRow = 0;
        while (currentRow < numRows) {
            int nextCharIndex = 0;
            int firstLastRowNextCharIndex = numRows + numRows - 2; // the next char in first or last row is (numRows + numRows - 2)
            indexInRow = 0;
            while (currentRow + nextCharIndex < length) {
                int correction; // 2nd row next char is first row's next char index - 2 and so on until middle of numRows
                // if not first or last row, the next char index will change to opposite row next index
                if ((indexInRow & 1) == 0) {
                    correction = - (2 * (currentRow % (numRows - 1)));
                } else {

                    correction = - (2 * ((numRows - 1 - currentRow) % (numRows - 1)));
                }

                c2[index] = c1[currentRow + nextCharIndex];
                nextCharIndex += firstLastRowNextCharIndex + correction;
                index++;
                indexInRow++;
            }
            currentRow++;
        }
        return new String(c2);
    }

    public static void main(String args[]) throws Exception {
        System.out.println(convert("A", 2));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

}
