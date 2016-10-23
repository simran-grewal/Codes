import java.util.Iterator;
/**
 * Created by i_amg on 23-10-2016.
 */
class Bag implements Iterable<Integer>
{
    class Node
    {
         int data;
         Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }

    }
    Node root, last;
    public Bag()
    {
        this.root = null;
        this.last = null;
    }
    public void enque(int data)
    {
        if(root == null)
        {
            root = new Node(data);
            last = root;
        }
        else
        {
            last.next = new Node(data);
            last = last.next;
        }
    }

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private Node curr = root;

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }

            @Override
            public Integer next()
            {
                int data = curr.data;
                curr = curr.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
            return it;
    }

    public int Size()
    {
        Node curr = root;
        int size = 0;
        while(curr!= null)
        {
            size++;
            curr = curr.next;
        }
        return size;
    }


}



class Graph
{
    int E;
    Bag[] adjList;
    public Graph(int v)
    {
        adjList = new Bag[v];

        for(int i = 0; i < v; i++)
        {
            adjList[i] = new Bag();
        }
    }

    void addEdge(int v, int w)
    {
        adjList[v].enque(w);
        adjList[w].enque(v);
        E += 1;
    }

    int noOfEdges()
    {
       return E;
    }

    public int[] GetList(int v)
    {
        Iterator iterator  =  adjList[v].iterator();
        int arr[] = new int[adjList[v].Size()];
        int i = 0;
        while(iterator.hasNext())
        {
            arr[i++] = (Integer)iterator.next();

        }


        return arr;
    }
}
public class UnDrictedGraph
{
    public static void main(String[] args)
    {
        Graph obj = new Graph(7);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(0, 3);
        obj.addEdge(1, 1);
        obj.addEdge(2, 4);
        obj.addEdge(3, 5);
        obj.addEdge(4, 6);
        obj.addEdge(5, 6);
        obj.addEdge(0, 6);
        int[] arr = obj.GetList(0);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }


    }
}
