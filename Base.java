/**
 * Created by i_amg on 10-10-2016.
 */
class TrieNode
{
    Integer value;
    TrieNode[] nodes = new TrieNode[26];
}
class Trie
{
    TrieNode root;
    public Trie()
    {
        root = new TrieNode();
    }

    void Insert(String w, Integer value)
    {
        TrieNode curr = root;
        if(w == null || value == null ||  w.length() == 0)
        {
            System.out.println("Incorrect Input");
            return;
        }

        for(int i = 0; i < w.length(); i++)
        {
            int index = w.charAt(i) - 'a';
            if(curr.nodes[index] == null)
            {
                curr.nodes[index] = new TrieNode();
            }

            curr = curr.nodes[index];
        }

        curr.value = value;

    }

    public int  Search(String w)
    {
        TrieNode curr = root;
        if(w == null || w.length() == 0)
        {
            System.out.println("Not correct Input");  return -1;
        }

        for(int i = 0; i < w.length() && curr != null; i++)
        {
            int index = w.charAt(i) - 'a';
            curr = curr.nodes[index];
        }

        if(curr != null)
        {
            if(curr.value != null)
            {
                return curr.value;
            }

            else
            {
                System.out.println("Not found");
                return -1;
            }
        }

        else
        {
            System.out.println("Not found");
            return -1;
        }
    }

    public String LongestMatchedSubstring(String w)
    {
        TrieNode curr = root;
        if(w == null || w.length() == 0)
        {
            System.out.println("Incorrect Input");
            return "";
        }

        String currMatched = "";
        String LongestMatched = "";

        for(int i = 0; i < w.length() && curr != null; i++)
        {
            int index = w.charAt(i) - 'a';
            curr = curr.nodes[index];
            if(curr != null)
            {
                currMatched += w.charAt(i);

                if(curr.value != null)
                {
                    LongestMatched = currMatched;
                }
            }
            //curr = curr.nodes[index];

        }

        return LongestMatched;
    }

    public void Delete(String w)
    {
        if(w == null || w.length() == 0 || root == null)
        {
            System.out.println("Deletion Not possible");
            return;
        }

        deleteHelper(w, root, w.length(), 0);
        return;
    }

    private boolean hasNoChild(TrieNode curr)
    {
        for(int i = 0; i < curr.nodes.length; i++)
        {
            if(curr.nodes[i] != null)
                return false;
        }

        return true;
    }
    private boolean deleteHelper(String w, TrieNode curr, int lenght, int level)
    {
        boolean deletedSelf = false;
        if (curr == null)
        {
            System.out.println("Key does not exist");
            return deletedSelf;
        }
        if(level == lenght)
        {
            if(hasNoChild(curr))
            {
                curr = null;
                deletedSelf = true;
            }
            else
            {
                curr.value = null;
                deletedSelf = false;
            }
        }

        else
        {
            TrieNode childNode = curr.nodes[w.charAt(level) - 'a'];
            boolean childDeleted = deleteHelper(w, childNode, lenght, level + 1);
            if(childDeleted)
            {
                //index = w.charAt(level) - 'a';
                curr.nodes[w.charAt(level) - 'a'] = null;

                if(curr.value != null)
                {
                    deletedSelf = false;
                }

                else if(!hasNoChild(curr))
                {
                    deletedSelf = false;
                }

                else
                {
                    curr = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }

        return deletedSelf;

    }

    void countWord()
    {
        countWord(root);
    }

    void countWord(TrieNode curr)
    {

    }
}
public class Base
{
    public static void main(String[] args)
    {
        Trie obj = new Trie();
        obj.Insert("abb", 13);
        obj.Insert("abc",44);
        obj.Insert("manjit", 34);
        obj.countWord();
        /*
        int value = obj.Search("abc");
        System.out.println(value);

     // String str =   obj.LongestMatchedSubstring("manjit");
      //  System.out.println(str);

         obj.Delete("abb");
         value = obj.Search("abc");
        System.out.println(value);
        */
    }
}
