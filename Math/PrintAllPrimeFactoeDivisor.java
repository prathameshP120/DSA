import java.util.ArrayList;

public class PrintAllPrimeFactoeDivisor{
    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }
         for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
         }
         return true;
    }

    public static void ans(int n){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(isPrime(i)){
                    list.add(i);
                }
            }
            if (n/i!=i){
                if(isPrime(n/i)){
                    list.add(n/i);
                }
            }
            
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) {
        int n=60;
        //with TC=O(squar(n)*2*squar(n))
        ans(n);

    }
}