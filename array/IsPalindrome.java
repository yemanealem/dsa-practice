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






/*       


# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
- A number is a palindrome if it reads the same forward and backward.

- Instead of converting the number to a string (uses extra space), we can reverse half of the number mathematically and compare it with the other half.

- For numbers with an odd number of digits, the middle digit doesn’t affect palindrome property.

# Approach
<!-- Describe your approach to solving the problem. -->
1. Edge cases:

    - If x < 0, return false (negative numbers can’t be palindrome).

    - If x % 10 == 0 and x != 0, return false (numbers ending with 0 cannot be palindrome).

2. Initialize m = 0 → this will store the reversed digits of half the number.
3. Loop while x > m:

    m = m * 10 + x % 10 → append the last digit of x to m

    x /= 10 → remove the last digit from x

4. After the loop, compare x and m:

    If even number of digits → x == m

    If odd number of digits → x == m / 10 (ignore middle digit)
5. Return the result.

# Complexity
Time complexity: 𝑂 ( log ⁡ 10 𝑛 ) O(log 10 ​ n) → we process half of the digits only Space complexity: 𝑂 ( 1 ) O(1) → only integer variables used

# Code
```java []
class Solution {
    public boolean isPalindrome(int x) {
        
  
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
        
    }
}
```







*/
