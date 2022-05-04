package domain;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String Fname;
    private String Lname;
    private String Ssn;
    private int Salary;
    private String address;
    private String Sex;
    private LocalDate Bdate;
    private int Dno;
    private String Minit;
    private String Super_ssn;

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getSsn() {
        return Ssn;
    }

    public void setSsn(String ssn) {
        Ssn = ssn;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public LocalDate getBdate() {
        return  Bdate;
    }

    public void setBdate(LocalDate bdate) {
        Bdate = bdate;

    }

    public int getDno() {
        return Dno;
    }

    public void setDno(int dno) {
        Dno = dno;
    }

    public String getMinit() {
        return Minit;
    }

    public void setMinit(String minit) {
        Minit = minit;
    }
    public String getSuper_ssn() {
        return Super_ssn;
    }

    public void setSuper_ssn(String super_ssn) {
        Super_ssn = super_ssn;
    }

    public Employee(String fname, String lname, String ssn, int salary, String address, char sex, LocalDate bdate, int dno, char minit,String super_ssn) {
        Fname = fname;
        Lname = lname;
        Ssn = ssn;
        Salary = salary;
        this.address = address;
        Sex = String.valueOf(sex);
        Bdate = bdate;
        Dno = dno;
        Minit = String.valueOf(minit);
        Super_ssn=super_ssn;
    }
    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee:"+Fname+" "+Lname+" "+Ssn+" "+Salary+" "+address+" "+Bdate+" "+Dno+" "+Minit+" "+Super_ssn;
    }
}
