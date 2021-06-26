import java.util.*;
import java.io.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for(int i = 2 ; i*i<=n ; i++)
        {
            if(prime[i]!=false){
                int count = 2 ;
                while(i*count <= n)
                {
                    prime[i*count] = false;
                    count++;
                }
            }
        }

        for(int i = 2 ; i <= n ; i++)
        {
            if(prime[i] == true)
            {
                System.out.print(i + " ");
            }
        }

        scn.close();

    }
}
