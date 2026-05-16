import java.util.*;
public class Queue_at_the_School{
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        //n=> number of the children  and t time transformation
        int n=sc.nextInt();
        int t=sc.nextInt();
        //string
        String s=sc.next();

        //maintain a queue for it 
        char queue[]=s.toCharArray();
        while(t>0){
             for(int i=0;i<n-1;i++){
                 if(queue[i]=='B' && queue[i+1]=='G'){
                      char temp=queue[i];
                      queue[i]=queue[i+1];
                      queue[i+1]=temp;
                      i++;
                 }
                 
             }
             t--;
        }
        String ans=new String(queue);
        System.out.println(ans);
    }
}