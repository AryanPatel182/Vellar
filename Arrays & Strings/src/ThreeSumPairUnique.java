import java.util.*;
import java.io.*;

public class ThreeSumPairUnique {

    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr , int si , int ei , int target) 
    {   
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(si<ei)
        {
            int sum = arr[si] + arr[ei];

            if(sum == target)
            {
                if(si!=0 && arr[si] == arr[si-1])
                {
                    si++;
                    ei--;
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[si]);
                    temp.add(arr[ei]);
                    ans.add(temp);
                    si++;
                    ei--;
                }
            }else if(sum < target)
            {
                si++;
            }else{
                ei--;
            }

        }

        return ans;
                
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n ; i++)
        {
            arr[i] =  scn.nextInt();
        }
        Arrays.sort(arr);
        int target = scn.nextInt();
        scn.close();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i <= n-3 ; i++)
        {
            int val = arr[i];
            ArrayList<ArrayList<Integer>> pans = twoSum(arr, i+1 , n-1 , target-val);

            if(i!=0 && val!= arr[i-1])
            {
                for(ArrayList<Integer> lst : pans)
                {                    
                    lst.add(val);
                    ans.add(lst);
                }
            }
        }        

        for(ArrayList<Integer> vals : ans)
        {
            System.out.println(vals);
        }
        

    }
}
