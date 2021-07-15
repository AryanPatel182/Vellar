import java.util.*;
import java.io.*;

public class MinimumNumberOfDevelopers {
    public static ArrayList<Integer> oans = new ArrayList<>();
    public static void Developers(int[] people, int n, int cp, ArrayList<Integer> onesol, int smask) 
    {
        if(cp==people.length)        
        {
            if(smask == ((1<<n) -1))
            {
                if(oans.size() == 0 || onesol.size()< oans.size())            
                {
                    oans = new ArrayList<>(onesol);
                }
            }
            return;
        }

        Developers(people, n, cp+1, onesol, smask);

        onesol.add(cp);
        Developers(people, n, cp+1, onesol, (smask | people[cp]));

        onesol.remove(onesol.size()-1);
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        HashMap<String, Integer> skills = new HashMap<>();

        for(int i = 0 ; i<n ; i++)
        {
            skills.put(scn.next(), i);
        }

        int p = scn.nextInt();
        int[] people = new int[p];
        for(int i = 0 ; i<p ; i++)
        {
            int ns = scn.nextInt();
            for(int j=0; j<ns; j++)
            {
                String s = scn.next();
                int idx = skills.get(s);
                people[i] = people[i] | ((1<<idx));
                System.out.println(Integer.toBinaryString(people[i]));
            }
        }

        scn.close();
        Developers(people, n, 0, new ArrayList<>() , 0);
        System.out.println(oans);

    }
}
