public class longestPallindromicSubstring {
    public static String ans(String s){
        int n=s.length();

        int high;
        int low;
        String lps="";
        for(int i=0;i<n;i++){
             
            //for handling the odd length string 
            high=i;
            low=i;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                  String pallindrom=s.substring(low,high+1);
                  if(pallindrom.length()>lps.length()){
                     lps=pallindrom;

                  }
                  low--;
                  high++;
            }

            //for handling the even length

            low=i;
            high=i+1;
           while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                  String pallindrom=s.substring(low,high+1);
                  if(pallindrom.length()>lps.length()){
                     lps=pallindrom;
                  }
                  low--;
                  high++;
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String s="babad";

        System.out.println(ans(s));

    }
}
