package HashMap;
import java.util.*;
//Here we will se the implementation of HashMap by myself
public class Impliment2 {
    //Here k  v are the generics which can be of any data type
    public static class hashMap<k,v>{
        private final int DEFAULT_CAPACITY=4;//This is the default capacity of the Array created first
        private final float DEFAULT_LOAD_FACTOR=0.75f;//This is the load factor
        int n;//This will store the numbers of elements in the hashmap
        //Here we have created the node class which will store key and values
        private class Node{
            k key;
            v val;
            public Node(k key,v val){
                this.key=key;
                this.val=val;
            }
        }
        private LinkedList<Node> [] bucket;//Here we have declared the array of LinkedList of nodes
        //Here we have created the constructor which will initializze the array after the class boject is initiated
        private void initialize(int n){
            bucket=new LinkedList[n];//Here we have initialize the array size;
            //Here we will initialize the each index of array with empty index
            for(int i=0;i<n;i++){
                //Before this their is null element on every index now after this their is a
                //LinkedList empty on every index
                bucket[i]=new LinkedList<>();
            }
        }
        private int bucketIndex(k key){
            int bi=key.hashCode();//This will return the hased value
            //This will do the calculations and convet the bucket index into the bucker index which ca
            //can be fit inside the arry
            int fbi=(Math.abs(bi))%bucket.length;
            return fbi;
        }
        //This method will check for the existance of key int currentLinkedList
        //Return -1 if key doesnot exists
        //Return idx if key exists
        private int getIndex(k key,LinkedList<Node> curentList){
            for(int i=0;i<curentList.size();i++){
                if(key==curentList.get(i).key){
                    return i;
                }
            }
            return -1;
        }
        private void rehash(){
            //First we will create the newList array of same size to store the values of current array
            LinkedList<Node>[] oldbucket=bucket;
            //Second step we will decrease the value of n to 0
            n=0;
            initialize(bucket.length*2);
            //Start putting the elements of oldlist into to the newlist
            for(var buck:oldbucket){
                for(var i:buck){
                    //Here we are putting the old values into the new array
                    put(i.key,i.val);
                }
            }


        }
        public hashMap(){
            initialize(DEFAULT_CAPACITY);
        }
        //Here we will see the put function it will do
        //1->Change value if key exists otherwise create the new key value pair
        public void put(k key,v val){
            int bi=bucketIndex(key);//This will calculate the bucket index
            LinkedList<Node> curretBucket=bucket[bi];//This will store the linked list on the particular index
            int llidx=getIndex(key,curretBucket);//This will check for the key int the array
            if(llidx==-1){
                Node newNode=new Node(key,val);
                curretBucket.add(newNode);
                n++;
            }else{
                curretBucket.get(llidx).val=val;
            }
            if(n>=bucket.length*DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }
        public v get(k key){
            int bi=bucketIndex(key);
            LinkedList<Node> currentBucket=bucket[bi];
            int llidx=getIndex(key,currentBucket);
            if(llidx==-1){
                return null;
            }else{
                return currentBucket.get(llidx).val;
            }
        }
        public v remove(k key){
            int bi=bucketIndex(key);
            LinkedList<Node> currentList=bucket[bi];
            int llidx=getIndex(key,currentList);
            if(llidx==-1){
                return null;
            }else{
                v va=currentList.get(llidx).val;
                currentList.remove(llidx);
                n--;
                return va;
            }
        }
        public int size(){return n;}
        public int capacity(){return bucket.length;}
        public float load(){return (n*1.0f)/bucket.length;}
    }
    public static void main(String[]args){
        hashMap<Integer,String>mp=new hashMap<>();
        mp.put(1,"A");
        mp.put(2,"b");
        mp.put(3,"c");
        System.out.println(mp.size());
        System.out.println(mp.remove(2));
        System.out.println(mp.size());
        System.out.println(mp.get(3));
        System.out.println(mp.get(1));
        System.out.println(mp.size());
        System.out.println(mp.capacity());
        System.out.println(mp.load());
        mp.put(4,"D");
        mp.put(5,"E");
        mp.put(6,"F");
        System.out.println(mp.size());
        System.out.println(mp.remove(6));
        System.out.println(mp.size());
        System.out.println(mp.get(4));
        System.out.println(mp.get(5));
        System.out.println(mp.size());
        System.out.println(mp.capacity());
        System.out.println(mp.load());

    }
}
