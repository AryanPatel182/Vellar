import java.util.*;
import java.io.*;

public class BusRoutes {
    
    public static void main(String[] args) throws Exception {
        File input = new File("input.txt"); // declare input
        File output = new File("output.txt");
        Scanner scn = new Scanner(input); // declare scanner
        PrintStream stream = new PrintStream(output);
        System.setOut(stream);
                
    
        int n = scn.nextInt();
        int m = scn.nextInt();
        int max = Integer.MIN_VALUE;
        int[][] arr= new int[n][m];

        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        
        for(int i=0; i<n; i++)
        {            
            for(int j= 0;  j<m; j++)
            {                
                arr[i][j] = scn.nextInt();                
                hmap.put(arr[i][j], new ArrayList<>());
                max = Math.max(arr[i][j], max);
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                hmap.get(arr[i][j]).add(i);
            }
        }

        int source = scn.nextInt();
        int dest = scn.nextInt();

        boolean visbus[] = new boolean[n];
        boolean visstop[] = new boolean[max+1];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(source);
        int ans = -1;        
        int level = 0;
        while(queue.size() > 0)
        {            
            int size = queue.size();

            while(size -- > 0)
            {                
                int rm = queue.remove();
                if(rm == dest)
                {
                    ans = level;
                    break;
                }          
                visstop[rm] = true;
                
                ArrayList<Integer> nbrs = hmap.get(rm);
                for(int i=0; i<nbrs.size(); i++)
                {
                    int bus = nbrs.get(i);
                    if(visbus[bus] != true)
                    {                    
                        for(int j=0; j<arr[bus].length; j++)
                        {
                            if(visstop[arr[bus][j]] != true)
                            {
                                
                                queue.add(arr[bus][j]);
                                
                                visstop[arr[bus][j]]= true;
                            }
                        }
                        visbus[bus] = true;
                    }
                }
            }
            level += 1;
        }

        System.out.println(ans);
        scn.close();

    }
}
