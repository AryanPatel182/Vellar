import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Homecoming {
    public static void print(int[] arr) {

        for(int i=1; i<arr.length; i++)
        {
            System.out.print(arr[i]+ " ");
        }

        System.out.println();
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vts = scn.nextInt();
        int n = scn.nextInt();

        int[] arr = new int[vts + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);        
        arr[1] = 0;

        int[][] temp = new int[n][3];
        for(int i=0; i<n; i++)
        {
            temp[i][0] = scn.nextInt();
            temp[i][1] = scn.nextInt();
            temp[i][2] = scn.nextInt();
        }

        for(int j=0;j<n; j++)
        {
            // print(arr);
            for (int i = 0; i<n; i++) {
                int st = temp[i][0];
                int dt = temp[i][1];
                int wt = temp[i][2];
                if(arr[st]!= Integer.MAX_VALUE)
                {
                    if (arr[st] + (j+1)*wt < arr[dt])
                    {                        
                        arr[dt] = arr[st] + (j+ 1) * wt;
                    }
                }
                
                if(arr[dt] != Integer.MAX_VALUE)
                {
                    if (arr[dt] + (j+1)*wt < arr[st])
                    {                        
                        arr[st] = arr[dt] + (j + 1) * wt;
                    }
                }
                
            }
        }
        
        for(int i=1; i<=vts; i++)
        {
            System.out.println(arr[i] == Integer.MAX_VALUE ? -1 : arr[i] + " ");
        }
        // Your code here

        scn.close();
    }
}