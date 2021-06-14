import java.util.*;
import java.io.*;

public class AddLastInLL {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head = null;
        Node tail = null;
        int size;

        void addFirst(int value)
        {
            Node temp = new Node();
            temp.data = value;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void addLast(int value) {
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size==0)
            {
                addFirst(value);
            }
            else{
                Node trav = head;
                // System.out.println(size);
                for(int i=0;i<size-1;i++)       
                {
                    trav = trav.next;
                }
                trav.next = temp;
                tail = temp;
                size++;
            }
            // System.out.println(size);
        }

        void addAtIndex(int idx, int value) {
            if (idx < 0 || idx > size) {
                System.out.println("Wring index  given");
            }
            else if(idx ==0 )
            {
                addFirst(value);
            }
            else if(idx ==size )
            {
                addLast(value);
            }
            else {
                Node temp = new Node();
                temp.data = value;
                temp.next = null;

                Node trav = head;
                for (int i = 0; i < idx - 1; i++) {
                    trav = trav.next;
                }
                temp.next = trav.next;
                trav.next = temp;

                size++;
            }
        }
        void removeAtIndex(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Wrong index  given");
            }
            else if(idx==0 )
            {
                removeFirst();
            }
            else if(idx ==size-1 )
            {
                removeLast();
            }
            else {
                Node temp = head;
                for(int i=0; i< idx-1;i++)
                {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size++;
            }
        }

        void removeFirst() {
            if (size == 0) {
                System.out.println("Cant remove any node");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node temp = head;
                head = temp.next;
                temp.next = null;
                size--;
            }
        }
        int getFirst() {
            if (size == 0) {
                System.out.println("Cant remove any node");
                return 0;
            } else {
                int k = head.data;
                return k;
            }
        }
        void removeLast() {
            if (size == 0) {
                System.out.println("Cant remove node");
            } else if (size == 1) {
                removeFirst();
            } else 
            {
                Node temp = head;
                for(int i=0;i<size-2;i++)
                {
                    temp = temp.next;
                }
                // System.out.println(temp.data);
                temp.next = null;
                size--;
            }
        }

        Node getNodeAt(int idx)
        {
            Node temp = head;
            for(int i=0;i<idx;i++)
            {
                temp = temp.next;
            }
            return temp;
        }
        void reverseDataIterative()
        {
            int li = 0 , ri = size-1;
            while(li<ri)
            {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                int temp = left.data;
                left.data = right.data;
                right.data = temp;       
                li++;
                ri--;         
            }
            
        }
        void reversePointerIterative()
        {
            Node prev = null;
            Node curr = head;

            while(curr != null)
            {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            Node tmp = head;
            head = tail;
            tail = tmp; 
            
        }
        Node midNode(Node head,Node tail)
        {
            Node s = head;
            Node f = head;

            while(f!=tail && f.next!=tail)
            {
                s = s.next;
                f = f.next.next;
            }
            return s;
        }

        LinkedList merge(LinkedList lh, LinkedList rh)
        {
            Node p1= lh.head;
            Node p2 = rh.head;

            LinkedList ans = new LinkedList();
            while(p1 != null && p2 != null)
            {
                if(p1.data<p2.data)
                {
                    ans.addLast(p1.data);
                    p1 = p1.next;
                }
                else{
                    ans.addLast(p2.data);
                    p2 = p2.next;
                }
            }
            while(p1!=null)
            {
                ans.addLast(p1.data);
                p1 = p1.next;
            }
            while(p2!=null)
            {
                ans.addLast(p2.data);
                p2 = p2.next;
            }

            return ans;

        }


        LinkedList merge_sort(Node head, Node tail)
        {   
            if (head == tail) {
                LinkedList temp = new LinkedList();
                temp.addFirst(head.data);
                return temp;
            }
            
            Node mid = midNode(head, tail);

            LinkedList lh = merge_sort(head, mid);
            LinkedList rh = merge_sort(mid.next, tail);
            
            LinkedList ans  = merge(lh,rh);
            return ans; 

        }

        void removeDuplicate()
        {            
            LinkedList ans = new LinkedList();                        
            while(this.size>0)
            {
                int val = this.getFirst();
                this.removeFirst();

                if(ans.size==0 || val!=ans.tail.data )
                {
                    ans.addLast(val);
                }
            }
            this.head = ans.head;
            this.tail = ans.tail;
            this.size = ans.size;

        }
        
        void oddeven()
        {
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size>0)
            {
                int val = this.getFirst();
                this.removeFirst();

                if(val%2==0)
                {
                    even.addLast(val);
                }else{
                    odd.addLast(val);
                }
            }
            
            if(odd.size>0 && even.size>0)
            {
                this.head = odd.head;
                odd.tail.next = even.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            }
            else if(even.size==0)
            {
                this.head = odd.head;                
                this.tail = odd.tail;
                this.size = odd.size;
            }
            else if(odd.size==0)
            {
                this.head = even.head;            
                this.tail = even.tail;
                this.size = even.size;
            }            
        }

