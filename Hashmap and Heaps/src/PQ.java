import java.util.*;
import java.io.*;

public class PQ {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.add(scn.nextInt());
        }
        while (pq.size() > 0) {
            int val = pq.peek();
            System.out.println(val);
            pq.remove();
        }
        scn.close();

    }
}
