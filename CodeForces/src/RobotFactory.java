import java.util.*;

public class RobotFactory {
    static Scanner scn = new Scanner(System.in);

    static ArrayList<Integer> ans = new ArrayList<>();

   static class Pair
   {
        int i;
        int j;
        int val;

        Pair(int i, int j, int val)
        {
            this.i = i;
            this.j = j;
            this.val = val;
        }
   }


    public static int dfshelper(int[][] arr, int i, int j, boolean[][] visited,int util)
    {        

        visited[i][j] = true;
        int c1 = 0 ; int c2 =0; int  c3  = 0 ; int  c4 = 0;
        
        // top  
        int rdash = i-1;
        int cdash = j;
        if (rdash >= 0 && cdash >=0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] != true) 
        {
            int val1 = arr[i][j];
            int val2 = arr[rdash][cdash];

            if (((val1 & 16) == 0) && ((val2 & 2) == 0))
            {                
                c1 = dfshelper(arr, rdash, cdash, visited,1);
            }
        }  

             
        // right        
        rdash = i + 0;
        cdash = j + 1;
        if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] == false) 
        {
            int val1 = arr[i][j];
            int val2 = arr[rdash][cdash];
            if (((val1 & 4) == 0) && ((val2 & 1) == 0)) 
            {                
                c2 = dfshelper(arr, rdash, cdash, visited, 2);
            }
        }

        // down
        rdash = i + 1;
        cdash = j + 0;
        if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] != true) {
            int val1 = arr[i][j];
            int val2 = arr[rdash][cdash];

            if (((val2 & 16) == 0) && ((val1 & 2) == 0))
            {
                c3 = dfshelper(arr, rdash, cdash, visited, 1);
            }
        }
        
        // left        
        rdash = i + 0;
        cdash = j - 1;
        if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] == false) {
            int val1 = arr[i][j];
            int val2 = arr[rdash][cdash];
            if (((val2 & 4) == 0) && ((val1 & 1) == 0)) 
            {
                c4 = dfshelper(arr, rdash, cdash, visited, 2);
            }
        }    
        
        return (c1+c2+c3+c4+1);
    
    }
    
    
    public static void dfs(int[][] arr , boolean[][] visited)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                if(visited[i][j] == false)
                {
                    int temp = dfshelper(arr, i, j, visited, 0);                    
                    ans.add(temp);
                }
            }
        }        
    }

    




    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr= new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                arr[i][j] = scn.nextInt();                
            }
        }

        dfs(arr,visited);
        Collections.sort(ans, Collections.reverseOrder());
        for(int i=0; i<ans.size(); i++)
        {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
















//////////////////////////////////////////////////////////////










// import java.util.*;

// public class RobotFactory {
//     static Scanner scn = new Scanner(System.in);

//     static ArrayList<Integer> ans = new ArrayList<>();

//     static class Pair {
//         int i;
//         int j;
//         int val;

//         Pair(int i, int j, int val) {
//             this.i = i;
//             this.j = j;
//             this.val = val;
//         }
//     }
//     // 4 5
//     // 9 14 11 12 13
//     // 5 15 11 6 7
//     // 5 9 14 9 14
//     // 3 2 14 3 14

//     public static int dfshelper(int[][] arr, int i, int j, boolean[][] visited, int util) {

//         visited[i][j] = true;
//         int c1 = 0;
//         int c2 = 0;
//         int c3 = 0;
//         int c4 = 0;

//         // top
//         int rdash = i - 1;
//         int cdash = j;
//         if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] != true) {
//             int val1 = arr[i][j];
//             int val2 = arr[rdash][cdash];

//             if (((val1 & 16) == 0) && ((val2 & 2) == 0)) {
//                 c1 = dfshelper(arr, rdash, cdash, visited, 1);
//             }
//         }

//         // right
//         rdash = i + 0;
//         cdash = j + 1;
//         if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] == false) {
//             int val1 = arr[i][j];
//             int val2 = arr[rdash][cdash];
//             if (((val1 & 4) == 0) && ((val2 & 1) == 0)) {
//                 c2 = dfshelper(arr, rdash, cdash, visited, 2);
//             }
//         }

//         // down
//         rdash = i + 1;
//         cdash = j + 0;
//         if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] != true) {
//             int val1 = arr[i][j];
//             int val2 = arr[rdash][cdash];

//             if (((val2 & 16) == 0) && ((val1 & 2) == 0)) {
//                 c3 = dfshelper(arr, rdash, cdash, visited, 1);
//             }
//         }

//         // left
//         rdash = i + 0;
//         cdash = j - 1;
//         if (rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && visited[rdash][cdash] == false) {
//             int val1 = arr[i][j];
//             int val2 = arr[rdash][cdash];
//             if (((val2 & 4) == 0) && ((val1 & 1) == 0)) {
//                 c4 = dfshelper(arr, rdash, cdash, visited, 2);
//             }
//         }

//         return (c1 + c2 + c3 + c4 + 1);

//     }
//     // public static int dfshelper(int[][] arr, int i, int j, boolean[][]
//     // visited,int util)
//     // {
//     // // System.out.println(i+ " " + j);
//     // if(i<0 || j<0 || i>=arr.length || j >=arr[0].length || visited[i][j] == true)
//     // {
//     // return 0;
//     // }
//     // System.out.println(arr[i][j] + " " + util);
//     // visited[i][j] = true;

//     // if(util == 1)
//     // {
//     // int val1 = arr[i+1][j];
//     // int val2 = arr[i][j];

//     // if ((val1 & 16) == 1 || (val2 & 2) == 1)
//     // {
//     // visited[i][j] = false;
//     // return 0;
//     // }
//     // }
//     // else if(util == 2)
//     // {
//     // int val1 = arr[i][j-1];
//     // int val2 = arr[i][j];
//     // if ((val1 & 4) == 1 || (val2 & 1) == 1)
//     // {
//     // visited[i][j] = false;
//     // return 0;
//     // }
//     // }
//     // else if (util == 3)
//     // {
//     // int val1 = arr[i-1][j];
//     // int val2 = arr[i][j];

//     // if ((val2 & 16) == 1 || (val1 & 2) == 1) {
//     // visited[i][j] = false;
//     // return 0;
//     // }
//     // }
//     // else if(util == 4)
//     // {
//     // int val1 = arr[i][j + 1];
//     // int val2 = arr[i][j];
//     // if ((val2 & 4) == 1 || (val1 & 1) == 1) {
//     // visited[i][j] = false;
//     // return 0;
//     // }
//     // }

//     // // top
//     // int c1 = dfshelper(arr, i-1, j, visited,1);
//     // // right
//     // int c2 = dfshelper(arr, i, j+1, visited,2);
//     // // down
//     // int c3 = dfshelper(arr, i+1, j, visited,3);
//     // // left
//     // int c4 = dfshelper(arr, i, j-1, visited,4);

//     // return (c1+c2+c3+c4+1);

//     // }

//     public static void dfs(int[][] arr, boolean[][] visited) {
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[i].length; j++) {
//                 if (visited[i][j] == false) {
//                     int temp = dfshelper(arr, i, j, visited, 0);
//                     ans.add(temp);
//                 }
//             }
//         }

//     }

//     // public static void dfs(int[][] arr , boolean[][] visited)
//     // {
//     // int n = arr.length;
//     // int m = arr[0].length;

//     // for(int i=0; i<n; i++)
//     // {
//     // for(int j=0; j<m; j++)
//     // {
//     // if(visited[i][j] != true)
//     // {
//     // Stack<Pair> st = new Stack<>();
//     // st.add(new Pair(i, j, arr[i][j]));

//     // int count = 0;
//     // while (st.size() > 0) {
//     // Pair rm = st.pop();
//     // count += 1;
//     // if (visited[rm.i][rm.j] == true) {
//     // continue;
//     // }

//     // visited[rm.i][rm.j] = true;

//     // // System.out.println(rm.v + "@" + rm.psf);

//     // // top
//     // int rdash = rm.i + -1;
//     // int cdash = rm.j + 0;
//     // if (rdash >= 0 && cdash >= 0 && rdash < n && cdash < m &&
//     // visited[rdash][cdash] == false) {
//     // int val1 = rm.val;
//     // int val2 = arr[rdash][cdash];
//     // if ((val1 & 16) == 0 && (val2 & 2) == 0) {
//     // st.push(new Pair(rdash, cdash, arr[rdash][cdash]));
//     // }
//     // }

//     // // right
//     // rdash = rm.i + 0;
//     // cdash = rm.j + 1;
//     // if (rdash >= 0 && cdash >= 0 && rdash < n && cdash < m &&
//     // visited[rdash][cdash] == false) {
//     // int val1 = rm.val;
//     // int val2 = arr[rdash][cdash];
//     // if ((val1 & 4) == 0 && (val2 & 1) == 0) {
//     // st.push(new Pair(rdash, cdash, arr[rdash][cdash]));
//     // }
//     // }

//     // // down
//     // rdash = rm.i + 1;
//     // cdash = rm.j + 0;
//     // if (rdash >= 0 && cdash >= 0 && rdash < n && cdash < m &&
//     // visited[rdash][cdash] == false) {
//     // int val1 = rm.val;
//     // int val2 = arr[rdash][cdash];
//     // if ((val2 & 16) == 0 && (val1 & 2) == 0) {
//     // st.push(new Pair(rdash, cdash, arr[rdash][cdash]));
//     // }
//     // }

//     // // left
//     // rdash = rm.i + 0;
//     // cdash = rm.j - 1;
//     // if (rdash >= 0 && cdash >= 0 && rdash < n && cdash < m &&
//     // visited[rdash][cdash] == false) {
//     // int val1 = rm.val;
//     // int val2 = arr[rdash][cdash];
//     // if ((val2 & 4) == 0 && (val1 & 1) == 0) {
//     // st.push(new Pair(rdash, cdash, arr[rdash][cdash]));
//     // }
//     // }
//     // }
//     // ans.add(count);
//     // }
//     // }
//     // }

//     // }

//     public static void main(String[] args) {
//         int n = scn.nextInt();
//         int m = scn.nextInt();

//         int[][] arr = new int[n][m];
//         boolean[][] visited = new boolean[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 arr[i][j] = scn.nextInt();
//             }
//         }

//         dfs(arr, visited);
//         Collections.sort(ans, Collections.reverseOrder());
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.print(ans.get(i) + " ");
//         }
//         System.out.println();
//     }
// }





