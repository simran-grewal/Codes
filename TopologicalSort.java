import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by i_amg on 22-11-2016.
 */
class Graph
{
    LinkedList<Integer>[] adjList;
    int V, E;

    Graph(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i = 0; i < V; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }

        this.E = 0;
    }

    public void add_Edge(int v, int w)
    {
        this.adjList[v].add(w);
       // this.adjList[w].add(v);
        this.E++;

    }

    public void dfs(int i)
    {
        boolean[] Visited = new boolean[this.V];
        dfs(Visited, i);
    }

    public void dfs(boolean[] Visited, int i)
    {
        Visited[i] = true;
        System.out.println(i);
        for(int w : adjList[i])
        {
            if(!Visited[w])
            {
                dfs(Visited, w);
            }
        }
    }

    public void BSF(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        boolean[] Visited = new boolean[this.V];

        Visited[v] = true;

        while (!queue.isEmpty())
        {
            int value = queue.poll();
            System.out.println(value);

            for(int w : adjList[value])
            {
                if(!Visited[w])
                {
                    Visited[w] = true;
                    queue.add(w);
                }

            }
        }
    }

    public void PRINT(int i)
    {
        for(int w : adjList[i])
        {
            System.out.println(w);
        }
    }
    Stack<Integer> stack = new Stack<Integer>();
    public void Sort()
    {

        boolean[] Visited = new boolean[this.V];
        for(int i = 0; i < this.V; i++)
        {
            if(!Visited[i])
            {
                dfs1(Visited, i);
            }
        }

        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    public void dfs1(boolean[] Visited, int  i)
    {
        Visited[i] = true;
        for(int w : adjList[i])
        {
            if(!Visited[w])
            {
                dfs1(Visited, w);
            }
        }

        stack.push(i);
    }
}
public class GoWithGraph
{


    public static void main(String[] args) {



        Graph obj = new Graph(7);
        obj.add_Edge(0, 1);
        obj.add_Edge(0, 2);
        obj.add_Edge(0, 5);
        obj.add_Edge(1, 4);
        obj.add_Edge(3, 2);
        obj.add_Edge(3, 4);
        obj.add_Edge(3, 5);
        obj.add_Edge(3, 6);
        obj.add_Edge(6, 0);
        obj.add_Edge(6, 4);
        obj.add_Edge(5, 2);
       // obj.BSF(0);
       // obj.dfs(0);
        obj.Sort();
    }




}
