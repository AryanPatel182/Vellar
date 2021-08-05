import java.util.*;
import java.io.*;

public class UpdateInSagmentTree {

    public static class SegmentTree {
        int[] tree;
        int[] arr;

        SegmentTree(int[] ar) {
            arr = ar;
            tree = new int[4 * arr.length];
            build(1, 0, arr.length - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            int left = 2 * node;
            int right = 2 * node + 1;
            build(left, start, mid);
            build(right, mid + 1, end);

            tree[node] = Math.max(tree[left], tree[right]);
        }

        public void update(int pos, int val)
        {
            update(1, 0, arr.length-1, pos, val);
        }

        private void update(int node, int start, int end, int pos, int val)
        {
            if(start == end)
            {
                arr[pos] = val;
                tree[node] = val;                
            }            
            else
            {
                int mid = (start + end) / 2;
                if (start <= pos && pos <= mid) {
                    update(2 * node, start, mid, pos, val);
                } else {
                    update(2 * node + 1, mid + 1, end, pos, val);
                }
                tree[node] = Math.max(tree[2*node], tree[2*node+1]);
            }
            
        }
        private int query(int node, int start, int end, int l, int r) {
            if (start > r || end < l)
                return -1000;

            if (start == end)
                return tree[node];

            else if (l <= start && end <= r) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                int left = query(node * 2, start, mid, l, r);
                int right = query(node * 2 + 1, mid + 1, end, l, r);
                return Math.max(left, right);
            }
        }

        int query(int l, int r) {
            return query(1, 0, arr.length - 1, l, r);
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
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        SegmentTree t = new SegmentTree(arr);

        int query = scn.nextInt();
        for (int i = 0; i < query; i++) {
            int type = scn.nextInt();
            if(type == 1)
            {
                t.update(scn.nextInt(),scn.nextInt());
            }
            if(type == 2)
            {
                System.out.println(t.query(scn.nextInt(), scn.nextInt()));
            }            
            // for(int j=0; j<t.arr.length; j++)
            // {
            //     System.out.print(t.arr[j]+" ");
            // }

            // System.out.println();
        }
        scn.close();

    }
}
