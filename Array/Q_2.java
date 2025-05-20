package Array;
//Here we will sort the array and put all its even numbers first and then its odd elements
public class Q_2 {
    static void print(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void arrangeOddEven(int[]arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]%2==0 && arr[j]%2!=0){
                i++;
                j--;
            }else if(arr[i]%2!=0 && arr[j]%2==0){
                arr[i]=arr[j]+arr[i];
                arr[j]=arr[i]-arr[j];
                arr[i]=arr[i]-arr[j];
                i++;
                j--;
            }else if(arr[i]%2==0 && arr[j]%2==0){
                i++;
            }else if(arr[i]%2!=0 && arr[j]%2!=0){
                j--;
            }
        }
    }
    public static void main(String[]args){
        int[] arr={6,2,3,4,5,1,7};
        print(arr);
        arrangeOddEven(arr);
        print(arr);

    }
}
