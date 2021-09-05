import java.util.*;
import java.io.*;

public class ConsistencyChapter1 {		
	public static void main(String[] args) throws Exception
	{
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

		int t = scn.nextInt();
        int k=1;
        while(t -- >0)
        {
            String s = scn.next();

            int vow = 0;
            int cons = 0;
            int vowmax = Integer.MIN_VALUE;
            int consmax = Integer.MIN_VALUE;
            HashMap<Character, Integer> vowels = new HashMap<>();
            HashMap<Character, Integer> consonent = new HashMap<>();

            for(int i=0; i<s.length(); i++)            
            {
                char ch = s.charAt(i);
                if(ch == 'A' || ch=='E' || ch == 'I' || ch == 'O' || ch == 'U' )
                {
                    vowels.put(ch, vowels.getOrDefault(ch, 0)+1);
                    vowmax = Math.max(vowmax, vowels.get(ch));
                    vow+=1;
                }
                else
                {
                    consonent.put(ch, consonent.getOrDefault(ch, 0)+1);
                    consmax = Math.max(consmax, consonent.get(ch));
                    cons+=1;
                }
            }
            
            int ans = Math.min((vow-vowmax)*2 + cons , (cons-consmax)*2 + vow);

            System.out.println("Case #"+k+": "+ans);
            k+=1;
        }
        scn.close();
	}
}


