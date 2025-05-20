package HashMap;
import java.util.*;
//Here we will se the doubts int the implementation of the hashmap
public class PRactice {
    public static void main(String[]args){
        LinkedList<Integer>[] bucket;//Here we have declared the array of linkedlist of Integer
        //bucket=new LinkedList
        bucket=new LinkedList[5];//Here we have initialize the size of the array
        System.out.println(bucket);
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new LinkedList<>();
        }
        for(int i=0;i< bucket.length;i++){
            System.out.println(bucket[i]);
        }
        LinkedList<Integer> nl=new LinkedList<>();
        nl.add(1);
        nl.add(2);
        nl.add(3);
        nl.add(4);
        System.out.println(nl.size());
        System.out.println(nl.get(1));
        System.out.println(nl.remove(1));


    }
}
