/**
 * Created by i_amg on 22-11-2016.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ritesh
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

    public int V()
    {
        return this.V;
    }
    public void addEdge(int v, int w)
    {
        this.adjList[v].add(w);
        this.adjList[w].add(v);
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
}

public class FindCycle {

    Graph g;
    boolean[] marked;
    boolean hasCycle = false;
    //private Stack<Integer> cycle;
    private final int[] edgeTo;

    public FindCycle(Graph g) {
        this.g = g;
        //check self look and parallel edges as well here
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            dfs(g, i, -1);
        }
    }

    private void dfs(Graph g, int s, int parent) {
        marked[s] = true;
        //System.out.println(s);
        for (int v : g.adjList[s]) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(g, v, s);
            } else if (parent > 0 && v != parent) {
                System.out.println("cycle found");
                hasCycle = true;
                //cycle = new Stack<Integer>();
                for (int x = s; x != v; x = edgeTo[x]) {
                    System.out.print(x + "-");
                }
                System.out.print(v + "-");
                System.out.println(s);

                //cycle.push(v);
                //cycle.push(s);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 6);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        FindCycle f = new FindCycle(g);
        System.out.println(f.hasCycle);
    }

}
