import java.util.*;

public class InfinityTable {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scn.nextInt();
        ArrayList<Integer> spt = new ArrayList<>();
        ArrayList<Integer> ept = new ArrayList<>();
        int sp = 1;
        int ep = 1;
        spt.add(1);
        ept.add(1);            
        int gap = 3;
        while(sp<= 1000000000 || ep<=1000000000)
        {
            sp = ep+1;
            ep = ep+gap;
            spt.add(sp);
            ept.add(ep);
            gap+=2;
        }

        int idx=  0;
        while(t-->0)
        {
            int n = scn.nextInt();
            for(int i=0; i<spt.size(); i++)
            {
                if(spt.get(i) <= n && ept.get(i) >= n)
                {
                    idx = i;
                    break;
                }
            }

            int mid = (ept.get(idx) - spt.get(idx))/2;

            int midel = spt.get(idx) + mid;

            if(n==midel)
            {
                System.out.println((idx+1) + " " + (idx+1));
            }
            else if(n>midel)
            {
                System.out.println((idx+1) + " " + (idx+1 - (n-midel)));
            }
            else
            {
                System.out.println((idx+1 - (midel-n)) + " " + (idx +1));
            }
        }
    }
}