/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
    Input: 121
    Output: true

Example 2:
    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public int reverse(int x) {
        long r = 0;
        while (x != 0) {
            int carry = x % 10;
            x = x / 10;
            r = r * 10 + carry;
            if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) r;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        if (x == reverse(x)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber check = new PalindromeNumber();
        System.out.println(check.isPalindrome(0));
        System.out.println(check.isPalindrome(121));
        System.out.println(check.isPalindrome(2147483647));
    }
}