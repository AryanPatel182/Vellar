import java.util.*;

public class SubsequencePermutation {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();
        while(t-->0)
        {
            int n=scn.nextInt();
            String s = scn.next();
            char tempArray[] = s.toCharArray();

            Arrays.sort(tempArray);
            int count = 0;
            for(int i=0;i<n;i++)
            {
                if(s.charAt(i) == tempArray[i])
                {
                    count+=1;
                }
            }

            System.out.println(n-count);
        }
    }
}