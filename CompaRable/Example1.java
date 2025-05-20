package CompaRable;
import java.util.ArrayList;
import java.util.Collections;
//Here we will see the example of the comparable class
class Employee implements Comparable<Employee>{
    String name;
    int sal;
    int ser_no;
    public Employee(String name,int sal,int ser_no){
        this.name=name;
        this.sal=sal;
        this.ser_no=ser_no;
    }
    @Override
    //Return 1  -> If ser_no of this employee is greater then passed employee
    //Return -1 -> If ser_no of this employee is less then passed employee
    //Return 0  -> If ser_no of this employee is Equal to passed employee
    public int compareTo(Employee e){
        //return this.ser_no-e.ser_no;//To sort in ascending order
        return e.ser_no-this.ser_no;//To sort in descending order
    }
    @Override
    public String toString(){
        return "Name :- "+this.name+" | Salary :- "+this.sal+" | S_Number :- "+this.ser_no;
    }
}
public class Example1{
    public static void main(String[]args){
        ArrayList<Employee> emp=new ArrayList<>();
        emp.add(new Employee("Kon",2000,3));
        emp.add(new Employee("Hai",3000,1));
        emp.add(new Employee("Employee",4000,2));
        Collections.sort(emp);
        for(var e:emp){
            System.out.println(e);
        }
    }
}
