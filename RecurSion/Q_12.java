package RecurSion;

public class Q_12 {
    //this method will check the sorting of array in accending order
    static Boolean isSortedAcen(int[]arr,int idx){
        if(idx>=arr.length)return false;
        if(idx==arr.length-1)return true;
        if(arr[idx]>arr[idx+1])return false;
        return isSortedAcen(arr,idx+1);
    }
    //this method will check the sorting of the array in decending order
    static Boolean isSortedDcen(int[]arr,int idx){
        if(idx>=arr.length)return false;
        if(idx==arr.length-1)return true;
        if(arr[idx]<arr[idx+1])return false;
        return isSortedDcen(arr,idx+1);
    }
    //This method will print all the indices of the x in the arr
    static void PrintIndices(int[] arr,int idx,int x){
        if(idx>=arr.length)return;
        if(arr[idx]==x)System.out.println(idx);
        PrintIndices(arr,idx+1,x);
    }
    static Boolean checkNum(int[] arr,int idx,int x){
        //Base Case
        if(idx>=arr.length)return false;
        //Self work
        if(arr[idx]==x)return true;
        //Recursive work
        return checkNum(arr,idx+1,x);
    }
    //This method will return In which type array sorted
    static String isSorted(int[]arr ,int idx){
        if(isSortedDcen(arr,idx))return "Decending";
        else if(isSortedAcen(arr,idx))return "Accending";
        return "Not Sorted";
    }
    //Return the first index of the given element
    static int indCheckNum(int[]arr,int idx,int x){
        if(idx>=arr.length)return -1;
        if(arr[idx]==x)return idx;
        return indCheckNum(arr,idx+1,x);
    }
    static int lastIndex(int[] arr,int idx,int x){
        if(idx>=arr.length)return -1;
        if(arr[arr.length-idx-1]==x)return arr.length-idx-1;
        return lastIndex(arr,idx+1,x);
    }
    static Boolean issor(int[]arr,int idx){
        if(arr.length<=idx)return false;
        if(arr.length-1==idx)return true;
        if(arr[idx]>arr[idx+1]){
            issor(arr,idx+1);
            return true;
        }else if(arr[idx]<arr[idx+1]){
            issor(arr,idx+1);
            return true;
        }
        return false;

    }
    //This most efficient method to find weather the array is sorted or not
    static String IsRe(int[] arr,int idx){
        if(arr.length-1<=idx)return "Unknown";
        Boolean acending=true;
        Boolean decn=true;
        if(arr[idx]>arr[idx+1]){
            acending=false;
        }
        if(arr[idx]<arr[idx+1]){
            decn=false;
        }
        String res=IsRe(arr,idx+1);
        if(acending && res.equals("acending")){
            return "acending";
        }if(decn && res.equals("decending")){
            return "decending";
        }if(res.equals("Unknown")){
            return acending?"acending":"decending";
        }
        return "Not Sorted";
    }
    public static void main(String[]args){
        int[] arr={1,2,3,4,5,0};
        int x=2;
        int idx=0;
        System.out.println("The status of "+x+" in arr is :- "+checkNum(arr,idx,x));
        System.out.println("The First index of "+x+" in arr is :- "+indCheckNum(arr,idx,x));
        System.out.println("The last index of "+x+" in arr is :- "+lastIndex(arr,0,x));
//        PrintIndices(arr,idx,x);
        System.out.println("IS soreted in accending order :- "+isSortedAcen(arr,idx));
        System.out.println("Is sorted in decneding order :- "+isSortedDcen(arr,idx));
        System.out.println("Is sorted in any order :- "+isSorted(arr,idx));
        System.out.println("Is sorted 2 :- "+issor(arr,idx));
        System.out.println("Is sorted 3 :- "+IsRe(arr,idx));
    }
}
