import java.util.*;
public class PrettyPermutations {
   
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) 
    {        
        int t = scn.nextInt();
        while(t-- >0)
        {
            int n = scn.nextInt();
            int i = 1;
            if (n % 2 == 0) {
                while (i <= n) {
                    System.out.print((i + 1) + " ");
                    System.out.print(i + " ");

                    i += 2;
                }
            } else {
                if(n>=3)
                {
                    System.out.print("3 1 2 ");
                }
                i = 4;
                while (i <= n) {
                    System.out.print((i + 1) + " ");
                    System.out.print(i + " ");
                    i += 2;
                }                
            }                        
            System.out.println();
        }
    }    
}