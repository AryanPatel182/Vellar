import java.util.*;
import java.io.*;

public class maze_paths_jumps {

    public static ArrayList<String> maze_jumps(int sr, int sc, int er, int ec) 
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();
        ArrayList<String> str3 = new ArrayList<>();
        ArrayList<String> mans = new ArrayList<>();

        for(int h=1 ; h <= ec-sc ; h++)
        {
            str1 = maze_jumps(sr, sc+h, er, ec);
            for (String str : str1) {
                mans.add("h"+ h + str);
            }
        }
        for (int d = 1; d <= er-sr && d<=ec-sc; d++) 
        {
            str2 = maze_jumps(sr + d, sc + d, er, ec);
            for (String str : str2) {
                mans.add("d" + d +str);
            }
        }
        for (int v = 1; v <= er-sr ; v++) 
        {
            str3 = maze_jumps(sr + v, sc, er, ec);
            for (String str : str3) {
                mans.add("v"+ v + str);
            }
        }
    
        return mans;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        ArrayList<String> ans = maze_jumps(0,0,n-1,n-1);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }
        scn.close();
    }   
}
