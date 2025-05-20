public class SortingQuestions{
    static void print(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void SortArray(int[]arr){
        if(arr.length<=1)return;
        int y=-1;
        int x=-1;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                if(x==-1){
                    x=i-1;
                    y=i;
                }else{
                    y=i;
                }
            }
        }
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    static void SortEle(int[]arr){
        int i=0;
        int j=arr.length-1;
        int pivot=0;
        while(i<=j && i>=0 && j>=0){
            while(arr[i]<0){
                i++;
            }
            while(arr[j]>0){
                j--;
            }
            if(i<=j && i>=0 && j>=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    static void sort012(int[]arr){
        int n=arr.length;
        int j=0;
        int[]nar=new int[3];
        for(int i:arr){
            nar[i]=nar[i]+1;
        }
        for(int i=0;i<nar.length;i++){
            for(int k=0;k<nar[i];k++){
                arr[j++]=i;
            }
        }
    }
    static void swap(int[]arr,int si,int ei){
        int temp=arr[si];
        arr[si]=arr[ei];
        arr[ei]=temp;
    }
    static void sort012A2(int[]arr){
        int low=0,mid=0,hi=arr.length-1;
        while(mid<=hi){
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }else if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==2){
                swap(arr,mid,hi);
                hi--;
            }
        }
    }
    public static void main(String[]args){
        int[]arr={0,2,1,2,0,0};
        print(arr);
        // SortArray(arr);
        // SortEle(arr);
        // sort012(arr);
        sort012A2(arr);
        print(arr);
    }
}