import java.util.*;

public class BoringSegments {
	static Scanner scn = new Scanner(System.in);    
	
	public static void main(String[] args) 
	{
		int n = scn.nextInt();
		int m = scn.nextInt();

		int[][] arr = new int[n][3];

		for(int i=0; i<n; i++)
		{
			arr[i][0] = scn.nextInt();
			arr[i][1] = scn.nextInt();
			arr[i][2] = scn.nextInt();
		}
	}
}