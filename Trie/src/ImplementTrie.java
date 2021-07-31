import java.util.*;
import java.io.*;

public class ImplementTrie 
{
    public static class Trie 
    {
        public class Node 
        {
            Node[] childs;
            boolean isend;

            Node() {
                childs = new Node[26];
            }
        }

        public static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.childs[ch - 'a'] == null) {
                    curr.childs[ch - 'a'] = new Node();
                }
                curr = curr.childs[ch - 'a'];
            }
            curr.isend = true;
        }

        public boolean search(String word) {
            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }
            if (curr.isend != true) {
                return false;
            }

            return true;
        }

        public boolean startsWith(String word) {
            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        
        int n = scn.nextInt();
        Trie t = new Trie();
        for(int i=0; i<n; i++)
        {
            int k = scn.nextInt();
            String s = scn.next();

            if(k==1)
            {
                t.insert(s);
            }
            else if(k==2)
            {                
                System.out.println(t.search(s));
            }
            else if(k==3)
            {
                System.out.println(t.startsWith(s));
            }
        }
                
        scn.close();
    }
}