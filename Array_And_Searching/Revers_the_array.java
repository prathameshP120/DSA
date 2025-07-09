
import java.util.*;

public class Revers_the_array {

    public static void revers(int numbers[]) {

        int last = numbers.length - 1;
        int first = 0;

        while (first < last) {
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;
            first++;
            last--;

        }

    }

    public static void main(String[] args) {
        int numbers[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, };
        revers(numbers);

        // For printing an revers array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

    }
}
