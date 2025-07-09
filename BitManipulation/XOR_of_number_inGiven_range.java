//so in this problem given a range n
//suppose given n=4 
//return 1^2^3^4
//answer 
//n=1 => 1
//n=2 => 3
//n=3 => 0
//n=4 => 4
//n=5 => 1
//n=6 => 7
//n=8 => 8
//n=9 => 1

//from the above observation => 
//n%4==1 =>1
//n%4==2 =>n+1
//n%4==3 =>0
//n%4==0 =>n

public class XOR_of_number_inGiven_range {
    public static int function(int n) {
        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else if (n % 4 == 3) {
            return 0;
        } else if (n % 4 == 0) {
            return n;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int ans = function(n);
        System.out.println(ans);

        // if you have to given the range L to R
        // return function(L-1)^function(R)

    }
}
