import java.util.*;
// import java.lang.*;

public class GERGOVIA {   
    public static class Pair
    {
        int val;
        int idx;

        Pair(int val, int idx)
        {
            this.val = val;
            this.idx = idx;        
        }
    } 
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);                
        int n = scn.nextInt();
        while(true)
        {                        
            ArrayList<Pair> parr = new ArrayList<>();
            ArrayList<Pair> narr = new ArrayList<>();

            for(int i=0; i<n; i++)            
            {
                int v = scn.nextInt();
                if(v>0)
                {
                    parr.add(new Pair(v,i));
                }
                else
                {
                    narr.add(new Pair(v, i));
                }
            }
            
            int i=0;
            int j=0;
            long ans = 0;
            while(i<parr.size() && j<narr.size())
            {
                int x = Math.min(parr.get(i).val, -narr.get(j).val);
                parr.get(i).val -= x;
                narr.get(j).val += x;
                int diff = Math.abs(parr.get(i).idx - narr.get(j).idx);
                ans += (x * diff);
                if (parr.get(i).val == 0)
                    i++;
                if (narr.get(j).val == 0)
                    j++;
            }
            System.out.println(ans);
            n = scn.nextInt();
            if (n == 0)
                break;

        }
        scn.close();
        return;
    }
}