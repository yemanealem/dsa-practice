public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = x < 0;
        long num = Math.abs((long)x); 
        String reversedStr = new StringBuilder(String.valueOf(num)).reverse().toString();
        long reversedNum = Long.parseLong(reversedStr);
        
        if (reversedNum > Integer.MAX_VALUE) return 0; 
        return negative ? (int)-reversedNum : (int)reversedNum;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
        System.out.println(ri.reverse(-123));  
        System.out.println(ri.reverse(120));   
    }
}

/*


public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;  // Get last digit
            x /= 10;           // Remove last digit
            
            // Check overflow before multiplying by 10
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop; // Append digit
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));      // 321
        System.out.println(ri.reverse(-123));     // -321
        System.out.println(ri.reverse(120));      // 21
        System.out.println(ri.reverse(1534236469));// 0 (overflow)
    }
}



*/