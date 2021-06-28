import java.util.*;
import java.io.*;

public class MeetingRooms2 {

    public static int FindTotalMeetingRooms(int[][] arr , int n) {
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);
        
        for(int i = 1 ; i<n ;i++)        
        {
            int top = pq.peek();
            if(arr[i][0] < top)
            {
                pq.add(arr[i][1]);
            }
            else{
                pq.remove();
                pq.add(arr[i][1]);
            }
        }

        return pq.size();
        
    }
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);

        int n = scn.nextInt();

        int[][] arr = new int[n][2];

        for(int i = 0; i< n; i++)
        {
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }

        scn.close();

        int ans = FindTotalMeetingRooms(arr, n);
        System.out.println(ans);

    }
}
