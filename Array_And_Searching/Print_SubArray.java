public class Print_SubArray {
    public static void print_sub_array(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");

                }
                System.out.println();

            }
            System.out.println(); // -----> For printing a more space

        }
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        print_sub_array(numbers);
    }
}
