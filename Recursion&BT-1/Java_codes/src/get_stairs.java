// import java.util.*;
// import java.io.*;


// public class get_stairs {
//     public static void main(String[] args) throws Exception {
//         File input = new File("input.txt"); // declare input
//         File output = new File("output.txt");
//         Scanner scn = new Scanner(input); // declare scanner
//         PrintStream stream = new PrintStream(output);
//         System.setOut(stream);
        
//         int n = scn.nextInt();
//         scn.close();       
//         int[] dp = new int[n+1];
//         dp[1]=1;
        
//         for(int i=2;i<n+1;i++)
//         {
//             dp[i] = 2*dp[i-1] + 1;
//         }
//         System.out.println(dp[n]);
//     }
// }




// -------------------------------------------------------------------------------------------
//  printing path



import java.util.*;
import java.io.*;

public class get_stairs {

    public static ArrayList<String> stairs(int n)
    {
        if(n==0)
        {
            ArrayList<String> temp  = new ArrayList<>();
            temp.add("");
            return temp;
        }else if(n<0)
        {
            ArrayList<String> temp = new ArrayList<>();            
            return temp;
        }

        ArrayList<String> str1 = stairs(n - 1);
        ArrayList<String> str2 = stairs(n - 2);
        ArrayList<String> str3 = stairs(n - 3);

        ArrayList<String> mres = new ArrayList<>();
        for(String str:str1)
        {
            mres.add(1 + str);
        }
        for(String str:str2)
        {
            mres.add(2 + str);
        }
        for(String str:str3)
        {
            mres.add(3 + str);
        }
        return mres;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        scn.close();
        ArrayList<String> ans = stairs(n);
        System.out.println(ans);
    }
}