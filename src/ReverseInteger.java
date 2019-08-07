public class ReverseInteger {
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
        return (int)r;
    }

    public static void main(String[] args) {
        int input = 120;
        ReverseInteger solution = new ReverseInteger();
        int output = solution.reverse(input);
        System.out.println(output);
    }
}
