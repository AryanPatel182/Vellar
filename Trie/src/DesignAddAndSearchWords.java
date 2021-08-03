import java.util.*;
import java.io.*;

public class DesignAddAndSearchWords {

    public static class Trie
    {
        public class Node
        {
            Node[] childs;
            boolean isEnd;

            Node()
            {
                childs = new Node[26];
            }
        }

        final Node root;
        public Trie()
        {
            root = new Node();
        }

        public void insert(String word)
        {
            Node curr = root;

            for(int i=0; i<word.length(); i++)
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

        public boolean search(String word)
        {
            return find(word, 0, root);
        }

        private boolean find(String word, int i, Node curr)
        {
            if(i >= word.length())
            {
                return curr.isEnd;
            }
            char ch = word.charAt(i);

            if(ch == '.')
            {
                for(Node child : curr.childs)
                {
                    if(child != null && find(word,i+1,child))
                    {
                        return true;
                    }
                }
                return false;
            }
            else
            {
                if(curr.childs[ch-'a'] == null)
                {
                    return false;
                }
                else
                {
                    return find(word,i+1, curr.childs[ch-'a']);
                }
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        Trie trie = new Trie();
        for(int i=0; i<n; i++)
        {
            int k = scn.nextInt();
            String word = scn.next();
            if(k==1)
            {
                trie.insert(word);
            }
            else if(k==2)
            {
                System.out.println(trie.search(word));
            }
        }
        scn.close();

    }
}
