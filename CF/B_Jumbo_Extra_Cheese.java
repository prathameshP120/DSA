// FINAL INTUITION (REMEMBER THIS)

// 👉 For each rectangle (a, b):

// You can rotate it
// So you choose one side to repeat many times
// And the other side will matter only once globally
// 🔥 KEY IDEA
// 👉 Smaller side → used many times
// sum(min(a, b))

// 👉 This builds one dimension (your width)

// 👉 Larger side → only the largest matters
// max(max(a, b))

// 👉 This builds the other dimension (your height)

// 🧠 WHY?
// 💡 Think like this:
// Every rectangle contributes its smaller side continuously
// But the shape will only grow as tall as the tallest rectangle
// 📦 Visual (your mindset)
//         ┌──────────────┐   ← tallest rectangle (height = max)
//         │              │
//         │              │
//         └──────────────┘
//    ┌──────────┐
//    │          │
//    └──────────┘
//  ┌────┐
//  │    │
//  └────┘

// <------ total width = sum(min) ------>
// ⚡ FINAL SHAPE BEHAVES LIKE
// width  = sum(min sides)
// height = max(max sides)
// 🎯 PERIMETER
// perimeter = 2 × (width + height)
//           = 2 × (sum(min) + max(max))




import java.util.*;
public class B_Jumbo_Extra_Cheese {
    public static void solve(Scanner sc){
       
          int n=sc.nextInt();
          long sum=0;  //used for the summetion of width part
          long maxi=0;
          for(int i=0;i<n;i++){
              int a=sc.nextInt();
              int b=sc.nextInt();
              sum+=Math.min(a,b);
              maxi=Math.max(maxi,Math.max(a,b));
          }
          System.out.println(2*(sum+maxi));

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
             solve(sc);
             t--;
        }
    }
}
