/* package codechef; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Code {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while (t-- > 0) {
            long n = scn.nextLong();
            HashMap<Long, Long> hmap = new HashMap<>();

            for (long i = 0; i < n; i++) {
                long temp = scn.nextLong();

                if (hmap.containsKey(temp) == true) {
                    hmap.put(temp, hmap.get(temp) + 1);
                } else {
                    hmap.put(temp, 1l);
                }
            }

            long count = 0;

            for(long key : hmap.keySet())
            {
                count+= (n-hmap.get(key))*(hmap.get(key));
            }

            System.out.println(count);
        }
        // your code goes here
        scn.close();
    }
}
