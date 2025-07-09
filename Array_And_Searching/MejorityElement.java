import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class MejorityElement {
    //Brute force Approach
    public static int BruteForce(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return v[i];
        }

        return -1;
    }
 //Better 
 
public static int Better(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }


        return -1;
//         Time Complexity: O(N*logN) + O(N), where N = size of the given array.
// Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times. If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

// Space Complexity: O(N) as we are using a map data structure.
    }
    ///Optimal=> Moore’s Voting Algorithm: TC=O(n)+O(n)
    public static int optimal(int v[]){
        int cnt=0;
        int ele=0;
        for(int i=0;i<v.length;i++){
            if(cnt==0){
                cnt=1;
                ele=v[i];

            }else if(ele==v[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int i=0;i<v.length;i++){
            if(ele==v[i]){
                cnt1++;
            }
        }
        if(cnt1>v.length/2){
            return ele;
        }
        return -1;

    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = optimal(arr);
        System.out.println(ans);
    
}
}