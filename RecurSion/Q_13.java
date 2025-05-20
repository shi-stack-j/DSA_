package RecurSion;

public class Q_13 {
    static String remove(String a,int idx){
        if(idx>=a.length())return " ";
        String st="";
        if(a.charAt(idx)!='a'){
            st=st+a.charAt(idx);
        }
        return st+remove(a,idx+1);
    }
    static String reverse(String a,int idx){
        if(idx>=a.length())return "";
        String st=reverse(a,idx+1);
        return st+a.charAt(idx);
    }
    static Boolean checkPalin(String a,int idx){
        if(idx>=a.length()-idx-1)return true;
        if(a.charAt(idx)!=a.charAt(a.length()-idx-1))return false;
        return checkPalin(a,idx+1);
    }
    public static void main(String[]args){
        String a="nitin";
        int idx=0;
        System.out.println(a);
        String st=remove(a,idx);
        System.out.println(st);
        System.out.println(reverse(a,idx));
        System.out.println(checkPalin(a,idx));
    }
}
