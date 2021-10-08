import java.util.*;

public class CN {
	static Scanner scn = new Scanner(System.in);    
	
	public static void main(String[] args) 
	{
        // your code goes here
        double alpha = 0.125;
        double beta = 0.25;

        double cdev = (double)scn.nextDouble();
        double cest = (double)scn.nextDouble();

        double est_inp1 = scn.nextDouble();        

        double new_est = (1-alpha)*cest + alpha*est_inp1;
        double new_cdev = (1-beta)*cdev + beta*Math.abs(new_est - cest);
        System.out.println(cest);
        System.out.println(new_est);
        System.out.println(Math.abs(new_est - cest));
        System.out.println(beta*Math.abs(new_est - cest));
        System.out.println(new_est);
        System.out.println(new_cdev);
	}
}


