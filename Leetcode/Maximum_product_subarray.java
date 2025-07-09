public class Maximum_product_subarray {
    public static int max_product_subarray(int arr[]) {
        int n = arr.length;
        int lp = 1;
        int rp = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lp = (lp == 0 || lp < Integer.MIN_VALUE) ? 1 : lp;
            rp = (rp == 0 || rp < Integer.MIN_VALUE) ? 1 : rp;

            lp *= arr[i];
            rp *= arr[n - 1 - i];

            ans = Math.max(ans, Math.max(lp, rp));
        }
        return ans;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, -2, -5, 6, -1, 4 };
        int ans = max_product_subarray(arr);
        System.out.println(ans);
    }

}
