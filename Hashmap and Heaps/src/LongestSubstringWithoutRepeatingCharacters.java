import java.util.*;
import java.io.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        String ans = "";

        HashMap<Character, Integer> hmap = new HashMap<>();

        int i = -1;
        int j = -1;

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;

            // acquire
            while (i < n - 1) {
                flag1 = true;
                i += 1;
                char ch = s.charAt(i);

                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

                if (hmap.get(ch) == 2) {
                    break;
                } else {
                    String pans = s.substring(j + 1, i + 1);
                    if (ans.length() == 0 || pans.length() > ans.length()) {
                        ans = pans;
                    }
                }
            }

            // release
            while (j < i) {
                flag2 = true;

                j += 1;
                char ch = s.charAt(j);

                hmap.put(ch, hmap.get(ch) - 1);

                if (hmap.get(ch) == 1) {
                    break;
                }
            }

            if (flag1 == false && flag2 == false) {
                break;
            }
        }

        return ans.length();

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        String s = scn.next();

        System.out.println(lengthOfLongestSubstring(s));
        scn.close();

    }
}
