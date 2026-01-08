public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] str = {'h','e','l','l','o'};
        
        System.out.println("Original: " + new String(str));
        rs.reverseString(str);
        System.out.println("Reversed: " + new String(str));
    }
}
