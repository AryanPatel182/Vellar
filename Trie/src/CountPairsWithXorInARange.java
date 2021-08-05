import java.util.*;
import java.io.*;

public class CountPairsWithXorInARange {
    public static class Node
    {
        Node left;
        Node right;
        int count_fin;
    }

    public static void insert(Node root, int val)
    {
        for(int i=20; i>=0; i--)
        {
            int bit = val&(1<<i);

            if(bit == 0)
            {
                if(root.left == null)
                {
                    root.left = new Node();
                }
                root = root.left;
            }
            else
            {
                if(root.right == null)
                {
                    root.right = new Node();
                }
                root = root.right;
            }

            root.count_fin+=1;
        }
    }

    public static int getCount(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        return node.count_fin;
    }

    public static int query(Node root, int high, int val, int index)            
    {
        if(root == null)
        {
            return 0;
        }
        if(index == -1)
        {
            return getCount(root);
        }
        int bitV = (1<<index)&val;
        int bitH = (1<<index)&high;

        if(bitV == 0)
        {
            if(bitH == 0)
            {
                return(query(root.left, high, val, index-1));
            }
            else
            {
                return(getCount(root.left) + query(root.right, high, val, index-1));
            }
        }
        else
        {
            if(bitH == 0)
            {
                return (query(root.right, high, val, index - 1));
                
            }
            else
            {
                return (getCount(root.right) + query(root.left, high, val, index - 1));
            }
        }
    }
    
    public static int countpairwithxor(int[] arr, int low, int high)
    {
        Node root = new Node();

        int count = 0;

        for(int val:arr)
        {
            count+= query(root,high,val,20);
            count-= query(root,low-1,val,20);            
            insert(root,val);
        }

        return count;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n= scn.nextInt();

        int[] arr= new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int low = scn.nextInt();
        int high = scn.nextInt();

        System.out.println(countpairwithxor(arr, low, high));
        
        scn.close();

    }
}
