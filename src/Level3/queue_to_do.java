package Level3;

import java.util.Scanner;

/**
 * Created by abdullah on 8/16/17.
 */
public class queue_to_do
{
    static int f(int a)
    {
        if(a<=0)return 0;
         int res[] = {a,1,a+1,0};
         return res[a%4];
    }
    static int xor(int s,int l)
    {
        return f(l)^f(s-1);
    }
    public static int answer(int start, int length) {

        // Your code goes here.
        int ans=0;
        int ss=start;
        int ll=length;
        int temp=0;
        int t=0;
       while(true)
       {
           int s=ss;
           int e=(ss+ll)-1;
           ans^=xor(s,e);
           if(s==e)
           {
               break;
           }

           ll--;
           temp++;
           t=e+temp;
           ss=t;
       }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int s;
        int l;
        s=scan.nextInt();
        l=scan.nextInt();
        System.out.println(answer(s,l));
    }
}
