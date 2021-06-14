import java.util.*;
import java.io.*;

public class maze_paths {


    public static ArrayList<String> maze(int[] arr, int sr,int sc, int er, int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");  
            return temp;
        }              
      
        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();

        if(sc<ec)
            str1 = maze(arr, sr, sc+1, er, ec);
        if(sr<er)        
            str2 = maze(arr, sr+1, sc, er, ec);
        
            ArrayList<String> mans = new ArrayList<>();

        for(String str:str1)
        {
            mans.add("h" + str);
        }       
        for(String str:str2)
        {
            mans.add("v" + str);            
        }       
        return mans;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int  n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i= 0;i<n;i++)    
        {
            for(int j=0;j<n;j++)
            {                
                arr[i] = 0;
            }
        }
        scn.close();
        ArrayList<String> ans = maze(arr,0,0,n-1,n-1);
        // System.out.println(ans);

        for (int i = 0; i < ans.size(); i++)
        {
            System.out.println(ans.get(i));
        }
        
    }
}
