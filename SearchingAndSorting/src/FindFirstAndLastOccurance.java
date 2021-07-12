import java.util.*;
import java.io.*;

public class FindFirstAndLastOccurance {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();    
        scn.close();

        int[] ans = {-1,-1};
        int lo = 0;
        int hi = n-1;

        while(lo<=hi)
        {
            int mid = (lo + hi)/2;
                        
            if(arr[mid] == target)
            {
                ans[0] = mid;
                hi = mid-1;
            }
            else if(arr[mid]>target)
            {
                hi = mid-1;
            }
            else if(arr[mid]<target){
                lo = mid+1;
            }
        }

        lo = 0;
        hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // System.out.println(mid);
            if (arr[mid] == target) {
                ans[1] = mid;
                lo = mid + 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            }
            else if(arr[mid] > target){
                hi = mid-1;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
