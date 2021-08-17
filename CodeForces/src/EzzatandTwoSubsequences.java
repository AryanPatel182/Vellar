import java.util.*;
public class EzzatandTwoSubsequences {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();

        while(t-- > 0)
        {
            int n = scn.nextInt();
            int[] arr =new int[n];
            double sum = 0;
            double max=  Integer.MIN_VALUE;            

            for(int i=0; i<n; i++)
            {
                arr[i] = scn.nextInt();
                sum += arr[i];
                max= Math.max(max, arr[i]);
            }            

            double fa = max;
            double fb = (sum - max)/(n-1);
            
            System.out.println(String.format("%.9f" , fa+fb));
    
            
           
        }

    }
}