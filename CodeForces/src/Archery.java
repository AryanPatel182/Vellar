import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Archery {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];

            HashMap<Integer, Integer> hmap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
                hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
            }
            
            int count = 0;
            for (int i : hmap.keySet()) {
                if (hmap.get(i) >= k) {
                    count += 1;
                    n = n - hmap.get(i);
                }
            }            

            count += Math.ceil((double)n/(double)k);
            

            System.out.println(count);
            scn.close();
        }
        // Your code here
    }
}