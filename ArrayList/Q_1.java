package ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Here we will reverse the ArrayList
public class Q_1 {
    static void revers(ArrayList<Integer>arr){
        System.out.println("Reverseing the arrayList...");
        int i=0,j=arr.size()-1;
        while(i<j){
            int temp=arr.get(j);
            arr.set(j,arr.get(i));
            arr.set(i,temp);
            i++;
            j--;
        }
    }
    public static void main(String[]args){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);
        revers(arr);
        System.out.println(arr);
        //Sorting the array in accending order
        Collections.sort(arr);
        System.out.println(arr);
        //To sort in decending order
        Collections.sort(arr,Collections.reverseOrder());
        System.out.println(arr);

    }
}
