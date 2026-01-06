public class PlusOne {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        int[] digits = {9, 9, 9};
        int[] res = obj.plusOne(digits);

        System.out.println(java.util.Arrays.toString(res));
    }
    
}