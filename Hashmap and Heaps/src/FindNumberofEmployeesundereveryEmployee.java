import java.util.*;
import java.io.*;

public class FindNumberofEmployeesundereveryEmployee {
    public static void findcount(HashMap<String, String> hmap)
    {
        String ceo ="";
        HashMap<String, HashSet<String>> tree =new HashMap<>();
        for(String key : hmap.keySet())
        {
            String boss = hmap.get(key);
            if(key.equals(boss))
            {
                ceo = key;
            }
            else
            {
                if(tree.containsKey(boss))
                {
                    tree.get(boss).add(key);                    
                }
                else
                {
                    HashSet<String> temp = new HashSet<>();
                    temp.add(key);
                    tree.put(boss,temp);
                }
            }
        }           

        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);

        for(String key : result.keySet())
        {
            System.out.println(key + " : " + result.get(key));
        }
    
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String ceo, HashMap<String, Integer> result)
    {        
        if(tree.containsKey(ceo) == false)
        {
            result.put(ceo, 0);
            return 1;
        }
        int sz = 0;
        for(String emp : tree.get(ceo))
        {
            int cs = getSize(tree, emp, result);
            sz+=cs;
        }
        result.put(ceo, sz);
        
        return sz+1;
    }    

    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();
        HashMap<String,String> hmap = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            hmap.put(scn.next(), scn.next());
        }
        
        findcount(hmap);

        scn.close();

    }
}
