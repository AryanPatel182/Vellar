import java.util.*;
import java.io.*;

public class CheckifArrayPairsareDivisiblebyK {
    public static boolean canArrange(int[] arr, int k) {

        
        int n = arr.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<n; i++)
        {

            int rem =  arr[i]%k;

            if(arr[i] < 0) 
            {                
                rem = (rem+ k)%k;
            }

            int put = hmap.getOrDefault(rem, 0);            
            hmap.put(rem, put+1);
            
        }

        System.out.println(hmap);
        
        for(Integer rem: hmap.keySet())
        {
            if(rem == 0 || (2*rem == k))
            {
                if(hmap.get(rem)%2 !=0)
                {
                    return false;
                }
            }
            else
            {
                if(hmap.get(rem) != hmap.getOrDefault(k-rem, 0))
                {
                    return false;
                }
            }
            
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        System.out.println(canArrange(arr, k));
        scn.close();

    }
}
