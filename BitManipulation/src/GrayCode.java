import java.util.*;
import java.io.*;

public class GrayCode {

    public static ArrayList<String> Graycode(int n) 
    {
        if(n==1)
        {
            ArrayList<String> bans = new ArrayList<>();
            bans.add("0");
            bans.add("1");
            return bans;
        }
        ArrayList<String> rres = Graycode(n-1);

        ArrayList<String> mans  =new ArrayList<>();

        for(int i = 0 ; i<rres.size(); i++)
        {
            mans.add('0' + rres.get(i));
        }
        for(int i = rres.size()-1 ; i>=0 ; i--)
        {
            mans.add('1' + rres.get(i));
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

        ArrayList<String> ans = Graycode(n);

        for(String s: ans)
        {
            System.out.println(s);
        }
        scn.close();

    }
}
