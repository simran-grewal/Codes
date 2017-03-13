import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by i_amg on 14-03-2017.
 */
public class LongestSubsetWithConsecutiveNumbers
{
    public static int LSCN(int[] arr){

        HashSet<Integer>  hashSet = new HashSet<Integer>();
        int lengthOfLSCN = 0;
        for(int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }

        for(int value : hashSet){

            if(!hashSet.contains(value - 1)){

                int temp  =  value;
                while (hashSet.contains(temp)){
                    temp++;
                }

                if(lengthOfLSCN < (temp - value)){
                    lengthOfLSCN = temp - value;
                }
            }
        }

        return lengthOfLSCN;
    }
    public static void main(String[] args) {

        int[] arr = {1, 3, 8, 14, 4, 10, 2, 11, 12};

        System.out.println(LSCN(arr));
    }
}
