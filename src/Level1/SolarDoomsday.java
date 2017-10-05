package Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abdullah on 8/6/17.
 */
public class SolarDoomsday
{
    static List<Integer> nums=new ArrayList<Integer>();
    public static int[] answer(int area) {

        // Your code goes here.
        Integer cur=area;
        Integer remain=0;
        if(area==0)
        {
            int size = nums.size();
            int[] result = new int[size];
            Integer[] temp = nums.toArray(new Integer[size]);
            for (int n = 0; n < size; ++n) {
                result[n] = temp[n];
            }
            nums.clear();
            return result;
        }
        while(true)
        {
            if(cur==0)break;

            Double temp=Math.sqrt(cur);
            if(temp.intValue()*temp.intValue()==cur)
            {
                nums.add(cur);
                cur=0;
            }
            if(cur==0)break;
            cur--;
            remain++;
        }
        return answer(remain);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Integer num=scan.nextInt();
        int arr[]=answer(num);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
