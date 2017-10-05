package Level2;

import java.util.*;

/**
 * Created by abdullah on 8/10/17.
 */
public class dont_get_volunteered
{
    private static int[][] arr=new int[10][8];
    private static Map<Integer, ArrayList> maps=new HashMap<Integer, ArrayList>();


    //  Utility method returns true if (x, y) lies inside Board
    static boolean isInside(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }
    //  Method returns minimum step to reach target position
    static int minStepToReachTarget(int src, int dest, int N)
    {
        //  x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        int srci,srcj,desti,destj;

        srci=(Integer) maps.get(src).get(0);
        srcj=(Integer) maps.get(src).get(1);
        desti=(Integer)maps.get(dest).get(0);
        destj=(Integer)maps.get(dest).get(1);
        //  queue for storing states of knight in board
        Queue<ArrayList> q= new LinkedList<>();

        //  push starting position of knight with 0 distance
        ArrayList temp2=new ArrayList();
        temp2.add(srci);
        temp2.add(srcj);
        temp2.add(0);
        q.add(temp2);
       // q.add(new Pair<>(srci,new Pair<Integer, Integer>(srcj,0)));
        //q.add(new cell(srci,srcj,0));

        ArrayList t;
        int x, y;
        boolean visit[][]=new boolean[N+1][N+1];

        //  make all cell unvisited
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        //  visit starting state
        visit[srci][srcj] = true;

        //  loop untill we have one element in queue
        while (!q.isEmpty())
        {
            t = q.peek();
            int tx,ty,tdis;
            q.remove();

            tx=(Integer)t.get(0);
            ty=(Integer) t.get(1);
            tdis=(Integer)t.get(2);

            visit[tx][ty] = true;

            // if current cell is equal to target cell,
            // return its distance
            if (tx == desti && ty == destj)
                return tdis;


            //  loop for all reahable states
            for (int i = 0; i < 8; i++)
            {
                x = tx + dx[i];
                y = ty + dy[i];

                // If rechable state is not yet visited and
                // inside board, push that state into queue
                if (x == desti && y == destj)
                    return tdis+1;
                if (isInside(x, y, N) && !visit[x][y])
                {
                    ArrayList temp22=new ArrayList();
                    temp22.add(x);
                    temp22.add(y);
                    temp22.add(tdis+1);
                    q.add(temp22);

                    //q.add(new Pair<>(x,new Pair<Integer, Integer>(y,tdis+1)));
                    //q.add(new cell(x,y,t.dis+1));
                }



            }
        }
        return 0;
    }
    public static int answer(int src,int dest)
    {

        maps.clear();
        int cnt=0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                arr[i][j]=cnt++;
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                ArrayList arrayList=new ArrayList();
                arrayList.add(i);
                arrayList.add(j);

                maps.put(arr[i][j],arrayList);



            }
        }

        return  minStepToReachTarget(src,dest,8);
    }
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int src,dest;
        src=scan.nextInt();
        dest=scan.nextInt();
        System.out.println(answer(src,dest));

    }
}
