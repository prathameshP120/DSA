import java.util.Arrays;

public class SecondLargestElement {
    public static int getSecondLargest(int arr[], int n) {
        // Tc=O(nlogn)
        Arrays.sort(arr);
        return arr[n - 2];
    }

    public static int secondlagest(int arr[], int n) {
        // here the two passes is required that why TC=O(n+n)

        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        int sLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    public int secLargest(int arr[], int n) {
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
            if (slargest < arr[i] && arr[i] != largest) {
                slargest = arr[i];
            }
        }
        return slargest;
    }

    public static int seclargest(int arr[], int n) {
        int largest = arr[0];
        int seclargest = -1;
        for (int i = 0; i < n; i++) {
            if (largest < arr[i]) {
                seclargest = largest;
                largest = arr[i];
            } else if (arr[i] > seclargest && arr[i] != largest) {
                seclargest = arr[i];
            }
        }
        return seclargest;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 7, 5 };
        int n = arr.length;
        // brute force and this method only works when element in the array are not
        // duplicate
        // int ans = getSecondLargest(arr, n);

        // second largest with tc=O(2n)
        // int ans = secondlagest(arr, n);

        // With only one pass TC=O(n);
        int ans = seclargest(arr, n);
        System.out.println(ans);

    }
}
