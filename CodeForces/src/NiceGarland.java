import java.util.*;

public class NiceGarland {
    static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        String s = scn.next();
        String[] words = {"RGB","RBG","GRB","GBR","BRG","BGR"};

        String ans = "";
        int min = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++)
        {
            int count = 0;
            for(int j=0; j<s.length(); j++)
            {
                if(s.charAt(j) != words[i].charAt(j%3))
                {
                    count+=1;
                }
            }

            if(count < min)
            {
                min = count;
                ans= words[i];
            }
        }

        System.out.println(min);
        for(int i=0; i<n; i++)
        {
            System.out.print(ans.charAt(i%3));
        }
        return;
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }
}
