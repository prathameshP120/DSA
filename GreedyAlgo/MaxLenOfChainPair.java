import java.util.*;
public class MaxLenOfChainPair {
    public static void main(String[] args) {
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        //Arrays.sort(pairs, Comparator.comparingDouble(i -> i[1]));
        Arrays.sort(pairs,(a,b)->{
            if(a[1]<b[1]){
                return -1;
            }
            else if(a[1]>b[1]){
                return 1;
            }else{ 
                return 0;
            }
        }); 
        int maxChainLength = 1;
        int chainEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (chainEnd < pairs[i][0]) {
                maxChainLength += 1;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("maximum chain lenght : " + maxChainLength);

    }

}
