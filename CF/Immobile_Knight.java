import java.util.*;
public class Immobile_Knight{
    public static boolean isIsolated(int r,int c,int n,int m){
        int dirR[]={2,2,-2,-2,1,1,-1,-1};
        int dirC[]={1,-1,1,-1,2,-2,2,-2};
        for(int i=0;i<8;i++){
            int nr=dirR[i]+r;
            int nc=dirC[i]+c;
            if(nr>=1 && nr<=n && nc>=1 && nc<=m){
                 return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            boolean found=false;
            //1-based indexing
            for(int i=1;i<=n && !found;i++){
                for(int j=1; j<=m && !found; j++){
                    if(isIsolated(i,j,n,m)){
                         System.out.println(i+" "+j);
                         found=true;
                    }
                }
            }
            
            if(!found){
                System.out.println(1+" "+1);
            }
        }
    }
}