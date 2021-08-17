import java.util.*;

public class AquaMoonandStrangeSort {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scn.nextInt();
        while(t-- >0)
        {
            int n = scn.nextInt();
            String ans = "YES";
            int[] arr = new int[n];
            int[] ofreq = new int[(int) 10e5];
            int[] efreq = new int[(int) 10e5];
            
            for(int i= 0; i<n; i++)
            {
                arr[i] = scn.nextInt();
                if(i%2 == 0)
                {
                    efreq[arr[i]]+=1;
                }
                else
                {
                    ofreq[arr[i]]+=1;
                }   
            }

            Arrays.sort(arr);

            for(int i=0; i<n; i++)
            {
                if(i%2 == 0)
                {
                    efreq[arr[i]]-=1;
                }
                else
                {
                    ofreq[arr[i]]-=1;
                }
            }

            for(int i=0; i<n; i++)
            {
                if(ofreq[arr[i]]==0 && efreq[arr[i]]==0)
                {
                    
                }
                else
                {
                    ans = "NO";
                }
                
            }


            System.out.println(ans);
            

            
        }

    }
}