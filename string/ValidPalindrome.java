/*
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
 Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

 */
public class ValidPalindrome {
  public static boolean checkPaindrome(String s) {
    int n = s.length();

    int i = 0;
    int j = n - 1;
    while (i <= j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }
      int ch1 = Character.toLowerCase(s.charAt(i));
      int ch2 = Character.toLowerCase(s.charAt(j));

      if (ch1 != ch2) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    boolean ans = checkPaindrome(s);
    System.out.println(ans);
  }
}
