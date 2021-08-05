import java.util.*;
import java.io.*;

public class StreamOfCharacters {
    public static class Node
    {
        Node childs[] = new Node[26];
        boolean isEnd;
    }

    
    public static void insert(String word, Node curr)
    {
        for(int i=word.length()-1; i>=0; i--)
        {
            char ch = word.charAt(i);
            if(curr.childs[ch-'a'] == null)
            {
                curr.childs[ch-'a'] = new Node();
            }
            curr = curr.childs[ch-'a'];            
        }
        curr.isEnd = true;
    }

    private static final StringBuilder sb = new StringBuilder();
    public static boolean query(char letter, Node curr)
    {
        sb.append(letter);
        for(int i=sb.length()-1; i>=0; i--)
        {
            char ch = sb.charAt(i);

            curr = curr.childs[ch-'a'];
            if(curr == null)
            {
                return false;
            }
            else
            {
                if(curr.isEnd == true)
                {
                    return true;
                }                
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        String[] words = new String[n];

        Node root = new Node();
        for(int i=0; i<n; i++)
        {
            words[i] = scn.next();
            insert(words[i],root);
        }

        int k = scn.nextInt();

        for(int i=0; i<k; i++)
        {
            char ch = scn.next().charAt(0);
            
            System.out.println(query(ch,root));
        }
        
        scn.close();

    }
}
