package Array;
public class Q_1 {
    static void FindDouble(int[]arr){
        String str="";
        int i=0;
        int j=arr.length-1;
        int sum=7;
        while(i<j) {
            if(arr[i]+arr[j]==sum){
                str=str+arr[i]+"+"+arr[j]+" = "+sum+" | ";
                i++;
                j--;
            }else if((arr[i]+arr[j])>sum){
                j--;
            }else if((arr[i]+arr[j])<sum){
                i++;
            }
        }
        System.out.println(str);
    }
    static void FindDoubleRecursive(int[]arr,int i,int j,String str,int sum){
        if(i>=j){
            System.out.println(str);
            return;
        }
        if(arr[i]+arr[j]==sum){
            FindDoubleRecursive(arr,i+1,j-1,str+arr[i]+"+"+arr[j]+" = "+sum+" | ",sum);
        }else if((arr[i]+arr[j])>sum){
            FindDoubleRecursive(arr,i,j-1,str,sum);
        }else if((arr[i]+arr[j])<sum){
            FindDoubleRecursive(arr,i+1,j,str,sum);
        }
    }
    static void treiplet(int[]arr){
        int j;
        int k;
        String str="";
        for(int i=0;i< arr.length;i++){
            j=i+1;
            k= arr.length-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]==8){
                    str=str+arr[i]+"+"+arr[j]+"+"+arr[k]+" = "+8+" | ";
                    j++;
                    k--;
                }else if((arr[i]+arr[j]+arr[k])>8){
                    k--;
                }else if((arr[i]+arr[j]+arr[k])<8){
                    j++;
                }
            }
        }
        System.out.println(str);
    }
    static void tripletre(int[]arr,int i,int j,int k,String str,int sum){
        if(i>=j){
            if(!(str.equals(""))){
                System.out.println(str);
            }
            return;
        }
        if(arr[i]+arr[j]+arr[k]==sum){
            tripletre(arr,i+1,j-1,k,str+arr[i]+"+"+arr[j]+"+"+arr[k]+" = "+sum+" | ",sum);
        }else if((arr[i]+arr[j]+arr[k])>sum){
            tripletre(arr,i,j-1,k,str,sum);
        }else if((arr[i]+arr[j]+arr[k])<sum){
            tripletre(arr,i+1,j,k,str,sum);
        }
    }
    static int FirstDoubRec(int[]arr,int i,int j){
        if(i>arr.length||j>arr.length){
            return -1;
        }
        if(i==arr.length-1){
            return -1;
        }
        if(j==arr.length-1){
            return FirstDoubRec(arr,i+1,i+2);
        }
        if(arr[i]==arr[j]){
            return arr[i];
        }
        return FirstDoubRec(arr,i,j+1);

    }
    static void rotateKtime(int[]arr,int k){
        k=k%arr.length;
        for(int i=arr.length-k;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int j=0;j<arr.length-k;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
    static void reverse(int[]arr,int sidx,int eidx){
        int i=sidx;
        int j=eidx;
        while(i<j){
            arr[i]=arr[i]+arr[j];
            arr[j]=arr[i]-arr[j];
            arr[i]=arr[i]-arr[j];
            i++;
            j--;
        }
    }
    static void rotateK(int[]arr,int k){
        k=k%arr.length;
        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public static void  main(String[]args){
        int[]arr={1,5,3,4,6,3,4};
//        FindDouble(arr);
//        FindDoubleRecursive(arr,0,arr.length-1,"",7);
//        treiplet(arr);
//        for(int k=0;k<arr.length;k++){
//            tripletre(arr,k+1,arr.length-1,k,"",8);
//        }
       System.out.println(FirstDoubRec(arr,0,1));
    }
}
