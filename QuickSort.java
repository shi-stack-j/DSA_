//Here we will se the Quick sort algorithm
public class QuickSort {
    static void print(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void swap(int[]arr,int ti,int fi){
        int temp=arr[ti];
        arr[ti]=arr[fi];
        arr[fi]=temp;
    }
    static int FindPivot(int[]arr,int si,int ei){
        int pivot=arr[si];
        int cnt=0;
        for(int i=si+1;i<=ei;i++) {
            if (arr[i]<=pivot) cnt++;
        }
        int pidx=si+cnt;
        swap(arr,si,pidx);
        int i=si;
        int j=ei;
        while(i<pivot && j>pivot){
            while(arr[i]<=pivot)i++;
            while(arr[j]>pivot)j--;
            if(i<pivot && j>pivot){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        return pidx;
    }
    static void quickSort(int[]arr,int si,int ei){
        if(si>=ei)return;
        //Self Work
        int pivot=FindPivot(arr,si,ei);
        //Sorting left array
        quickSort(arr,si,pivot-1);
        //Sorting Right array
        quickSort(arr,pivot+1,ei);
    }
    public static void  main(String[]args){
        int[]arr={3,1,2,4,5};
        print(arr);
        quickSort(arr,0,arr.length-1);
        print(arr);
    }
}

