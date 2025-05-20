package CompaRable;
import java.util.ArrayList;
import java.util.Collections;
//It is used to enable sorting in java class objects on the basis of a parameter
//Here we will see the comparable interface of java

//The class without Comparable interface
//We cannot sort the array of objects created by this class
class Student{
    String name;
    int roll_no;
    public Student(String name,int roll_no){
        this.name=name;
        this.roll_no=roll_no;
    }
}
//The class with comparable interface
//The array of objects created with this class can be sorted
class Student2 implements Comparable<Student2>{
    String name;
    int roll_no;
    public Student2(String name,int roll_no){
        this.name=name;
        this.roll_no=roll_no;
    }
    @Override
    public int compareTo(Student2 st){
        return this.roll_no-st.roll_no;

    }
}
public class ComParaBle {
    public static void main(String[]args){
        ArrayList<Student> stu=new ArrayList<>();
        ArrayList<Integer> stu2=new ArrayList<>();
        ArrayList<Student2>stu3=new ArrayList<>();
        stu3.add(new Student2("Shiv",3));
        stu3.add(new Student2("Vim",1));
        stu3.add(new Student2("Mil",2));
        stu2.add(2);
        stu2.add(3);
        stu2.add(1);
        stu.add(new Student("Shiv",3));
        stu.add(new Student("Vim",1));
        stu.add(new Student("Mil",2));
        //This will not give error because we can sort the array of object of class created using Comparable interface
        Collections.sort(stu3);
        Collections.sort(stu2);//This will not givve error
        //Collections.sort(stu);//This will generate the error becasuse we cannot sort AL of class object using sort method
        //Without implementing sort method
        for(var i:stu3){
            System.out.println("Name :- "+i.name+" | RollNo :- "+i.roll_no);
        }
    }
}
