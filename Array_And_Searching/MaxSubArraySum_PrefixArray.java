
public class MaxSubArraySum_PrefixArray {
   public static void print_max_subArray_Sum(int numbers[]) {
      int currSum = 0;
      int maxSum = Integer.MIN_VALUE;
      int prefix[] = new int[numbers.length];

      // Calculate Prefix Array
      prefix[0] = numbers[0];
      for (int i = 1; i < prefix.length; i++) {
         prefix[i] = prefix[i - 1] + numbers[i];

      }
      for (int i = 0; i < numbers.length; i++) {
         int start = i;
         for (int j = i; j < numbers.length; j++) {
            int end = j;
            currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
            if (maxSum < currSum) {
               maxSum = currSum;

            }

         }
      }
      System.out.println("max sum" + maxSum);

   }

   public static void main(String[] args) {
      int numbers[] = { 1, -2, 6, -1, 3 };
      print_max_subArray_Sum(numbers);
   }
}