        void kreverse(int k)
        {
            LinkedList prev = new LinkedList();
            

            
            while(this.size > 0)
            {
                LinkedList curr = new LinkedList();
                if(this.size >=k)
                {
                    for(int i=0; i<k ;i++)
                    {  
                        int val = this.getFirst();
                        this.removeFirst();                        
                        curr.addFirst(val);                        
                    }
                }
                else{
                    int s =this.size;
                    for(int i=0;i<s;i++)
                    {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                }

                if(prev.size==0)
                {
                    prev = curr;
                }

                else{
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size = prev.size + curr.size;
                }

            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;

        }

        void displayReverse(Node head)
        {   
            if(head==tail)
            {
                System.out.print(head.data + " ");                
            }
            else
            {
                displayReverse(head.next);
                System.out.print(head.data + " ");
            }            

        }

        void reversePointerRecursion(Node node)                
        {
            if(node==null)
            {
                return;            
            }
            reversePointerRecursion(node.next);

            if(node==tail){
                //dp nothing
            }
            else{
                node.next.next = node;
            }
            if(node.next == head.next)
            {
                head.next = null;
                Node temp = head;
                head = tail;
                tail= temp;
            }
        }

        void reverseDataRecursiveHelper(Node node , int count)
        {
            if(node==null)
            {
                return;
            }

            reverseDataRecursiveHelper(node.next , count+1);            
            if(count >= size/2)
            {
                int temp = node.data;
                node.data = rleft.data;
                rleft.data = temp;
                rleft = rleft.next;                
            }
            return;
        }

        Node rleft;
        void reverseDataRecursive()
        {
            rleft = head;
            reverseDataRecursiveHelper(head,0);
        }

        
        boolean IsPDhelper(Node node, int count)
        {
            if(node==null)
            {
                return true;
            }
            boolean ans = IsPDhelper(node.next, count+1);
            if(ans==false)
            {
                return false;
            }
            else if(count>=size/2)            
            {
                if(node.data != rleft.data)
                {
                    return false;
                }
                else{
                    rleft = rleft.next;
                    return true;
                }
            }
            return true;
        }

        boolean IsPalindrome()
        {
            rleft = head;
            return(IsPDhelper(head,0));
        }


        void foldHelper(Node node , int count)
        {
            if(node == null)
            {
                return;
            }
            foldHelper(node.next, count +1);            
            if(count > size/2)
            {
                Node temp = rleft.next;
                rleft.next = node;
                node.next = temp;
                rleft = temp;                
            }     
            else if(count==size/2)
            {
                tail = node;
                tail.next = null;                
            }                        
        }
        
        void fold()
        {
            rleft = head;
            foldHelper(head, 0);
            
        }
        int carry = 0;

        LinkedList addTwoLLHelper(Node node1, int data1, Node node2, int data2)
        {
            if(node1==null && node2 == null)
            {
                LinkedList ans=  new LinkedList();
                return ans;
            }
            LinkedList mres = addTwoLLHelper(node1.next, node1.data, node2.next, node2.data);
            int k = node1.data + node2.data + carry;                        
            carry = k/10;
            k = k%10;
            mres.addFirst(k);            
            return mres;
        }

        void addTwoLL(LinkedList list1, LinkedList list2)
        {
            // int s1 = Math.abs(list1.size - list2.size);
            LinkedList ans = addTwoLLHelper(list1.head, list1.head.data, list2.head , list2.head.data);
            if(carry!=0)
                ans.addFirst(carry);
            ans.print();
        }

        void print() {
            if (size == 0) {
                System.out.println("Empty Linked List");
            } else {
                Node temp = new Node();
                temp = head;
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
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

        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            list.addLast(arr[i]);
            list2.addLast(arr[i]+1);
        }
        scn.close();

        list.print();
        // list.removeLast();
        // list.print();
        // list.addLast(6);
        // list.print();
        // list.addLast(7);
        // list.print();
        // list.removeLast();
        // list.print();

        // list.reverseDataIterative();
        // list.print();
        // list.reversePointerIterative();
        // list.print();        
        // list.removeAtIndex(1);
        // list.print();

        
        // LinkedList ans = list.merge_sort(list.head, list.tail);
        // ans.print();

        
        // list.oddeven();
        // list.print();
        // list.removeDuplicate();
        // list.print();


        // list.kreverse(3);
        // list.print();        
        // list.displayReverse(list.head);
        // System.out.println();
        // list.print();
        
        // list.addLast(45);
        // list.print();
        // list.addFirst(43);
        // list.print();
        // list.reversePointerRecursion(list.head);        
        // list.print();

        // list.reverseDataRecursive();
        // list.print();

        // System.out.println(list.IsPalindrome());
        // list.fold();
        // list.print();

        list2.print();
        list.addTwoLL(list,list2);
        
        
    }
}
