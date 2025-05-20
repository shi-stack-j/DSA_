package RecurSion;
//here i have done the half solution to complete it i have add the characters in place of
//numbers showing before the | sign
public class PrintEncoding {
    static void print(String str,String s){
        if(str.length()==0){
            System.out.println(s);
            return;
        }else if(str.length()==1){
            s=s+str.charAt(0);
            System.out.println(s);
        }else{
            print(str.substring(1),s+str.charAt(0)+"|");
            print(str.substring(2),s+str.substring(0,2)+"|");
        }
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        print("123","");
    }
}
