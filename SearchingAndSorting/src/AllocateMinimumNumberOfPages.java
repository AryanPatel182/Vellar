import java.util.*;
import java.io.*;

public class AllocateMinimumNumberOfPages {
    public static boolean isPossible(int[] arr, int n, int mid, int m) {
        int sum = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > mid) {
                count += 1;
                sum = arr[i];
            }
        }

        if (count <= m) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            max = Math.max(max, arr[i]);
        }
        int ans = -1;

        int l = max;
        int h = sum;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (isPossible(arr, n, mid, m)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        scn.close();
        System.out.println(ans);

    }
}
