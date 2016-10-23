/**
 * Created by i_amg on 23-10-2016.
 */

class NoOfClustor
{
    int[] OfSet = {-1, 0, 1};

    boolean NeighBourExist(int[][] Matrix, int i, int j)
    {
        if(i >=0 && i < Matrix.length && j >= 0 && j < Matrix[0].length)
        {
            if(Matrix[i][j] == 1)
            {
                return true;
            }
        }

        return false;
    }
    void ApplyLogic(int[][] Matrix, boolean[][] Visited, int i, int j)
    {
        if(Visited[i][j])
        {
            return;
        }

        Visited[i][j] = true;
        int XOfSet, YOfSet;
        for(int x = 0; x < OfSet.length; x++)
        {
            XOfSet = OfSet[x];

            for(int y = 0; y < OfSet.length; y++)
            {
                YOfSet = OfSet[y];

                if(XOfSet == 0 && YOfSet == 0)
                {
                    continue;
                }

                if(NeighBourExist(Matrix, i + XOfSet, j + YOfSet))
                {
                    ApplyLogic(Matrix,Visited, i + XOfSet, j + YOfSet);
                }
            }
        }
    }
    void FindNoOfClustor(int[][] Matrix)
    {
        boolean[][] Visited = new boolean[Matrix.length][Matrix[0].length];
        int Count = 0;
        for(int i = 0; i < Matrix.length; i++)
        {
            for(int j = 0; j < Matrix[0].length; j++)
            {
                if(!Visited[i][j] && Matrix[i][j] == 1)
                {
                    Count++;
                    ApplyLogic(Matrix, Visited, i, j);
                }
            }
        }


        System.out.println(Count);
    }



}
public class Cluster
{
    public static void main(String[] args)
    {
        int[][] Matrix = {
                            {1, 0, 1, 0, 1},
                            {1, 1, 0, 0, 0},
                            {0, 1, 0, 1, 1},

                         };


        NoOfClustor obj = new NoOfClustor();
        obj.FindNoOfClustor(Matrix);
    }
}
