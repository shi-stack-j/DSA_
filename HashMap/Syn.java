package HashMap;

import java.util.HashMap;

//Here we will see the operations on hashmap class in the collection framework
public class Syn {
    public static void main(String[]args){
        //Here we have declared the hasmap using class in the collection framework util
        HashMap<Integer,String> mp=new HashMap<>();
        //We are adding elements in the hasmap class
        mp.put(1,"Math");
        mp.put(2,"Physics");
        mp.put(3,"Chemistry");
        mp.put(4,"Computer");
        mp.put(5,"Science");
        //Getting value using key in the hashmap
        System.out.println(mp.get(5));
        //Changing values from the key in the hashmap
        mp.put(5,"NoScience");
        System.out.println(mp.get(5));
        //Checking for the key in the hashmap
        System.out.println(mp.containsKey(5));
        //Checking for the value in the hashmap
        System.out.println(mp.containsValue("NoScience"));
        //Removing the pair from the hashmap
        mp.remove(5);
        //Checking for the pair after deleting it
        System.out.println(mp.containsKey(5));
        //Getting all the keys in the hashmap
        System.out.println("Printing all the keys of the hashmap");
        for(var i:mp.keySet()){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Printing all the values of the hashmap");
        //Getting all the values in the hashmap
        for(var i:mp.values()){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Traversing all the entries of the hashmap..");
        //Getting all the pairs of the hashmap
        for(var i:mp.entrySet()){
            System.out.print(i+" ");
        }
        System.out.println();




    }
}
