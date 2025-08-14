import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {
    public static boolean isomorphicstring(String s,String t){
     HashMap<Character,Character> mapping=new HashMap<>();
     
     //for handling such type of examples like Input:  s = "abc" ,t = "dee"
      // 'b' -> 'e' is already done.
      //Now 'c' also wants to map to 'e' — not allowed in one-to-one mapping.
      //we need set 
     HashSet<Character> set=new HashSet<>();
  
     //if both the string does not have an equal length they does not isomorphic
     if(s.length()!=t.length()){{
          return false;
     }}
    for(int i=0;i<s.length();i++){
        char schar=s.charAt(i);
        char tchar=t.charAt(i);
         
        if(mapping.containsKey(schar)){
             if(mapping.get(schar)!=tchar){
                  return false;
             }
        }else{
            //before mapping schar to tchar we have to check that is tchar mapped with some schar ?
            if(set.contains(tchar)){
                 return false;
            }
            mapping.put(schar, tchar);
            set.add(tchar);
        }
    }
    return true;
}
    public static void main(String[] args) {
    //    String   s = "ab"
    //    String t = "aa"
       String s = "egg";
       String t = "add";
      boolean ans=isomorphicstring(s,t);
      System.out.println(ans);


    }
    
}
