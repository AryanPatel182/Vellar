import java.util.*;
import java.io.*;

public class NumberofValidWordsforEachPuzzle {
    
    public static ArrayList<Integer> findNumOfValidWords(String[] words,  String[] puzzles)
    {
        HashMap<Character, ArrayList<Integer>> hmap = new HashMap<>();
        for(int i=0; i<26; i++)
        {
            char ch = (char)('a'+i);
            hmap.put(ch, new ArrayList<>());
        }
        for(String word:words)
        {
            int mask = 0;
            for(char ch: word.toCharArray())
            {
                int bit = ch-'a';
                mask = mask | (1<<bit);
            }

            HashSet<Character> hset = new HashSet<>();
            for(char ch:word.toCharArray())
            {
                if(hset.contains(ch))
                {
                    continue;
                }

                hset.add(ch);
                hmap.get(ch).add(mask);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(String puzzle:puzzles)
        {
            int count = 0;
            int pmask = 0;
            for (char ch : puzzle.toCharArray()) {
                int bit = ch - 'a';
                pmask = pmask | (1 << bit);
            }
            
            char fc = puzzle.charAt(0);

            ArrayList<Integer> check = hmap.get(fc);
            for(int val : check)
            {
                if((pmask & val ) == val)
                {
                    count += 1;
                }
            }
            ans.add(count);
        }

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
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        
        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        
        for (int i = 0 ; i<ans.size(); i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
        
        scn.close();
    }
}
