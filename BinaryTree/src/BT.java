import java.util.*;
import java.io.*;

public class BT {

    // Node class -- for making a new node...
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // pair classs --- for making a pair of a node with its status .... Our stack will use this pair DS.
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }        
    }

    // Method of display Binary tree
    public static void displayBT(Node node) {
        
        if(node==null)
        {
            return;
        }
        String str  = "";
        str += node.left ==null ? "." :  node.left.data + " ";
        str += " <- " + node.data + " -> ";
        str += node.right ==null ? "." :  node.right.data + " ";
        System.out.println(str);

        
        displayBT(node.left);
        displayBT(node.right);
    }

    public static int sizeBT(Node node) {               // size of Binary Tree
        if(node==null)
        {
            return 0;
        }

        int ls = sizeBT(node.left);
        int rs = sizeBT(node.right);
        int ans = ls + rs + 1;
        return ans;        
    }

    public static int maxBT(Node node) {                // Maximum in Binary Tree
        if(node == null)
        {
            return Integer.MIN_VALUE;
        }

        int lm = maxBT(node.left);
        int rm = maxBT(node.right);
        int ans = Math.max( node.data , Math.max(lm,rm));
        return ans;
    }

    public static int heightBT(Node node) {             // Height of Binary Tree
        if(node == null)
        {
            return -1;
        }

        int lh = heightBT(node.left);
        int rh = heightBT(node.right);
        int ans = Math.max(lh,rh) + 1;
        return ans;
    }

    public static void preOrder(Node node) {               // Preorder traversal
        if(node == null)
        {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {             //  Inorder Traversal
        if(node == null)
        {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {               // Postorder Traversal
        if(node == null)
        {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node node) {              // Levelorder Traversal
        Queue<Node> nq = new ArrayDeque<>();
        nq.add(node);

        while(nq.size()>0)
        {
            int count = nq.size();
            for(int i=0;i<count;i++)
            {
                node = nq.remove();
                System.out.print(node.data + " ");
                if(node.left!=null)
                {
                    nq.add(node.left);
                }
                if(node.right!=null)
                {
                    nq.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void prepinpostIterative(Node node) {
        Pair p = new Pair(node, 1);
        Stack<Pair> st = new Stack<>();
        st.push(p);

        while(st.size()>0)
        {
            Pair top = st.peek();
            if(top.state==1)
            {
                System.out.println(top.node.data + " Preorder ");
                if(top.node.left!= null)
                {   
                    Pair np = new Pair(top.node.left, 1);
                    st.push(np);
                }
                
                top.state++;
            }
            else if(top.state==2)
            {
                System.out.println(top.node.data + " Inorder ");
                if (top.node.right != null) {
                    Pair np = new Pair(top.node.right, 1);
                    st.push(np);
                }
                top.state++;
            }
            else
            {
                System.out.println(top.node.data + " Postorder ");
                st.pop();
            }
        }
    }
    static String str = "";
    static ArrayList<Node> path = new ArrayList<>();
    public static boolean nodetoroot(Node node, int n) {
        if(node == null)
        {
            return false;
        }

        if(node.data == n)
        {
            path.add(node);            
            str += node.data + " ";
            return true;
        }
        boolean lr = nodetoroot(node.left, n);
        if(lr)
        {
            path.add(node);
            str += node.data + " ";
            return true;
        }
        boolean rr =  nodetoroot(node.right, n);
        if(rr)
        {
            path.add(node);
            str += node.data + " ";
            return true;
        }
        return false;
    }


    public static void kLevels(Node node, int level, Node blocker) {

        if(node==null || level<0 || node == blocker)
        {
            return;
        }
        if(level==0)
        {
            System.out.println(node.data + " ");
        }
        kLevels(node.left, level-1 , blocker);
        kLevels(node.right, level-1 , blocker);
        
    }   

    public static void  klevelfar(Node node, int val ,int level) {
        path = new ArrayList<>();
        nodetoroot(node, val);
        // System.out.println(path);


        for(int i=0; i<path.size(); i++)
        {
            kLevels(path.get(i), level-i, i == 0 ? null : path.get(i-1));
        }

    }


    public static Node leftclone(Node node) {

        if(node == null)
        {
            return null;
        }

        Node lt = leftclone(node.left);
        Node rt = leftclone(node.right);

        node.right = rt;
        Node nn = new Node(node.data , lt, null);
        node.left = nn;
        
        return node;
    }

    public static Node rmleftclone(Node node) {
        if(node == null)
        {
            return null;
        }
        
        Node lt = rmleftclone(node.left.left);
        Node rt = rmleftclone(node.right);
        // leftclone(node.left.right);

        node.left = lt;
        node.right = rt;

        return node;

    }

    // public static void singlechild(Node child, Node parent) {
    //     if(child == null)
    //     {
    //         return ;
    //     }
    //     if(parent!=null && parent.left == child && parent.right==null)
    //     {
    //         System.out.println(parent.data);
    //     }
    //     if(parent!=null && parent.right == child && parent.left==null)
    //     {
    //         System.out.println(parent.data);
    //     }


    //     singlechild(child.left, child);
    //     singlechild(child.right, child);
    // }
    public static void singlechild(Node node) {
        if(node==null)
        {
            return;
        }
        else if((node.left==null && node.right!=null) || (node.right==null && node.left!=null))
        {
            System.out.println(node.data);
        }

        singlechild(node.left);
        singlechild(node.right);
        
    }


    public static Node removeleaves(Node node) {
        
        if(node==null)
        {
            return null;
        }
        if(node.left == null && node.right == null)
        {
            node = null;
            return node;
        }

        Node lt = removeleaves(node.left);
        Node rt = removeleaves(node.right);

        node.left = lt;
        node.right = rt;
        return node;
    }

    // public static int diameter(Node node) {
        
    //     if(node == null)
    //     {
    //         return 0;
    //     }

    //     int lm = diameter(node.left);
    //     int rm = diameter(node.right);

    //     int mm = heightBT(node.left) + heightBT(node.right) + 2;

    //     return Math.max(mm, Math.max(lm, rm));

    // }

    public static class diaPair {
        int ht ;
        int dt ;
    }

    public static diaPair diameter(Node node) {
        
        if(node == null)
        {
            diaPair p = new diaPair();
            p.ht = -1;
            p.dt = 0;
            return p;
        }

        diaPair lp = diameter(node.left);
        diaPair rp = diameter(node.right);

        diaPair ans = new diaPair();
        int f = lp.ht + rp.ht + 2;
        ans.ht = Math.max(lp.ht,rp.ht) + 1;
        ans.dt = Math.max(f, Math.max(lp.dt, rp.dt));

        return ans;        

    }

    static int tilt = 0;
    public static int tilt(Node node) {
        if(node==null)
        {
            return 0;
        }
       
        int ls = tilt(node.left);
        int rs = tilt(node.right);
        tilt += Math.abs(ls-rs);

        return ls+rs+node.data;
    }

    // public static class BstPair {
    //     boolean isBST;
    //     int min;
    //     int max;        
    // }

    // public static BstPair IsBST(Node node) {

    //     if(node == null)
    //     {
    //         BstPair temp = new BstPair();
    //         temp.isBST = true;
    //         temp.min = Integer.MAX_VALUE;
    //         temp.max = Integer.MIN_VALUE;

    //         return temp;
    //     }


    //     BstPair lp = IsBST(node.left);
    //     BstPair rp = IsBST(node.right);
    //     BstPair ans = new BstPair();

    //     ans.isBST = lp.isBST && rp.isBST && node.data>=lp.max && node.data<=rp.min;
    //     ans.min = Math.min(node.data, Math.min(lp.min, rp.min));
    //     ans.max = Math.max(node.data, Math.max(lp.max, rp.max));

    //     return ans;
    // }


    public static class BalancePair{
        boolean isbalance;
        int ht;      
    }


    public static BalancePair IsBalance(Node node) {
        if(node == null)
        {
            BalancePair temp = new BalancePair();
            temp.isbalance = true;
            temp.ht = -1;

            return temp; 
        }


        BalancePair lp = IsBalance(node.left);
        BalancePair rp = IsBalance(node.right);

        BalancePair ans = new BalancePair();

        ans.isbalance = lp.isbalance && rp.isbalance && Math.abs(lp.ht - rp.ht)<=1;
        ans.ht = Math.max(lp.ht, rp.ht) + 1;

        return ans;

    }


    public static class SubBstPair {
        boolean isBST;
        int min;
        int max;
        Node node;
        int size;

    }

    public static SubBstPair SubIsBST(Node node) {

        if (node == null) {
            SubBstPair temp = new SubBstPair();
            temp.isBST = true;
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            temp.node = null;
            temp.size = 0;
            return temp;
        }

        SubBstPair lp = SubIsBST(node.left);
        SubBstPair rp = SubIsBST(node.right);
        SubBstPair ans = new SubBstPair();

        ans.isBST = lp.isBST && rp.isBST && node.data >= lp.max && node.data <= rp.min;
        ans.min = Math.min(node.data, Math.min(lp.min, rp.min));
        ans.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if(ans.isBST)
        {
            ans.node = node;
            ans.size = lp.size + rp.size + 1;
        }
        else if(lp.size > rp.size)
        {
            ans.node = lp.node;
            ans.size = lp.size;
        }
        else{
            ans.node = rp.node;
            ans.size = rp.size;
        }
        return ans;
    }


    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);        
        
        // int n = scn.nextInt();
        // Integer[] arr = new Integer[n];
        // Integer[] arr = {50, 25, 12, null, null ,37 ,30 ,null, null, null, 75 ,62 ,null ,70 ,null ,null ,87 ,null ,null};
        // Integer[] arr = {50, 25, 12, null, null ,37 ,30 ,null, null,40, null, null, 75 ,62 , 60 ,null, null,77,null, null ,87 ,null ,null};
        // Integer[] arr = {22,78,87,89,99,9,89,null,null, null, null, null, null, null, null};
        

        scn.close();

        // Constrction of Binary tree....
        Node root = new Node(arr[0] ,null, null);        
        Stack<Pair> st = new Stack<>();
        Pair rp = new Pair(root, 1);
        st.push(rp);  

        int idx = 0;
        while(st.size()>0)
        {
            Pair top = st.peek();
            // System.out.println(top.node.data);
            if(top.state == 1 )
            {
                idx ++;
                if(arr[idx]==null)
                {   
                    top.node.left = null;
                    top.state++;
                    
                }else{
                    Node lnode = new Node(arr[idx] , null , null);
                    top.node.left = lnode;                    
                    top.state ++;
                    Pair p = new Pair(lnode , 1);
                    st.push(p);
                }
            }
            else if(top.state == 2)
            {
                idx++;
                if(arr[idx]==null)
                {          
                    top.node.right= null;                              
                    top.state++;
                }
                else{
                    Node rnode = new Node(arr[idx], null, null);
                    top.node.right = rnode;
                    top.state ++;
                    Pair p = new Pair(rnode, 1);                    
                    st.push(p);
                }
            }
            else
            {
                st.pop();            
            }
        }


        // Display Binary Tree ...
        // displayBT(root);

        // size of Binary Tree ...
        // System.out.println(sizeBT(root));   
        // System.out.println(maxBT(root));     
        // System.out.println(heightBT(root));
        
        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();
        // postOrder(root);


        // levelOrder(root);
        // prepinpostIterative(root);
                
        // System.out.println(nodetoroot(root,70));
        // System.out.println(str);

        // kLevels(root,3);

        // klevelfar(root,75,3);       
        // System.out.println(path);

        
        // displayBT(root);
        // Node n1 = leftclone(root);        
        // System.out.println();        
        // Node n2 = rmleftclone(n1);    
        // displayBT(n2);
        
        // singlechild(root, null);
        // singlechild(root);
        
        // Node n =  removeleaves(root);
        // System.out.println();        
        // displayBT(n);
        // levelOrder(n);


        // diaPair ans = diameter(root);
        // System.out.println(ans.dt);

        // tilt(root);
        // System.out.println(tilt);

        // System.out.println(IsBST(root).isBST);
        
        // System.out.println(IsBalance(root).isbalance);
        System.out.println(SubIsBST(root).size);
        
    }
}
