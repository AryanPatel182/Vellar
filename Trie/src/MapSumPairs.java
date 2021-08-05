import java.util.*;
import java.io.*;

public class MapSumPairs {
    public static class Trie
    {
        public static class Node
        {
            Node childs[];
            int count = 0;
            
            Node() {
                childs = new Node[26];
            }
        }

        public Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word, int val)        
        {
            Node curr = root;

            for(int i=0; i<word.length(); i++)
            {
                if(curr.childs[word.charAt(i)-'a'] == null)
                {
                    curr.childs[word.charAt(i)-'a'] = new Node();
                }
                curr = curr.childs[word.charAt(i)-'a'];
                curr.count+=val;
            }
        }

        public int query(String word)    
        {
            Node curr = root;
            for(int i=0; i<word.length(); i++)
            {
                char ch = word.charAt(i);

                if(curr.childs[ch-'a'] == null)
                {
                    return 0;
                }

                curr = curr.childs[ch-'a'];
            }

            return curr.count;
        }
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        HashMap<String, Integer> hmap = new HashMap<>();

        Trie t = new Trie();
        for(int i=0; i<n; i++)
        {
            int type = scn.nextInt();
            String s = scn.next();    

            if(type == 1)
            {
                int val = scn.nextInt();
                if(hmap.containsKey(s) == true)
                {                    
                    t.insert(s,val-hmap.get(s));
                    hmap.put(s, val-hmap.get(s));
                }
                else
                {
                    t.insert(s, val);
                    hmap.put(s, val);
                }
                
            }
            else
            {
                System.out.println(t.query(s));
            }
        }
        scn.close();

    }
}
