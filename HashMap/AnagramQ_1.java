package HashMap;
import java.lang.reflect.Type;
import java.util.HashMap;
//Here we will solve the question of anagram using the HashMAp
//The string is anagram of another string only if the s1 contains all the characters of s2 the order of the charcaters can be changed
public class AnagramQ_1 {
    public static Boolean anagram(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer>mp2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
           char ch=s1.charAt(i);
           char ch2=s2.charAt(i);
           if(mp.containsKey(ch)){
               mp.put(ch,mp.get(ch)+1);
           }else{
               mp.put(ch,1)
;           }
           if(mp2.containsKey(ch2)) {
               mp2.put(ch2, mp2.get(ch2) + 1);
           }else{
               mp2.put(ch2,1);
           }
        }
        for(var i:mp.keySet()){
            if(mp.get(i)!=mp2.get(i)){
                return false;
            }
        }
        return true;
    }
    public static Boolean anagram2(String s1,String s2){
        if(s1.length()!=s2.length())return false;
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
        }
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
            }else{
                return false;
            }
        }
        for(var i:mp.values()){
            if(i!=0)return false;
        }
        return true;
    }
    public static Boolean isoMorphic(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Character>mp=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(mp.containsKey(ch)){
                if(mp.get(ch).equals(s2.charAt(i))){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(mp.containsValue(s2.charAt(i))){
                    return false;
                }else{
                    mp.put(ch,s2.charAt(i));
                }

            }
        }
        for(int i=0;i<s2.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(mp.containsKey(ch1)){
                if(mp.get(ch1).equals(ch2)){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;

    }
    public static int[] twoSum(int[]arr,int target){
        HashMap<Integer,Integer> mp=new HashMap<>();
        int[]narr=new int[2];
        for(int i=0;i<arr.length;i++){
            int ele=arr[i];
            int key=target-ele;
            if(mp.containsKey(ele)){
                narr[0]=mp.get(ele);
                narr[1]=i;
                return narr;
            }else{
                mp.put(key,i);
            }
        }
        narr[0]=-1;
        return narr;
    }
    public static int largestZeroLength(int[]arr){
        HashMap<Integer,Integer>mp=new HashMap<>();
        int prefisum=0,maxlen=0;
        for(int i=0;i<arr.length;i++){
            prefisum+=arr[i];
            mp.put(0,-1);
            if(mp.containsKey(prefisum)){
                maxlen=Math.max(maxlen,i-mp.get(prefisum));
            }else{
                mp.put(prefisum,i);
            }
        }
        return maxlen;
    }
    public static void main(String[]args){
//        String s1="silentpoop";
//        String s2="listenpoop";
//        System.out.println(anagram(s1,s2));
//        System.out.println(anagram2(s1,s2));
//        String s1="paper";
//        String s2="title";
//        System.out.println(isoMorphic(s1,s2));
        int[]arr={14,7,10,4,5,9,1,2};
        int target=13;
        arr=twoSum(arr,target);
        for(var i:arr){
            System.out.println(i);
        }
    }
}
