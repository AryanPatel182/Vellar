import java.util.*;
import java.io.*;


public class Compar {
    public static class Paiir    
    {
        int val;
        String name;     
        
        Paiir(int val, String name)   
        {
            this.val =val;
            this.name = name;
        }
    }
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        ArrayList<Paiir> arr = new ArrayList<>();
        arr.add(new Paiir(21,"Aryan"));
        arr.add(new Paiir(31,"yan"));
        arr.add(new Paiir(2,"An"));
        arr.add(new Paiir(1,"Aan"));
        arr.add(new Paiir(10,"yan"));
        arr.add(new Paiir(14,"ryan"));

        int[][] array = {{1,2},{2,4},{1,3}};
        
        
        Comparator<Paiir> p = new Comparator<Paiir>()
        {
            public int compare(Paiir p1, Paiir p2) 
            {
                return (p2.val - p1.val);
            }
        };

        Comparator<int[]> q = new Comparator<int[]>()
        {
            public int compare(int[] p1, int[] p2)
            {
                if(p1[0]>p2[0])
                {
                    return 1;
                }
                else if(p1[0]<p2[0])
                {
                    return -1;
                }
                else
                {
                    return p2[1]-p1[1];
                }
            }
        };

        Collections.sort(arr,p);
        Arrays.sort(array, q);

        for(Paiir pn:arr)
        {
            System.out.println(pn.name + " "+ pn.val);
        }


        System.out.println();
        for(int[] val:array)
        {
            for(int k:val)
            {
                System.out.print(k+" ");                
            }
            System.out.println();
        }

        scn.close();
    }
    
}
