
import java.security.Key;
import java.util.*;
import java.util.zip.CheckedInputStream;

/**
 * Date 01/29/2016
 * @author Tushar Roy
 *
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */
public class StringPermutation {

    public void permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<Character, Integer>();
        /*for (char ch : input) {
            //countMap.compute(ch, (key, val) -> {if (val == null) {return 1;} else {return val + 1;}});

        }*/
        /*
        countMap.put('A', 5);
        countMap.put('B', 1);
        countMap.put('C', 1);
            */
        for(int i = 0; i < input.length; i++)
        {
            if(countMap.get(input[i]) == null)
            {
                countMap.put(input[i], 1);
            }
            else
            {
                int prevFreq = countMap.get(input[i]);
                countMap.put(input[i], prevFreq + 1);
            }
        }

        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        /*
        Iterator<Map.Entry<Character, Integer>> iterator = countMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Character, Integer> map = iterator.next();
            str[index] = map.getKey();
            count[index] = map.getValue();
            index++;
        }
        */
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0);

    }

    public void permuteUtil(char str[], int count[], char result[], int level) {
        if (level == result.length) {
            printArray(result);
            return;
        }
        //System.out.println("Simran");
        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;

            permuteUtil(str, count, result, level + 1);
            count[i]++;
            //System.out.println(i);
        }



    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
       // sp.permute("ABC".toCharArray());
        Scanner s = new Scanner(System.in);
        String str = s.next();
        sp.permute(str.toCharArray());
    }
}