import java.util.*;


import java.io.*;

public class ReplaceWords { 
    public static class Node
    {
        Node[] childs = new Node[26];
        String str;
    }

    public static void insert(String word, Node curr)
    {   
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);

            if(curr.childs[ch-'a'] == null)
            {
                curr.childs[ch-'a'] = new Node();
            }
            curr = curr.childs[ch-'a'];

            if(curr.str != null)
            {
                return;
            }
        }
        curr.str= word;
    }

    public static String query(String word, Node curr)
    {

        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            
            if(curr.childs[ch-'a'] != null)
            {                
                if(curr.childs[ch-'a'].str != null)
                {
                    return curr.childs[ch-'a'].str;
                }              
                else
                {                    
                    curr = curr.childs[ch-'a'];
                }  
            }
            else
            {                
                return word;
            }
        }
        return word;
    }

    public static String replaceWords(List<String> dictionary, String sentence)
    {
        Node root = new Node();
        for(String s:dictionary)
        {
            insert(s, root);
        }

        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(sentence);
        while(st.hasMoreTokens())
        {
            String word = st.nextToken();
            ans.append(query(word, root)+" ");
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        List<String> dictionary = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            String s = scn.next();
            dictionary.add(s);
        }        
        scn.nextLine();
        String scentence = scn.nextLine();
                
        System.out.println(replaceWords(dictionary, scentence));
        scn.close();

    }
}
