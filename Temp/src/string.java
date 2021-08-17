import java.util.*;
import java.io.*;

public class string {
    public static int isNumber(final String A) {
        int n = A.length();

        int i = 0;
        int j = n - 1;
        boolean eflag = false;
        while (i < n) {
            if (A.charAt(i) == ' ')
                i += 1;
            else
                break;
        }
        if (i == n)
            return 0;
        while (j >= 0) {
            if (A.charAt(j) == ' ')
                j -= 1;
            else
                break;
        }

        if(A.charAt(i) == '-')
        {
            i+=1;
        }
        for (int k = i; k <= j; k++) {
            if (A.charAt(k) == ' ') {
                return 0;
            }
            else if (A.charAt(k) == '.') 
            {
                if (eflag == true || k == j) 
                {
                    return 0;
                } 
                else if (A.charAt(k + 1) < '0' || A.charAt(k + 1) > '9') 
                {
                    return 0;
                }
                else 
                {
                    k += 1;
                }
            }
            else if (A.charAt(k) == 'e') 
            {
                eflag = true;
                if (k == j || k == i) 
                {
                    return 0;
                }
                else if (A.charAt(k - 1) < '0' || A.charAt(k - 1) > '9') 
                {
                    return 0;
                }
                else if (A.charAt(k + 1) == '-') 
                {
                    if (A.charAt(k + 2) < '0' || A.charAt(k + 2) > '9') 
                    {
                        return 0;
                    } else 
                    {
                        k += 2;
                    }
                }
                else if (A.charAt(k + 1) < '0' || A.charAt(k + 1) > '9') 
                {
                    return 0;
                }
                else 
                {
                    k += 1;
                }
            } 
            else if (A.charAt(k) < '0' || A.charAt(k) > '9') 
            {                
                return 0;
            }            
            System.out.println(A.charAt(k));            
        }

        return 1;
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        System.out.println(isNumber(scn.next()));
        scn.close();

    }
}
