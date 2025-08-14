public class DecodeMessage {
    public static String decode(String key,String message){
           char map[]=new char[256];  //because ASCII characters have values from 0 to 255

           char start='a';
           for(char ch:key.toCharArray()){
                if(ch!=' ' && map[ch]==0){
                     map[ch]=start;
                start++;
                }
               
           }

           //decode the message
           StringBuilder ans=new StringBuilder(); 
           for(char ch:message.toCharArray()){
                  if (ch == ' ') {
                ans.append(' ');
            } else {
                ans.append(map[ch]);
            }
           }
           return ans.toString();

    }
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";  //output=> "this is a secret"
        System.out.println(decode(key,message));
    }
}
