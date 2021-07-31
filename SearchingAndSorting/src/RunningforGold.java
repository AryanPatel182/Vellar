import java.util.*;
import java.io.*;

public class RunningforGold {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int t = scn.nextInt();

        while (t-- > 0)
        {
            int n = scn.nextInt();

            int[][] arr = new int[n][5];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = scn.nextInt();
                }
            }

            if (n == 1) {
                System.out.println(1);
                continue;
            }
            int gold_champ = 0, curr = 1;

            while (curr < n && gold_champ < n )
            {                                
                int cof_gold_champ = 0;
                int cof_curr = 0;

                for (int i = 0; i < 5; i++) 
                {
                    if (arr[gold_champ][i] < arr[curr][i]) 
                    {
                        cof_gold_champ += 1;
                    } else {
                        cof_curr += 1;
                    }
                }
                if (cof_curr >= 3) 
                {
                    gold_champ = curr;
                    curr = gold_champ + 1;
                }
                if (cof_gold_champ >= 3) 
                {
                    curr += 1;
                }
            }

            // System.out.println(gold_champ);
            boolean flag = true;

            curr = 0;

            while (curr < n) {
                // System.out.println(curr);
                if (curr != gold_champ)
                {
                    int cof_curr = 0;
                    for (int j = 0; j < 5; j++) 
                    {
                        if (arr[gold_champ][j] < arr[curr][j]) 
                        {
                        } 
                        else
                        {
                            cof_curr += 1;                            
                        }
                    }

                    if (cof_curr >= 3) {
                        System.out.println(-1);
                        flag = false;        
                        break;                
                    }
                    else
                    {
                        curr +=1;
                    }

                }
                else
                {
                    curr+=1;
                }

            }

            if (flag == true) {
                System.out.println(gold_champ+1);
            }

        }
        scn.close();

    }}

