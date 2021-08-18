import java.util.*;

public class DIslikeOfThrees {
	static Scanner scn = new Scanner(System.in);    
	
	public static void main(String[] args) 
	{
        int t = scn.nextInt();
        int size = 1;
        int i=1;
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(0);
        while(size<=1001)
        {
            if(i%3 == 0 || i%10 == 3)
            {
                i+=1;
            }   
            else
            {
                seq.add(i);
                size += 1;
                i+=1;
            }
        }
        while(t-- > 0)
        {
            int k = scn.nextInt();
            System.out.println(seq.get(k));
        }
		
	}
}