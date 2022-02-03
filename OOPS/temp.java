// name: patel vinitkumar dipakbhai
// sheridan id: 991650701

import java.util.*;
import java.io.*;

class Commission {
    private String fname;
    private String lname;
    private String ssnumber;
    private Double grosssales;
    private Double commrate;

    Commission(String fname, String lname, String ssnumber, Double grosssales, Double commrate) {
        this.fname = fname;
        this.lname = lname;
        this.ssnumber = ssnumber;
        this.grosssales = grosssales;
        this.commrate = commrate;
    }

    public Double earning() {
        return (grosssales * commrate * 1.0 / 100);
    }

    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getSsnumber() {
        return ssnumber;
    }
    public Double getGrosssales() {
        return grosssales;
    }
    public Double getCommrate() {
        return commrate;
    }    
}

class BaseCommission extends Commission {
    Double basicsalary;

    BaseCommission(String fname, String lname, String ssnumber, Double grosssales, Double commrate, Double basicsalary) {
        super(fname, lname, ssnumber, grosssales, commrate);
        this.basicsalary = basicsalary;
    }

    Double countSalary(Double basicsalary) {
        return (this.basicsalary + this.earning());
    }

    void tostring()
    {
        String fname = this.getFname();
        String lname = this.getLname();        
        String ssnumber = this.getSsnumber();
        Double grosssales = this.getGrosssales();
        Double commrate = this.getCommrate();
        System.out.println("employee's first name: " + fname);
        System.out.println("employee's last name: " + lname);
        System.out.println("employee's social security number: " + ssnumber);
        System.out.println("employee's gross sales: $" + grosssales);
        System.out.println("employee's commission rate: " + commrate + "%");
        System.out.println("employee's basic salary: $" + basicsalary);
        System.out.println("employee's total earning: $" + this.earning());
        System.out.println("employee's total salary: $" + this.countSalary(basicsalary));
    }
    
}

public class temp {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in); // declare scanner
        System.out.println("Please enter employee's first name : ");
        String fname = scn.next();
        System.out.println("Please enter employee's last name: ");
        String lname = scn.next();
        System.out.println("Please enter employee's social security number: ");        
        String ssnumber = scn.next();
        System.out.println("Please enter employee's gross sales: ");
        Double grosssales = scn.nextDouble();
        System.out.println("Please enter employee's commission rate: ");
        Double comrate = scn.nextDouble();
        System.out.println("Please enter employee's basic salary: ");
        Double basicsalary = scn.nextDouble();
        
        BaseCommission Emp = new BaseCommission(fname, lname, ssnumber, grosssales, comrate, basicsalary);

        Emp.tostring();       
        scn.close();

    }

    
    
}
