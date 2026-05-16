import java.util.ArrayList;
import java.util.List;

public class Prathamesh {

    public static void function(int n, List<List<Integer>> ans, int wt[], int toxi[], List<Integer> list, int ind, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (ind >= n || target < 0) {
            return;
        }

        list.add(ind);
        target -= wt[ind];
        function(n, ans, wt, toxi, list, ind + 1, target);

        list.remove(list.size() - 1);
        target += wt[ind];
        function(n, ans, wt, toxi, list, ind + 1, target);
    }

    public static boolean isValid(List<Integer> list) {
        for (int i = 0; i<list.size() - 1; i++) {
            int nextnumber=list.get(i + 1) - 1;
            if (list.get(i)==nextnumber){
                return false;
            }
        }
        return true;
    }

    public static int calculateSum(List<Integer> list, int toxi[]) {
        int sum = 0;
        for (int ele:list) {
            sum+= toxi[ele];
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int targetWeigth = 10;
        int wt[] = {1, 4, 3, 2, 6};
        int toxicity[] = {2, 3, 2, 3, 4};

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        function(n,ans,wt,toxicity,ls, 0,targetWeigth);

        System.out.println("all possible combination that satisfy condition");
        for (int i = 0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<ans.size(); i++) {
            if (isValid(ans.get(i))) {
                res.add(new ArrayList<>(ans.get(i)));
            }
        }

        int minitoxi = Integer.MAX_VALUE;
        int ansIndex = 0;

        for (int k=0; k<res.size(); k++) {
            int curr=calculateSum(res.get(k), toxicity);
            if (curr<minitoxi) {
                minitoxi = curr;
                ansIndex = k;
            }
        }
     System.out.println("after remove the adjacent index subset And Considering which subset has minimized toxicity");
     System.out.println(res.get(ansIndex));
    }
}
