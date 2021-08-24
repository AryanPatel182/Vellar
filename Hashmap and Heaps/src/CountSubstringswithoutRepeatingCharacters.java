import java.util.*;
import java.io.*;

public class CountSubstringswithoutRepeatingCharacters {

    public static int substringcount(String s) {
        // write your code here
        int n = s.length();

        int i = -1;
        int j = -1;

        HashMap<Character, Integer> hmap = new HashMap<>();
        int ans = 0;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < n - 1) {
                f1 = true;
                i += 1;
                char ch = s.charAt(i);
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

                if (hmap.get(ch) == 2) {                    
                    break;
                } else {
                    ans += (i - j);
                }
            }

            while (j < i) {
                f2 = true;
                j += 1;

                char ch = s.charAt(j);
                hmap.put(ch, hmap.get(ch) - 1);

                if (hmap.get(ch) == 1) {
                    ans += (i - j);
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;

    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();

        System.out.println(substringcount(s));
        scn.close();

    }
}
