import java.util.*;
import java.io.*;

public class LinearDiophantine {

    public static class Pair {
        int x;
        int y;
        int gcd;

        Pair(int x, int y, int gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }

    public static Pair Euclidian(int a, int b) {
        if (b == 0) {
            return new Pair(1, 0, a);
        }

        Pair p = Euclidian(b, a % b);

        return new Pair(p.y, (p.x - (a / b) * p.y), p.gcd);
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int k = scn.nextInt();

        Pair ans = Euclidian(a, b);

        ans.x *= k;
        ans.y *= k;
        scn.close();
        System.out.println(a + "x + " + b + "y" + " = " + k);
        System.out.println("x = " + ans.x + "   y = " + ans.y);

    }
}
