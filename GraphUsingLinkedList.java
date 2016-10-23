import com.sun.glass.ui.Size;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i_amg on 23-10-2016.
 */
class Graph
{
    LinkedList<Integer>[] adjList;
    int V; //no  of virteces
    int E; //no of Edges
    Graph(int v)
    {
        this.V = v;
       this.adjList = new LinkedList[v];
        for(int i = 0;i < this.V; i++)
        {
            this.adjList[i] = new LinkedList<Integer>();

            this.E = 0;
        }
    }

    public void addEdge(int v, int w)
    {
        this.adjList[v].add(w);
        this.adjList[w].add(v);
        this.E++;
    }

    public int noOfVertices()
    {
        return this.V;
    }

    public int noOfEdges()
    {
        return E;
    }

    public int Size(int v)
    {
        return adjList[v].size();
    }
    public int[] GetList(int v)
    {
        Iterator iterator = adjList[v].iterator();

        int[] arr = new int[adjList[v].size()];
        int i = 0;
        while (iterator.hasNext())
        {
            arr[i++] = (Integer)iterator.next();
        }

        return arr;
    }

    public void DFS()
    {
        boolean[] Marked = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(Marked[i] == false)
            {
                dfs(Marked, i);
            }
        }

    }

    public void dfs(boolean[] marked, int v)
    {
        marked[v] = true;
        System.out.println(v);
        for(int w : adjList[v])
        {
            if(!marked[w])
                dfs(marked, w);
        }
    }

    public void DirectlyConnected(int v)
    {
        for(int i : adjList[v])
        {
            System.out.println(i);
        }
    }

    public void BST(int v)
    {
        boolean[] Marked = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        Marked[v] = true;
        while (!queue.isEmpty())
        {
            int s = queue.poll();
            System.out.println(s);

            Iterator<Integer> iterator = adjList[s].iterator();
            while (iterator.hasNext())
            {
                int value = iterator.next();

                if(!Marked[value])
                {
                    Marked[value] = true;
                    queue.add(value);
                }
            }
        }
    }
}
public class GraphUsingLinkedList
{
    public static void main(String[] args)
    {
        Graph obj = new Graph(6);
       // obj.addEdge(6, 1);
       // obj.addEdge(1, 3);
        obj.addEdge(4, 5);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);
        obj.addEdge(3, 3);

        int[] arr = obj.GetList(1);
       /*
        for(int i : arr)
        {
            System.out.println(i);
        }*/


       // obj.DFS();

       // obj.DfS();
        //obj.DirectlyConnected(17);
        obj.BST(2);
    }
}
