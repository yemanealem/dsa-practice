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
