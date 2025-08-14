public class LargestOddNumber {
    
}
class Solution {
    public String largestOddNumber(String num) {
        //here the rember that the last number 
        //in the substring must not be the divisible by 2 for odd substring 
        for(int i=num.length()-1;i>=0;i--){
             if(Character.getNumericValue(num.charAt(i))%2==1){
                   return num.substring(0,i+1);
             }
        }
        return "";
    }
}