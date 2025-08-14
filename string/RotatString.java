//796. Rotate String
// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.
public class RotatString {
    public static boolean isRotate(String s,String goal){
          if(s.length()==goal.length() && (s+s).contains(goal)){
              return true;
          }
          return false;
    }
    public static void main(String[] args) {
        String  s = "abcde";
        String goal = "cdeab";
        boolean ans=isRotate(s,goal);
        System.out.println(ans);
    }
}
