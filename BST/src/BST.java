import java.util.*;
import java.io.*;


public class BST {
    
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    
    public static Node construct(int[] arr , int lo , int hi)    
    {
        if(lo > hi)
        {
            return null;
        }

        int mid = (lo + hi)/2;
        int data = arr[mid];
        Node lc = construct(arr, lo, mid-1);
        Node rc = construct(arr, mid+1, hi);

        Node node = new Node(data,lc,rc);
        return node;
    }

    public static void displayBST(Node node) {

        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);

        displayBST(node.left);
        displayBST(node.right);
    }

    public static Node addBST(Node node,int num ) {
        
        if(node == null)
        {
            return new Node(num,null,null);
        }
        if(num > node.data)
        {
            node.right = addBST(node.right, num);
        }
        else if(num<=node.data)
        {
            node.left = addBST(node.left,num);
        }

        return node;
        
    }

    public static int maxBST(Node node){

        if(node.right!=null)
        {
            return(maxBST(node.right));            
        }
        else{ 
            return(node.data);
        }        
    }

    public static Node removeBST(Node node , int num) {
        if(node==null)
        {
            return null;
        }


        if(num > node.data)
        {
            node.right = removeBST(node.right, num);
        }
        else if(num<node.data)
        {
            node.left = removeBST(node.left, num);
        }
        else{
            if(node.left!=null && node.right!= null)
            {
                int mval =  maxBST(node.left);
                node.data = mval;
                node.left = removeBST(node.left, mval);
                return  node;

            }
            else if(node.left!=null)
            {
                return node.left;
            }
            else if(node.right!=null)
            {
                return node.right;
            }
            else{
                return null;
            }


        }

        return node;
    }

    static int sum = 0;
    public static void rwsol(Node node) {
        if(node==null)
        {
            return;
        }

        rwsol(node.right);
        int od = node.data;
        node.data = sum ;
        sum += od;
        rwsol(node.left);        
    }


    public static int lca(Node node,  int v1, int v2) {
        if(node==null)
        {
            return -1;
        }

        if(node.data > v1 && node.data > v2)
        {
            return(lca(node.left, v1, v2));
        }
        else if(node.data < v1 && node.data < v2)
        {
            return(lca(node.right,v1, v2));
        }
        else{
            return node.data;
        }
    }

    public static void pir(Node node,  int v1 , int v2) {
        if(node==null)
        {
            return;
        }
        
        if(node.data<=v1){
            pir(node.right, v1,v2);
        }
        else if(node.data >= v2)
        {
            pir(node.left, v1, v2);
        }
        else{
            pir(node.left, v1, v2);
            System.out.println(node.data + " ");
            pir(node.right, v1, v2);
        }
    }

    public static boolean find(Node node , int val) {
        
        if(node == null)
        {
            return false;
        }

        if(val>node.data)
        {
            return(find(node.right, val));
        }
        else if(val<node.data)
        {
            return(find(node.left, val));
        }
        else{
            return true;
        }
    }

    public static void tsp1(Node root , Node node , int tar) {
        if(node == null)
        {
            return;
        }

        tsp1(root, node.left, tar);
        int dif = tar - node.data;
        if(node.data < dif)
        {
            if(find(root,dif) == true)
            {
                System.out.println(node.data + " " + dif);
            }
        }        
        tsp1(root, node.right, tar);
    }

    static ArrayList<Integer> inorder = new ArrayList<>();

    public static void tsp2(Node node) {
        if(node == null)
        {
            return;
        }

        
        tsp2(node.left);
        inorder.add(node.data);
        tsp2(node.right);
    }

    public static class ITpair{
        Node node;
        int state;

        ITpair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }

    public static void tsp3(Node node , int tar) {
        Stack<ITpair> ls = new Stack<>();
        Stack<ITpair> rs = new Stack<>();

        ls.push(new ITpair(node,0));
        rs.push(new ITpair(node,0));

        Node left = getLeftFromNormalInorder(ls);
        Node right = getRightFromReverseInorder(rs);

        while(left.data<right.data)
        {
            if(left.data + right.data < tar){
                left = getLeftFromNormalInorder(ls);                
            }
            else if(left.data + right.data > tar){                
                right = getRightFromReverseInorder(rs);
            }
            else{
                System.out.println(left.data + " " + right.data);
                left = getLeftFromNormalInorder(ls);
                right = getRightFromReverseInorder(rs);
            }
        }

    }

    public static Node getLeftFromNormalInorder(Stack<ITpair> st) {
        while(st.size()>0)
        {
            ITpair top = st.peek();
            if(top.state == 0)
            {
                if(top.node.left != null)
                {
                    st.push(new ITpair(top.node.left, 0));
                                
                }
                top.state++;
            }
            else if(top.state == 1)
            {
                if (top.node.right != null) {
                    st.push(new ITpair(top.node.right, 0));

                }
                top.state++;
                return top.node;
            }
            else
            {
                st.pop();                
            }
        }
        return null;
    }
    
    
    public static Node getRightFromReverseInorder(Stack<ITpair> st) {
        while(st.size()>0)
        {
            ITpair top = st.peek();
            if(top.state == 0)
            {
                if(top.node.right != null)
                {
                    st.push(new ITpair(top.node.right, 0));
                                
                }
                top.state++;
            }
            else if(top.state == 1)
            {
                if (top.node.left != null) {
                    st.push(new ITpair(top.node.left, 0));

                }
                top.state++;
                return top.node;
            }
            else
            {
                st.pop();                
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n ; i++)
        {
            arr[i] = scn.nextInt();
        }
        scn.close();
        
        Node root = construct(arr, 0, n-1);
        displayBST(root);

        System.out.println();


        System.out.println(maxBST(root));
        System.out.println();


        Node node =  addBST(root, 40);
        displayBST(node);
        System.out.println();


        Node node2 =  removeBST(root, 40);
        displayBST(node2);
        System.out.println();


        // replace with sum of larger ...
        // rwsol(root);
        // displayBST(root);
        // System.out.println();


        // lowest common anscestor
        int lca = lca(root,12,62);
        System.out.println(lca);
        System.out.println();


        // Print in range
        pir(root,12,62);
        System.out.println();


        // Target sum pair Method 1
        tsp1(root,root,87);
        System.out.println();


        // Target sum pair Method 2
        tsp2(root);
        int val = 87;
        // System.out.println(inorder);
        int i = 0, j = n-1;
        while(i<j)
        {
            if(inorder.get(i)+inorder.get(j) < val)
            {
                i++;
            }
            else if(inorder.get(i)+inorder.get(j) > val)
            {
                j--;
            }
            else{
                System.out.println(inorder.get(i) + " "+ inorder.get(j));
                i++;
                j--;
            }
        }

        System.out.println();

        // Target sum pair Method 3 (Best Approach)
        tsp3(root,87);        

    }
}
