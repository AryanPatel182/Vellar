import java.util.*;
import java.io.*;

public class ConcatenatedWords {    

    public static class Node{
        Node[] childs = new Node[26];
        String str;
    
    }
    
    public static void insert(Node curr, String s)
    {
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(curr.childs[ch-'a'] == null)
            {
                curr.childs[ch-'a'] = new Node();
            }
            curr = curr.childs[ch-'a'];
        }
        curr.str = s;
    }

    public static void search(Node curr, Node nword)
    {
        if(curr.str!= null && nword.str!= null)
        {
            // System.out.println(curr.str);
            ans.add(curr.str);
        }
        if(nword.str != null)
        {
            search(curr, root);
        }

        for(int i=0; i<26; i++)
        {
            if(curr.childs[i]!= null && nword.childs[i]!=null)
            {
                search(curr.childs[i], nword.childs[i]);
            }                        
        }
    }

    public static void search1(Node curr)
    {
        if(curr.str != null)
        {
            search(curr, root);
        }

        for(Node child : curr.childs)
        {
            if(child!=null)
            {
                search1(child);
            }
        }
    }
    
    public static Node root;
    public static HashSet<String> ans = new HashSet<>();
    public static List<String> findAllConcatenatedWordsInDict(String[] words)
    {
        root = new Node();

        for(String s:words)
        {
            insert(root,s);
        }

        search1(root);

        
        List<String> al = new ArrayList<>(ans);
        return al;
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

        List<String> temp = findAllConcatenatedWordsInDict(words); 


        for(String s:temp)
        {
            System.out.println(s);
        }

        scn.close();

    }
}
