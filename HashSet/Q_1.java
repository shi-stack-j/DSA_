package HashSet;
import java.util.HashMap;
import  java.util.HashSet;
//Here we will see the question of consecutive sequence
public class Q_1 {
    public static int LongestConsecutive(int[]arr){
        int maxlen=0;
        HashSet<Integer> hs=new HashSet<>();
        for(var i:arr)hs.add(i);
        for(var i:hs){
            int currnum=i;
            if(!(hs.contains(i-1))){
                int cureelen=1;
                while(hs.contains(currnum+1)){
                    cureelen++;
                    currnum++;
                }
                maxlen=Math.max(cureelen,maxlen);
            }
        }
        return maxlen;
    }
    public static int maximumNumbersontable(int[]arr){
        int maxnum=0;
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int cnum=arr[i];
            if(hs.contains(cnum)){
                hs.remove(cnum);
            }else{
                hs.add(cnum);
                maxnum=Math.max(maxnum,hs.size());
            }
        }
        return maxnum;
    }
    public static void main(String[]args){
        int[]arr={99,1,100,4,200,1,2,2,3};
        System.out.println(LongestConsecutive(arr));
        int[]arr2={2,1,3,2,1,3};
        System.out.println(maximumNumbersontable(arr2));
    }
}
