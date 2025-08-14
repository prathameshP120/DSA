import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
  
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        String arr[]=s.split(" ");
        if(arr.length!=pattern.length()){ 
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                  //we check is it map to right string word
                  if(!map.get(pattern.charAt(i)).equals(arr[i])){
                       return false;
                  }
            }else{
                if(set.contains(arr[i])){
                    return false;
                }
                map.put(pattern.charAt(i),arr[i]);
                set.add(arr[i]);
            }
        }
        return true;

    }
    public static void main(String[] args) {
//         Input: pattern = "abba", s = "dog cat cat dog"

// Output: true

// Explanation:

// The bijection can be established as:

// 'a' maps to "dog".
// 'b' maps to "cat".
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"

// Output: false
    }
}

