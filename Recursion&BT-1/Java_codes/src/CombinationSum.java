import java.util.*;
import java.io.*;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void CShelper(int[] arr, int start, int n, int B, ArrayList<Integer> util)
    {
        if(B<0)
        {
            return;
        }
        if(B==0)
        {
            // Collections.sort(util);
            // System.out.println(util);
            ans.add( new ArrayList<>(util));        
            return;
        }
        for(int i=start; i<n; i++)
        {
            util.add(arr[i]);            
            CShelper(arr, i, n, B-arr[i], util);            
            util.remove(util.size()-1);
        }
        
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
        int B = scn.nextInt();        
        Arrays.sort(arr);
        ArrayList<Integer> util = new ArrayList<>();
        CShelper(arr, 0, n, B, util);
        System.out.println(ans);
        scn.close();

    }
}
