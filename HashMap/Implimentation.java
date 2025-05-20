package HashMap;
import java.util.*;
//Here we will se the implementation of hashmap
public class Implimentation {
    public static class hashMap<K,V>{
        private static final int DEFAULT_CAPACITY=4;
        private static final float DEFAULT_LOAD_FACTOR=0.75f;
        private int n;//Number of entries  in map
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private LinkedList<Node>[] bucket;//Array of linkedlist
        private void initBucket(int n){
            bucket=new LinkedList[n];
            for(int i=0;i<bucket.length;i++){
                bucket[i]=new LinkedList<>();
            }
        }
        //This will return the bucket index of the element
        private int hashFunction(K key) {
            int idx=key.hashCode();
            return (Math.abs(idx))% bucket.length;
        }
        private void rehash(){
            LinkedList<Node>[] oldBucket=bucket;
            n=0;
            initBucket(oldBucket.length*2);
            for(var buck:oldBucket){
                for(var i:buck){
                    put(i.key,i.value);
                }
            }
        }
        //This method will search in the linkedlist for the key exists or not
        private int searchInLL(K key,LinkedList<Node> ll){
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        public hashMap(){
            initBucket(DEFAULT_CAPACITY);
        }
        public int size(){
            return n;
        }
        public void put(K key,V val){
            int bi=hashFunction(key);
            LinkedList<Node> currentBucket=bucket[bi];
            int ex=searchInLL(key,currentBucket);
            if(ex==-1){
                Node newNode=new Node(key,val);
                currentBucket.add(newNode);
                n++;
            }else{
                Node cn=currentBucket.get(ex);
                cn.value=val;
            }
            if(n>=bucket.length*DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }
        public V remove(K key){
            int bi=hashFunction(key);
            LinkedList<Node> currentBucket=bucket[bi];
            int ex=searchInLL(key,currentBucket);
            if(ex==-1){
                return null;
            }else{
                Node cn=currentBucket.get(ex);
                currentBucket.remove(ex);
                V val=cn.value;
                return val;
            }
        }
        public V get(K key){
            int bi=hashFunction(key);
            LinkedList<Node> currentBucket=bucket[bi];
            int ex=searchInLL(key,currentBucket);
            if(ex==-1){
                return null;
            }else{
                Node cn=currentBucket.get(ex);
                return cn.value;
            }

        }
        public int capacity(){
            return bucket.length;
        }
        public float load(){
            return (n*1.0f)/bucket.length;
        }
    }
    public static void main(String[]args){
        hashMap<String,Integer> mp=new hashMap<>();
        mp.put("c",1);
        mp.put("a",2);
        mp.put("d",3);
        System.out.println(mp.size());
        mp.put("a",20);
        System.out.println(mp.size());
        System.out.println(mp.get("a"));
        System.out.println(mp.get("d"));
        System.out.println(mp.get("c"));
        System.out.println(mp.remove("c"));
        System.out.println(mp.get("c"));
        System.out.println(mp.size());
        System.out.println(mp.load());
        System.out.println(mp.capacity());
        mp.put("e",89);
        mp.put("f",90);
        mp.put("h",100);
        System.out.println(mp.capacity());
        System.out.println(mp.load());
        System.out.println(mp.get("h"));
        System.out.println(mp.get("f"));
        System.out.println(mp.size());

    }
}
