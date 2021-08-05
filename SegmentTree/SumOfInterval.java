import java.util.*;
import java.io.*;

public class SumOfInterval {

    public static class SegmentTree {
        int tree[];
        int arr[];

        SegmentTree(int[] ar)
        {
            arr = ar;
            tree= new int[4*ar.length];
            build(1, 0, ar.length-1);
        }

        public void build(int node, int start, int end)
        {
            if(start == end)
            {
                tree[node] = arr[start];
                return;
            }
            int mid = (start+end)/2;
            build(2*node, start, mid);
            build(2*node+1, mid+1, end);

            tree[node] = tree[2*node] + tree[2*node+1];
        }

        public void update(int node, int start, int end, int pos, int val)
        {

            if(start == end)
            {
                arr[start] = val;
                tree[node] = val;
                return;
            }
            int mid = (start+end)/2;
            if(start<=pos && pos<=mid)
            {
                update(2*node, start, mid, pos, val);
            }
            else
            {
                update(2*node+1, mid+1, end, pos, val);
            }
            tree[node] = tree[2*node] + tree[2*node+1];
        }
        public int query(int node, int start, int end, int l, int r)
        {
            if(end<l || start>r)
            {
                return 0;
            }            
            if(start == end)
            {
                return tree[node];
            }
            else if (l <= start && end <= r) {
                return tree[node];
            }
            else
            {
                int mid = (start + end)/2;

                int left = query(2*node, start, mid, l, r);
                int right = query(2*node, mid+1, end, l, r);

                return left + right;
            }                

        }

        public void update(int pos, int val)
        {
            update(1, 0 , arr.length-1, pos, val);
        }
        public int query(int l, int r)
        {
            return query(1, 0, arr.length-1, l, r);
        }
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
        {
            arr[i] = scn.nextInt();
        }

        SegmentTree t = new SegmentTree(arr);
        int k = scn.nextInt();
        for(int i=0; i<k; i++)
        {
            int type = scn.nextInt();

            if(type == 2)
            {                
                System.out.println(t.query(scn.nextInt(), scn.nextInt()));
            }
            else
            {
                t.update(scn.nextInt(), scn.nextInt());
            }

        }

        scn.close();

    }
}
