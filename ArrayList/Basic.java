package ArrayList;

import java.util.ArrayList;

//Here we will se the basic methods of arraylist
public class Basic {
    public static void main(String[]args){
        //Here we have declared the array list of integer datatype
        ArrayList<Integer> arr=new ArrayList<>();
        //Adding element
        //this will add element to end of the array
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        //Printing the arrayList using for loop
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        //Printing ArrayList directly using println Method
        System.out.println(arr);
        // Adding element at the particular index of an array
        //This will add 100 at the index 1 of ArrayList arr
        arr.add(1,100);
        System.out.println(arr);
        //Getting element of an arrayList
        //This will fetch the item at index 2
        System.out.println(arr.get(2));
        //Getting element using Value
        //This will print the index of 2 in arrayList
        System.out.println(arr.get(Integer.valueOf(2)));
        //Getting the size of the arraylist
        System.out.println(arr.size());
        //Changing value at particular index
        arr.set(1,90);//This will set the value of index 1 as 90
        System.out.println(arr);
        //Removing the element from the ArrayList
        arr.remove(1);//This will remove the element on the index 1 from the arraylist
        System.out.println(arr);
    }
}
