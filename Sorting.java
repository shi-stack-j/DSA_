public class Sorting {
        static void print(int[]arr){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        static void buble(int[]arr){
            for(int i=0;i<arr.length-1;i++){
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
        }
        static void selection(int[]arr){
            for(int i=0;i<arr.length-1;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]>arr[j]){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
        static void insertion(int[]arr){
            for(int i=1;i<arr.length;i++){
                int j=i-1;
                if(arr[j]>arr[i]){
                    if(j>1){
                        while(arr[j]>arr[i]){
                            int temp=arr[i];
                            arr[i]=arr[j];
                            arr[j]=temp;
                            j--;
                        }
                    }
                    else{
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
                // }else{
                //     int temp=arr[i];
                //     arr[i]=arr[j];
                //     arr[j]=temp;
                // }
            }
        }
        public static void main(String[] args) {
            int[]arr={7,4,12,100,90};
            print(arr);
            // buble(arr);
            // selection(arr);
            insertion(arr);
            print(arr);
        }
}
