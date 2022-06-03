import java.util.*;
import java.io.*;

public class NumberOfValidSubaarays {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        arr[n] = Integer.MIN_VALUE;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(n);
        for(int i=n-1; i>=0; i--)
        {           
            while(st.size()>0 && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(st.size()== 0)
            {
                ans+= n-i;
                st.push(i);
            }
            else
            {
                ans = ans + st.peek() - i;
                st.push(i);
            }
        }
        System.out.println(ans);
        scn.close();

    }
}
