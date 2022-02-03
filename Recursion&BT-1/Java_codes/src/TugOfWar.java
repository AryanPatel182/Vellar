import java.util.*;
import java.io.*;

public class TugOfWar {
    public static int mdif = Integer.MAX_VALUE;
    public static String ans;
    public static void tugofwar(int[] arr, int idx, int lssum, int rssum, ArrayList<Integer> set1, ArrayList<Integer> set2)
    {
        if(idx >= arr.length)
        {            
            if(Math.abs(lssum-rssum) <= mdif) 
            {
                mdif = Math.abs(lssum-rssum);
                ans = lssum + " " + rssum;             
            }
            return;       
        }

        if(set1.size() < (arr.length+1)/2)
        {
            set1.add(arr[idx]);            
            tugofwar(arr, idx+1, lssum+arr[idx], rssum, set1, set2);
            set1.remove(set1.size()-1);
        }

        if(set2.size() < (arr.length+1)/2)
        {
            set2.add(arr[idx]);
            tugofwar(arr, idx+1, lssum, rssum+arr[idx], set1, set2);
            set2.remove(set2.size()-1);
        }
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();            
        }

        int lssum = 0;
        int rssum = 0;        
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();        
        tugofwar(arr,0,lssum,rssum,set1,set2);
        System.out.println(mdif);
        System.out.println(ans);
        scn.close();

    }
}
