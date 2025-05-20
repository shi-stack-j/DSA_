package Array;
//Here we will se the Code of merge sort
//Mere sort is based on divide and coquor rule where we will first divide the array and then merger the sorted list
//This we will performe using recursion
//Here we will write the functions first for divide the array and second to merge the two sorted array
public class MergerSort {
    /***
     * This method is the helper method for the merger sort that will merge the two sorted arrays that will given to it
     * Here we will get the arry it works is to merge them in sorted order
     * @param arr :- The main array we are getting from the main function
     * @param si :- The starting index of the Sorted array
     * @param mid :- The point from where arrays are divided
     * @param ei :-The ending index of the array that we  want to sort
     */
    public static void Merge(int[]arr,int si,int mid,int ei){
        int len1=mid-si+1;
        int len2=ei-mid;
        int[]arr1=new int[len1];
        int[]arr2=new int[len2];
        int idx1=si;//Starting index of arr1
        int idx2=mid+1;//Starting index of arr2
        int idx=si;//Starting index of Main array passed from function
        for(int i=0;i<len1;i++)arr1[i]=arr[idx1++];//Entering elements of array 1 in array 1
        for(int i=0;i<len2;i++)arr2[i]=arr[idx2++];//Entering elements of array 1 in array 2
        idx1=idx2=0;
        //Entering the elements in the array after sorting
        while(idx1<len1 && idx2<len2){
            if(arr1[idx1]<arr2[idx2]){
                arr[idx++]=arr1[idx1++];
            }else{
                arr[idx++]=arr2[idx2++];
            }
        }
        //Entering the rest elements in the array into the Main list
        while(idx1<len1)arr[idx++]=arr1[idx1++];
        while(idx2<len2)arr[idx++]=arr2[idx2++];
    }
    /***
     * This Is the main method of the MergeSort where we are dividing and merging the array
     * In this code we are passing the full array and dividing it into small arrays
     * The dividation of array is done by recursion
     * First we are dividing the left array then we are dividing the right array
     *After dividng the full array we will get the two sorted arrays
     * After getting the two sorted array we will merge these arrays
     * We will create the function which mere the two sorted array
     * @param arr :- The main array that we want to sort
     * @param si :- The starting index of the array
     * @param ei :- The Ending index of the array
     */
    public static void MergeSort(int[]arr,int si,int ei){
        if(si>=ei)return;
        //Calculating the Mid
        int mid=(si+ei)/2;
        //Calling the left array
        MergeSort(arr,si,mid);
        //Calling the right array
        MergeSort(arr,mid+1,ei);
        //Mergeing the left and right sorted array
        Merge(arr,si,mid,ei);
    }
    public static void main(String[]args){
        int[]arr={5,2,1,4,3};
        for(var i:arr)System.out.print(i+" ");
        System.out.println();
        MergeSort(arr,0,arr.length-1);
        for(var i:arr)System.out.print(i+" ");
        System.out.println();
    }
}
