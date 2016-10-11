/**
 * Created by i_amg on 11-10-2016.
 */

public class Anagram
{
    public static boolean IsAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] count = new int[256];
        for (char i : s1.toCharArray())
        {
            count[i]++;
        }

        for(char i : s2.toCharArray())
        {
            count[i]--;
        }
        int j = 0;
        for(int i : count)
        {
            if(i != 0) return false;

        }


        return true;
    }
    public static void main(String[] args)
    {
        String s1 = "sim";
        String s2 = "sim";
        if(IsAnagram(s1, s2))
        {
            System.out.println("Yes");
        }
    }
}
