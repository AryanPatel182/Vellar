import java.util.*;
import java.io.*;

public class GT {

    public static class Node
    {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void displayGT(Node node)
    {
        String str = node.data + " -> ";
        for(Node tmp : node.children)
        {
            str += tmp.data + " , ";            
        }
        str += " . ";
        System.out.println(str);
        for(Node tmp :  node.children)
        {
            displayGT(tmp);
        }
    }

    public static int sizeGT(Node node) {
        int count = 0;
        for(Node temp : node.children)
        {            
            count = count + sizeGT(temp);            
        }
        return count+1;
        
    }

    public static int maxGT(Node node)
    {
        int max = Integer.MAX_VALUE;

        for(Node temp: node.children)
        {
            int k = maxGT(temp);
            max = Math.max(k, max);
        }
        return Math.max(max, node.data);
    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        int[] arr = new int[n];

        Node root = null;
        Stack<Node> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();        
            if(arr[i]==-1)
            {
                st.pop();
            }
            else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size()>0)
                {
                    st.peek().children.add(t);
                }
                else{
                    root = t;
                }
                st.push(t);
            }

        }

        // displayGT(root);
        int size = sizeGT(root);
        System.out.println(size);
        scn.close();
        int max = maxGT(root);
        System.out.println(max);

    }
}
