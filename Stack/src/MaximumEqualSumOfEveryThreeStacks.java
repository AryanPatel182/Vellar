import java.util.*;
import java.io.*;

public class MaximumEqualSumOfEveryThreeStacks {
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int sum1 = 0, sum2 =0 , sum3=0;
        int n1 = scn.nextInt();
        Stack<Integer> st1 = new Stack<>();
        for(int i=0; i<n1; i++)
        {            
            st1.add(scn.nextInt());
            sum1+= st1.peek();
        }
        
        int n2 = scn.nextInt();        
        Stack<Integer> st2 = new Stack<>();
        for (int i = 0; i < n2; i++) 
        {
            st2.add(scn.nextInt());
            sum2 += st2.peek();
        }

        int n3 = scn.nextInt();
        Stack<Integer> st3 = new Stack<>();
        for (int i = 0; i < n3; i++) 
        {
            st3.add(scn.nextInt());
            sum3 += st3.peek();
        }

        while(st1.size()>0 && st2.size()>0 && st3.size()>0)
        {
            if(sum1 == sum2 && sum2 == sum3)
            {
                System.out.println(sum1);
                break;
            }

            if(sum1>=sum2 && sum1>=sum3)
            {
                sum1-= st1.peek();
                st1.pop();
            }
            if(sum2>=sum1 && sum2>=sum3)
            {
                sum2-= st2.peek();
                st2.pop();
            }
            if(sum3>=sum2 && sum3>=sum1)
            {
                sum3-= st3.peek();
                st3.pop();
            }
        }

        if(st1.size() == 0 || st2.size() == 0 || st3.size() == 0)
        {
            System.out.println("Not Possible");
        }
        
        scn.close();

    }
}
