package RecurSion;
public class BinarySearch {
    /***
     * This method is used to find the element in array recursively using binary search
     * @param arr This is arr in which to find
     * @param si This is Starting Index of array
     * @param ei This is Ending Index of array
     * @param n This is Number to find
     */
    static void findRecursive(int[]arr,int si,int ei,int n){
        int mid=(si+ei)/2;
        if(si>=arr.length || ei<0 || mid>=arr.length){
            System.out.println("Item not found");
            return;
        }
        if(arr[mid]==n){
            System.out.println("Item found "+mid);
            return;
        }else if(arr[mid]>n){
            findRecursive(arr,si,mid-1,n);
        }else if(arr[mid]<n){
            findRecursive(arr,mid+1,ei,n);
        }
    }
    /***
     * This method is used to find element in array Iteratively
     * @param arr This is array In which we have to find element
     * @param num This is number to find in array
     */
    static void findIterative(int[]arr,int num){
        int si=0;
        int ei=arr.length-1;
        int mid=(si+ei)/2;
        Boolean flag=false;
        while((mid>=0 && mid<arr.length) && (si<arr.length && ei>=0)){
            if(arr[mid]==num){
                System.out.println("Number found "+mid);
                flag=true;
                break;
            }else if(arr[mid]>num){
                ei=mid-1;
                mid=(si+ei)/2;
            }else if(arr[mid]<num){
                si=mid+1;
                mid=(si+ei)/2;
            }
        }
        if(flag==false){
            System.out.println("Item not found");
        }
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5};
        int num=8;
        findRecursive(arr,0,arr.length-1,num);
        findIterative(arr,num);
    }
}
