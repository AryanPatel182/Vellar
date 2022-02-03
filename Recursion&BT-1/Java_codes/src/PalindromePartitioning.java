import java.util.*;
import java.io.*;

public class PalindromePartitioning {

    public static boolean palindrom(String s) {
        if(s.length() == 1) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;                
            }
            i+=1;
            j-=1;
        }
        return true;
    }

    public static void partitionHelper(String s, Deque<String> util, HashSet<String> hset, List<List<String>> ans) {                    
        if (s.length() == 0) {            
            ans.add(new ArrayList<>(util));     
            return;
        }                
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            // System.out.println(left + " - " + right);
            
            if (palindrom(left)) {
                util.addLast(left);                
                partitionHelper(right, util, hset, ans);                                  
                util.removeLast();                
            }
        }        
    }

    public static List<List<String>> partition(String s) {
        Deque<String> util = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        HashSet<String> hset = new HashSet<>();
        // System.out.println(s);
        partitionHelper(s, util, hset, ans);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String s = scn.next();        
        System.out.println(partition(s));
        scn.close();

    }
}
