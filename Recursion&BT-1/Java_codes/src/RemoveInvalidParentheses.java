import java.util.*;
import java.io.*;

public class RemoveInvalidParentheses {
    public static int IsBalanced(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    st.push('(');
                } else {
                    if (st.size() != 0 && st.peek() == '(') {
                        st.pop();
                    } else {
                        st.push(')');
                    }
                }
            }
        }
        return st.size();
    }

    public static void check(String s, List<String> ans, HashSet<String> hset, int mrmvl) {
        if (hset.contains(s))
            return;
        hset.add(s);
        if (mrmvl == 0) {
            if (IsBalanced(s) == 0 ) {
                ans.add(s);                
            }
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);

                check(left + right, ans, hset, mrmvl - 1);
            }
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hset = new HashSet<>();
        int mrmvl = IsBalanced(s);
        check(s, ans, hset, mrmvl);
        return ans;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        String s = scn.next();
        List<String> ans = removeInvalidParentheses(s);
        System.out.println(ans);
        scn.close();

    }
}
