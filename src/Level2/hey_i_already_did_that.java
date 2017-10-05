package Level2;

import java.util.*;

/**
 * Created by abdullah on 8/12/17.
 */
public class hey_i_already_did_that
{
    private static Map<String,Integer> map=new HashMap<String,Integer>();
    private static ArrayList<String>arr=new ArrayList<String>();
    public static String ConvertBase(String number,int base1,int base2)
    {
        return Integer.toString(Integer.parseInt(number, base1), base2);
    }

    public static int answer(String n,int b)
    {
       // System.out.println(n);
        arr.add(n);
        if(map.containsKey(n))
        {
            if(map.get(n)>=0)
            {
                int cnt=arr.size()-map.get(n);
                map.clear();
                arr.clear();
                return cnt;
            }

        }
        else
        {
            map.put(n,arr.size());
        }

        boolean isZero=false;
        for(int i=0;i<n.length();i++)
        {
            if(n.charAt(i)!='0')
            {
                isZero=true;
                break;
            }
        }
        if(isZero==false)
        {
            map.clear();
            arr.clear();
            return 1;
        }
        int z;
        ArrayList arrayList=new ArrayList();
        for(int i=0;i<n.length();i++)
        {
            arrayList.add(Integer.parseInt(n.charAt(i)+""));
        }
        Collections.sort(arrayList);
        String xx="";
        String yy="";
        for(int i=0;i<arrayList.size();i++)
        {
            xx+=arrayList.get(i);
        }
        for(int i=arrayList.size()-1;i>=0;i--)
        {
            yy+=arrayList.get(i);
        }

        String in10x=ConvertBase(xx,b,10);
        String in10y=ConvertBase(yy,b,10);
        z=Math.abs(Integer.parseInt(in10x)-Integer.parseInt(in10y));
        String zzs=String.format ("%0"+n.length()+"d", z);
        String rec;
        String cv=ConvertBase(zzs,10,b);
        rec=String.format ("%0"+n.length()+"d", Integer.parseInt(cv));

        return answer(rec,b);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String n;
        int b;
        n=scan.next();
        b=scan.nextInt();
        System.out.println(answer(n,b));
    }
}
