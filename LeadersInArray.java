/**
 * Created by i_amg on 11-10-2016.
 */
public class LeadersInArray
{
    public static void main(String[] args)
    {
        int[] arr = {98, 23, 54, 12, 20, 7, 27};
        int max  = Integer.MIN_VALUE;

        // May It is Best Approch Time Complexity = O(N);
        for(int i = arr.length - 1; i >=0 ; i--)
        {
            if(arr[i] >  max)
            {
                System.out.print(arr[i] + " ");
                max = arr[i];
            }
        }


        System.out.println();
        // Naive Approch O(N  * N) time Complaxity
        for(int i = 0; i < arr.length; i++)
        {
            boolean print = true;
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] <= arr[j])
                {
                    print = false;break;
                }
            }

            if(print)
            {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
