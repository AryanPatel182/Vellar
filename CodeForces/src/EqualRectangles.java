import java.util.*;

public class EqualRectangles {
	static Scanner scn = new Scanner(System.in);    
	
	public static void solve() 
	{
        int n = scn.nextInt();
        int[] arr= new int[4*n];

        for(int i=0; i<4*n; i++)
        {
            arr[i]= scn.nextInt();        
        }

        Arrays.sort(arr);

        int i=0;
        int j=4*n-1;
        long area = arr[i]*arr[j];
        while(i<j)
        {   
            if((arr[i] == arr[i+1]) && (arr[j] == arr[j-1]))
            {
                if(arr[i]*arr[j] != area)
                {
                    System.out.println("NO");
                    return;
                }
                i+=2;
                j-=2;
            }   
            else
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
		return;
	}
	public static void main(String[] args) 
	{
		int t =  scn.nextInt();
		while(t-- > 0)
		{   
			solve();
		}
	}
}


