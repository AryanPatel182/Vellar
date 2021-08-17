import java.util.*;

public class InterestingStory {
    static Scanner scn = new Scanner(System.in);

    public static int find(String[] words, char ch)
    {
        int n = words.length;
        Integer[] frq_dif = new Integer[n];

        for(int i=0; i<n; i++)
        {
            int count = 0;
            for(int j=0; j<words[i].length(); j++)            
            {
                if(words[i].charAt(j) == ch)
                {
                    count+=1;
                }
            }
            frq_dif[i] = count - (words[i].length()-count);
        }

        Arrays.sort(frq_dif, Collections.reverseOrder());
        int count = 0;
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum+= frq_dif[i];
            if(sum > 0)
            {
                count+=1;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int t = scn.nextInt();
        
        while(t-- > 0)
        {
            int n = scn.nextInt();
            String[] words = new String[n];

            for(int i=0; i<n; i++)
            {
                words[i] = scn.next();
            }
            int max = Integer.MIN_VALUE;
            int a = find(words,'a');
            max = Math.max(max,a);
            int b = find(words,'b');
            max = Math.max(max, b);
            int c = find(words,'c');
            max = Math.max(max, c);
            int d = find(words,'d');
            max = Math.max(max, d);
            int e = find(words,'e');
            max = Math.max(max,e);

            System.out.println(max);
        } 

    }
}