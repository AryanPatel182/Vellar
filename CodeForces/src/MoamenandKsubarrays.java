import java.util.*;

public class MoamenandKsubarrays {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();

        while(t-- > 0)
        {
            int n =scn.nextInt();
            int k = scn.nextInt();
            int[] arr= new int[n];
            int[] srr = new int[n];
            HashMap<Integer, Integer> hmap = new HashMap<>();
            for(int i=0; i<n; i++)
            {
                arr[i] = scn.nextInt();
                srr[i] = arr[i];
            }

            Arrays.sort(srr);
            for(int i=0; i<n; i++)
            {
                hmap.put(srr[i], i);
            }

            int chunks = 1;
            for(int i=1;i<n; i++)
            {                   
                if(arr[i] > arr[i-1]  && hmap.get(arr[i])== hmap.get(arr[i-1])+1)
                {
                    continue;
                }
                else
                {
                    chunks+=1;
                }
            }

            if(chunks<= k)
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }

    }
}