import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElementsbySign {
    public static void Bruteforce(int A[]){
        //TC=O(n+n/2)
        //SC=O(n/2+n/2)
        //for storing the positive and negative element 
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        
        for(int ele:A){
            if(ele>0){
                pos.add(ele);
            }else{
                neg.add(ele);
            }
        }
        //Making the result 
        for(int i=0;i<A.length/2;i++){
                A[2*i+1]=neg.get(i);
                 A[2*i]=pos.get(i);   
        }
        
        for(int ele:A){
            System.out.print(" "+ele);
        }
    }
    public static void Optimal(int A[]){
        //using the two pointer
        //TC=o(N);
        //SC=O(N);
        int pos=0;
        int neg=1;
        int ans[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                ans[pos]=A[i];
                pos+=2;
             }else{
                ans[neg]=A[i];
                neg+=2;
             }
         }
        for(int ele:ans){
            System.out.print(" " + ele);
        }
    }
    public static void Varity_two(ArrayList<Integer> A){
       
       ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
       int n=A.size();
        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }
        
        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {
  
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }

        for(int i=0;i<A.size();i++){
            System.out.print(" "+A.get(i));
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int A[]= {1,2,-4,-5};
        //BruteForce
        //Bruteforce(A);
        //Optimal
        //Optimal(A);




         ///Variety2
          //int n = 6;
          ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2, -4, -5, -3));
          Varity_two(B);
    }
}
