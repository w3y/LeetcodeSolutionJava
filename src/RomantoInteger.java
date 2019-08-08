/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together.
Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger {

    public int romanToInt(String s) {
        int result = 0;
        char[] sArr = s.toCharArray();
        int[] digits = buildDigits();
        int sLen = sArr.length;
        for (int i = 0; i < sLen; i++) {
            int next = i + 1;
            char c = sArr[i];
            if (next >= sLen) {
                result += digits[c - 'A'];
            } else {
                char n = sArr[next];
                boolean isComplicated =
                        (c == 'I' && (n == 'V' || n == 'X')) ||
                                (c == 'X' && (n == 'L' || n == 'C')) ||
                                (c == 'C' && (n == 'D' || n == 'M'));

                if (isComplicated) {
                    result += digits[n - 'A'] - digits[c - 'A'];
                    i = next;
                } else {
                    result += digits[c - 'A'];
                }
            }
        }
        return result;
    }

    public int[] buildDigits() {
        int[] digits = new int[24];
        digits['I' - 'A'] = 1;
        digits['V' - 'A'] = 5;
        digits['X' - 'A'] = 10;
        digits['L' - 'A'] = 50;
        digits['C' - 'A'] = 100;
        digits['D' - 'A'] = 500;
        digits['M' - 'A'] = 1000;
        return digits;
    }

    public static void main(String[] args) {
        RomantoInteger romantoInteger = new RomantoInteger();
        System.out.println(romantoInteger.romanToInt("IV"));
        System.out.println(romantoInteger.romanToInt("VI"));
        System.out.println(romantoInteger.romanToInt("VIII"));
        System.out.println(romantoInteger.romanToInt("XVIII"));
    }
}
