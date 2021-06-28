import java.util.*;
import java.io.*;

public class PartitionLabels {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();
        scn.close();
        List<Integer> ans = new ArrayList<>();
        int l = s.length();

        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            hmap.put(ch, i);
        }

        int prev = -1;
        int max = 0;

        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            max = Math.max(max, hmap.get(ch));
            if (max == i) {
                ans.add(max - prev);
                prev = max;
                // max = 0;
            }

        }

        System.out.println(ans);
    }
}
