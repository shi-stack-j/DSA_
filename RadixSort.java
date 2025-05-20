public class RadixSort {
        static void print(int[]arr){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        static void prefix(int[]arr){
            for(int i=1;i<arr.length;i++){
                arr[i]=arr[i]+arr[i-1];
            }
        }
        static void basicRadixSort(int[]arr){
            int max=arr[0];
            for(int i:arr){
                if(max<i){
                    max=i;
                }
            }
            int[]nar=new int[max+1];
            for(int i:arr){
                nar[i]=nar[i]+1;
            }
            int i=0;
            int j=0;
            while(j!=nar.length){
                if(nar[j]==0){
                    j++;
                }else{
                    for(int k=0;k<nar[j];k++){
                        arr[i++]=j;
                    }
                    j++;
                }
            }
        }
        static void RadixSort(int[]arr){
            int max=arr[0];
            for(int i:arr){
                if(max<i){
                    max=i;
                }
            }
            int[]nar=new int[max+1];
            for(int i:arr){
                nar[i]=nar[i]+1;
            }
            prefix(nar);
            int[]na=new int[arr.length];
            for(int i=arr.length-1;i>=0;i--){
                int ele=arr[i];
                na[nar[ele]-1]=ele;
                nar[ele]=nar[ele]-1;
            }
            print(na);
        }
        public static void main(String[]args){
            int[]arr={5,2,1,3,1,8,3};
            print(arr);
            // basicRadixSort(arr);
            // print(arr);
            RadixSort(arr);
        }
}
