/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.graphs.undirected;

/**
 *
 * @author Ritesh
 */
public class Bipartite {

    private final boolean[] marked;
    private boolean bipartite = true;
    private final Color[] color;

    public Bipartite(Graph g) {
        marked = new boolean[g.V()];
        color = new Color[g.V()];
        color[0] = Color.RED;
        dfs(g, 0);
    }

    private void dfs(Graph g, int i) {
        marked[i] = true;
        for (int v : g.adj(i)) {
            if (!marked[v]) {
                color[v] = color[i] == Color.RED ? Color.WHITE : Color.RED;
                dfs(g, v);
            } else {
                if (color[v] == color[i]) {
                    bipartite = false;
                }
            }
        }
    }

    public boolean isBipartite() {
        for (boolean b : marked) {
            if (!b) {
                System.out.println("not connected");
                return false;
            }
        }
        return bipartite;
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
        //g.addEdge(7, 8);
        Bipartite b = new Bipartite(g);
        System.out.println("result : " + b.isBipartite());
        for (int i = 0; i < 7; i++) {
            System.out.println(b.color[i]);
        }
    }

    private static enum Color {

        RED,
        WHITE;
    }
}
