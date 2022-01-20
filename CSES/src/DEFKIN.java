import java.util.*;
import java.lang.*;

public class DEFKIN {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {
            int w = scn.nextInt();
            int h = scn.nextInt();
            int n = scn.nextInt();

            ArrayList<Integer> rows = new ArrayList<>();
            ArrayList<Integer> cols = new ArrayList<>();

            rows.add(0);
            cols.add(0);
            for (int i = 0; i < n; i++) {
                rows.add(scn.nextInt());
                cols.add(scn.nextInt());
            }
            rows.add(w+1);
            cols.add(h+1);
            Collections.sort(rows);
            Collections.sort(cols);

            int rmax = 0;
            int cmax = 0;

            for (int i = 0; i < rows.size() -1; i++) {
                rmax = Math.max(rmax, rows.get(i+1) - rows.get(i) - 1);
                cmax = Math.max(cmax, cols.get(i+1) - cols.get(i) - 1);
            }           

            System.out.println(rmax*cmax);
        }
        scn.close();
    }
}