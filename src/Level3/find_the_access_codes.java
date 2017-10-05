package Level3;

/**
 * Created by abdullah on 8/14/17.
 */
public class find_the_access_codes
{
    static int cnt=0;
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            /*
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            */

            if(data[1]%data[0]==0&&data[2]%data[1]==0&&data[2]>data[1]&&data[1]>data[0])
            {
                cnt++;
            }
            return;

        }
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }


    static void printCombination(int arr[], int n, int r)
    {

        int data[]=new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
    public static int answer(int[] l) {
        int r = 3;
        int n = l.length;
        cnt=0;
        if(n<3)return 0;
        if(n>3)
        {
            printCombination(l, n, r);
        }
        else
        {
            if(l[1]%l[0]==0&&l[2]%l[1]==0&&l[2]>=l[1]&&l[1]>=l[0])
            {
                cnt++;
            }
        }

        return cnt;
        // Your code goes here.

    }
    public static void main(String[] args) {
        //int [] l={1,2,3,4,5,6};
        int [] l=new int[2010];
        for(int i=1;i<=2000;i++)
        {
            System.out.println(i);
            l[i-1]=i;
        }
        System.out.println(answer(l));
    }
}
