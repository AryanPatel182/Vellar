import java.util.*;
import java.io.*;

public class LongestWordInDictionary {
    public static class Node
    {
        Node[] childs = new Node[26];
        String str;
    }

    public static void insert(Node curr,String word)
    {
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.childs[ch-'a'] == null)
            {
                curr.childs[ch-'a'] = new Node();
            }

            curr = curr.childs[ch-'a'];
        }
        curr.str= word;
    }

    public static void dfs(Node curr)
    {
        for(Node child:curr.childs)
        {
            if(child!=null && child.str!=null)
            {
                if(child.str.length() > ans.length())
                {
                    ans = child.str;
                }
                dfs(child);
            }
        }
    }

    static String ans = "";
    public static String longestWord(String[] words)
    {
        Node root = new Node();

        for(String word:words)
        {
            insert(root, word);
        }

        dfs(root);
        
        return ans;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++)
        {
            words[i] = scn.next();
        }        
        System.out.println(longestWord(words));
        scn.close();

    }
}
