public class LongestCommanPrefix {
    public static String longestString(String words[]){
         int n=words.length;
         ///length of comman substring 
         int length=words[0].length();

         for(int i=1;i<n;i++){
              length=Math.min(length,words[i].length());
              
              //traverse in each word individually
              for(int j=0;j<words[i].length();j++){
                  char c=words[0].charAt(j);
                  char d=words[i].charAt(j);
                  if(c!=d){
                     length=j;
                     break;
                  }
              }
         }
         return words[0].substring(0,length);
    }
    public static void main(String[] args) {
        String words[]={"flower","flow","flight"};
        String ans=longestString(words);
        System.out.println(ans);
    }
}
