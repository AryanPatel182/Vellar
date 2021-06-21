import java.util.*;
import java.io.*;

public class KLargest {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(scn.nextInt());
        }

        int k = scn.nextInt();
        while (pq.size() > k) {
            int val = pq.peek();
            System.out.println(val);
            pq.remove();
        }

        System.out.println(pq);
        scn.close();

    }
}
