package RecurSion;
//KeyPad questions
public class Q_16 {
    static void keyPad(String str,String[]comb,String res){
        if(str.length()==0){
            System.out.print(res+" ");
            return;
        }
        int idx=str.charAt(0)-'0';
        String curStr=comb[idx];
        for(int i=0;i<curStr.length();i++){
            keyPad(str.substring(1),comb,res+curStr.charAt(i));
        }
    }
    public static void main(String[]args){
        String str="23";
        String[] comb={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String res="";
        keyPad(str,comb,res);
    }
}
