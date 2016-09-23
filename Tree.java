/**
 * Created by i_amg on 14-09-2016.
 */
class Node
{
   private int key;
   private Node right;
   private Node left;

    public Node(int data)
    {
        this.key = data;
        this.left = null;
        this.right = nulll;
    }
    int data()
    {
        return this.key;
    }
    Node right()
    {
        return this.right;
    }

    Node left()
    {
        return this.left;
    }

    void setLeft(Node left)
    {
        this.left = left;
    }
    void setRight(Node right)
    {
        this.right = right;
    }
    void setData(int data)
    {
        key = data;
    }

}
class Bst
{
    Node root = null;

    void Insert(int data)
    {
       root = Insert(root, data);
    }

    Node Insert(Node root, int data)
    {
        if(root == null)
        {
             root =  new Node(data);
        }

        else
            if(data < root.data())
            {
               root.setLeft(Insert(root.left(), data));
            }
        else
                root.setRight(Insert(root.right(), data));


        return root;

    }

    void printleft()
    {
        Node curr = root;
        printleft(curr);
    }
    int printleft(Node curr)
    {
        if(curr == null) return -1;
        System.out.println(curr.data());
        printleft(curr.left());

        return -1;

    }

    void printright()
    {
        Node curr = root;
        printright(curr);
    }

    int printright(Node curr)
    {
        if(curr == null) return -1;
        System.out.println(curr.data());
        printright(curr.right());

        return -1;
    }

    int Getminimum()
    {
        Node curr = root;
        return Getminimum(curr);
    }

    int Getmaximum()
    {
        Node curr = root;
        return Getmaximum(curr);
    }
    int Getminimum(Node root)
    {
        if(root == null)
            return -1;
        if(root.left() == null)
            return root.data();
       return Getminimum(root.left());
    }

    int Getmaximum(Node root)
    {
        if(root == null)
            return -1;
        if(root.right() == null)
            return root.data();
        return Getmaximum(root.right());
    }

    boolean Search(int data)
    {
        Node curr = root;
       return Search(curr, data);
    }

    boolean Search(Node root, int data)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data() == data)
        {
            return true;
        }
        if(root.data() > data)
        {
            return Search(root.left(), data);
        }
        else
        {
            return Search(root.right(), data);
        }
    }

    void DeleteMinimum() {
        Node curr = root;
        if (curr != null) {
            DeleteMinimum(root);

        }
    }
     Node DeleteMinimum(Node root)
     {
        if(root.left() == null)
            return root.right();

         root.setLeft(DeleteMinimum(root.left()));

         return root;
     }

    void DeleteMaximum()
    {
        Node curr = root;
        if(curr != null)
        {
            DeleteMaximum(curr);
        }
    }

    Node DeleteMaximum(Node root)
    {
        if(root.right() == null)
        {
            return root.left();
        }

        root.setRight(DeleteMaximum(root.right()));
        return root;
    }

    void Delete(int data)
    {
        Node curr = root;
        if(curr != null )
        {
            Delete(curr, data);
        }
    }
    Node FindMin(Node root)
    {
        if(root.left() == null)
            return root;
       return FindMin(root.left());
    }
    Node Delete(Node root, int data) {
        if (root == null) return root;
       else if (data > root.data())
        {
            root.setRight(Delete(root.right(),data));
        }

        else if(data < root.data())
        {
            root.setLeft(Delete(root.left(), data));
        }

        else// ....FOUND.....
        {
            if(root.left() == null && root.right() == null)
            {

                root = null;
                return  root;
            }

            else
                if(root.left() == null)
                {
                    return root.right();
                }

            else
                 if(root.right() == null)
                 {
                     return root.left();
                 }
            else
                 {
                     Node temp = FindMin(root.right());
                     //System.out.println(temp.data());
                     root.setData(temp.data());

                     //root.setRight(DeleteMinimum(root.right()));
                     root.setRight(Delete(root.right(), temp.data()));
                 }

        }

        return root;

    }


    void Inorder()
    {
        Inorder(root);
    }
    void Inorder(Node root)
    {
        if(root == null)
            return;
            Inorder(root.left());
            System.out.println(root.data()+" ");
            Inorder(root.right());

    }
    void PreOrder()
    {
        PreOrder(root);
    }
    void PreOrder(Node root)
    {
        if(root == null)return;
        System.out.println(root.data());
        PreOrder(root.left());
        PreOrder(root.right());
    }

    void PostOrder()
    {
        PostOrder(root);
    }
    void  PostOrder(Node root)
    {
        if(root == null) return;

        PostOrder(root.left());
        PostOrder(root.right());
        System.out.println(root.data());

    }
    void Count()
    {
        System.out.println(Count(root));
    }

    int Count(Node root)
    {

        if(root == null) return 0;

        return (Count(root.left()) + Count(root.right()) + 1);
    }
    void Height()
    {
        System.out.println(Height(root));
    }
    int Height(Node root) {
        if (root == null) return 0;
        int leftHeight = Height(root.left());
        int rightHeight = Height(root.right());

        if (leftHeight > rightHeight)
        {
            return leftHeight + 1;
        }
        else
        {
            return  rightHeight + 1;
        }
    }
}
public class Tree
{
    public static void main(String[] args)
    {


        Bst obj = new Bst();
        obj.Insert(15);
        obj.Insert(10);
        obj.Insert(25);
        obj.Insert(12);
        obj.Insert(8);
        obj.Insert(20);
        obj.Insert(30);
        obj.Insert(35);
        obj.Insert(40);
        obj.Insert(34);
        System.out.println("INSERTED.................");
        //obj.printleft();
        //obj.printright();

        //System.out.println("Minimum = " + obj.Getminimum());

        //System.out.println("Minimum = " + obj.Getmaximum());

       // obj.Delete(15);
        if(obj.Search(15) == true)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

        //obj.printright();
       // obj.printleft();
       // obj.DeleteMinimum();
       // obj.DeleteMaximum();

        //obj.Inorder();
        //obj.PreOrder();
       // obj.PostOrder();
        //obj.Count();
         // obj.Height();



    }

}
