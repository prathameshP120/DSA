public class IntegerToRoman {
    
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        convert(sb,'*','M','*',num/1000);
        System.out.println(num/1000);
        num=num%1000;
        System.out.print(num);
        convert(sb,'M','C','D',num/100);
        num=num%100;
        convert(sb,'C','X','L',num/10);
        num=num%10;
         convert(sb,'X','I','V',num);

         return sb.toString();


    }
    public static void convert(StringBuilder sb,char mj,char mi,char md,int val){
        if(val<=3){
            for(int i=0;i<val;i++){
                sb.append(mi);

            }
        }else if(val==4){
            sb.append(mi);
            sb.append(md);

        }else if(val<=8){
            sb.append(md);
            for(int i=6;i<=val;i++){
                sb.append(mi);

            }
        }
        else{
            sb.append(mi);
            sb.append(mj);

        }
    }
   

}
