import java.util.*;
import java.io.*;

public class MedianOfTwoSortedArray {

    public static void findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int reqelts = (n+m+1)/2;
        int lo = 0;
        int hi = n-1;

        while(lo<=hi)
        {
            
            int ur = (lo+hi)/2 ;
            int ul = (ur-1) >=0 ? nums1[ur-1] : Integer.MIN_VALUE;
            int dr = reqelts - ur;
            int dl = (dr - 1) >= 0 ? nums2[dr-1] : Integer.MIN_VALUE;
            System.out.println("lo = " + lo + "    hi = " + hi  +  "    ur = " + ur) ;
            
            if(ul <= nums2[dr] && dl <= nums1[ur]) 
            {
                double avg = 0.0;
                if((n+m) % 2 == 0)
                {
                    System.out.println("Hreww");
                    System.out.println(Math.max(ul, dl));
                    System.out.println(Math.min(nums1[ur], nums2[dr]));
                    avg = (Math.max(ul, dl) + Math.min(nums1[ur] , nums2[dr])) / 2.0;
                }
                else
                {
                    avg = Math.max(ul,dl)/1.0;
                }
                System.out.println(avg);
                break;
            }
            else if(ul > nums2[dr])
            {
                hi = ur-1;
            }
            else if(dl > nums1[ur])
            {
                lo = ur+1;
            }
        }
        System.out.println("Hree");
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] nums1 = new int[n];        
        for(int i=0; i<n; i++)
        {
            nums1[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] nums2 = new int[m];
        for(int i=0; i<m; i++)
        {
            nums2[i] = scn.nextInt();
        }
        if(n<m )
        {
            findMedianSortedArrays(nums1, nums2);
        }
        else
        {
            findMedianSortedArrays(nums2, nums1);
        }
        scn.close();

    }
}
