
// Problem Statement: Given two strings, check if two strings are anagrams of each other or not.

// Examples:

// Example 1:
// Input: CAT, ACT
// Output: true
// Explanation: Since the count of every letter of both strings are equal.

// Example 2:
// Input: RULES, LESRT 
// Output: false
// Explanation: Since the count of U and T  is not equal in both strings.

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s,String t){
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch, 0)+1);

        }

        for(int i=0;i<t.length();i++){
             char ch=t.charAt(i);
             if(hm.containsKey(ch)){
                hm.put(ch,hm.getOrDefault(ch,0)-1);
                if(hm.get(ch)==0){
                    hm.remove(ch);
                }
             }else{
                return false;
             }
        }

        return hm.isEmpty();
    }
    public static void main(String[] args) {
        String s="cat";
        String t="act";
        boolean ans=isAnagram(s,t);
        System.out.println(ans);
    }
}
