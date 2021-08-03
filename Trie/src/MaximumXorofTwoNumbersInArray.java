import java.util.*;
import java.io.*;

public class MaximumXorofTwoNumbersInArray {

    public static class Trie {
        public class Node {
            Node left, right;
        }

        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int val) {
            int bitIndex = 30;

            Node curr = root;

            while (bitIndex >= 0) {
                int bitmask = 1 << bitIndex;
                int bit = val & bitmask;

                if (bit == 0) {
                    if (curr.left == null) {
                        curr.left = new Node();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }

                bitIndex -= 1;
            }
        }

        public int query(int val) {
            int bitIndex = 30;
            int ans = 0;
            Node curr = root;
            while (bitIndex >= 0) {
                int bitmask = 1 << bitIndex;
                int bit = bitmask & val;

                if (bit == 0) {
                    if (curr.left == null) {
                        ans = ans | bitmask;
                        curr = curr.right;                        
                    } else {
                        curr = curr.left;
                    }
                } 
                else
                {
                    if(curr.right == null) {
                        curr = curr.left;
                    } else {                        
                        ans = ans | bitmask;
                        curr = curr.right;
                    }
                }

                bitIndex -= 1;
            }
            return ans;

        }
    }

    public static int maxxor(int[] arr, int n) {
        Trie trie = new Trie();
        for (int val : arr) {
            trie.insert(val);
        }

        int max = 0;

        for (int val : arr) {
            int find = Integer.MAX_VALUE ^ val;
            int res = trie.query(find);
            max = Math.max(max, val ^ res);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(maxxor(arr, n));

        scn.close();

    }
}
