public class Pairs_in_array {
    public static void printPairs(int numbers[]){

        for(int i=0; i<numbers.length; i++){
            int curr=numbers[i];

            for(int j=i+1; j<numbers.length; j++){

                System.out.print("(" +curr +","+ numbers[j]+")" +" ");   //first time error due to not use +
            }
            System.out.println();
            System.out.println();

           
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        
        int numbers[]={2,4,6,8,10};
        printPairs(numbers);

    }
}
