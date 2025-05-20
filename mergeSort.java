public class mergeSort {
    static void PrintArr(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void Merge(int[]arr,int si,int ei,int mid){
        int n1=mid-si+1;
        int n2=ei-mid;
        int[]arr1=new int[n1];
        int[]arr2=new int[n2];
        int i,j,k;
        //Traversing and Entering data in Arr1
        for(i=0;i<n1;i++)arr1[i]=arr[i+si];
        for(i=0;i<n2;i++)arr2[i]=arr[i+mid+1];
        i=0;//For traversing Array1
        j=0;//For Traversing Array2
        k=si;
        //Merging the elements of the two sorted array
        while(i<n1 && j<n2){
            if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }else{
                arr[k++]=arr2[j++];
            }
        }
        //Adding the rest elements
        while(i<n1){
            arr[k++]=arr1[i++];
        }
        while(j<n2) {
            arr[k++] = arr2[j++];
        }
    }
    static void MergeSort(int[]arr,int si,int ei){
        if(si>=ei)return;
        int mid=(si+ei)/2;
        //Sorting Array Left
        MergeSort(arr,si,mid);
        //Sorting Array Right
        MergeSort(arr,mid+1,ei);
        //Merging Left Sorted And Right Sorted Array
        Merge(arr,si,ei,mid);
    }
    public static void main(String[]args){
        int[]arr={2,1,5,3,4};
        PrintArr(arr);
        MergeSort(arr,0,arr.length-1);
        PrintArr(arr);

    }
}
