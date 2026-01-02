public class IsPalindrome {

    public boolean isPalindrome(int x) {
        
        // Using Methode one 
        // String s = String.valueOf(x);
    
        // for(int i=0;i<s.length()/2;i++)
        // {
        //   if( s.charAt(i) != s.charAt(s.length()-1-i) )
        //   {
        //     return  false;
        //   }

        // }
        //  return true;
  
        //Refactored Methode
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;

    }

    public static void main(String[] args) {
        IsPalindrome pn = new IsPalindrome();

        int num = 121;
        System.out.println(num + " is palindrome? " + pn.isPalindrome(num));

        num = -121;
        System.out.println(num + " is palindrome? " + pn.isPalindrome(num));

        num = 10;
        System.out.println(num + " is palindrome? " + pn.isPalindrome(num));
    }
}
