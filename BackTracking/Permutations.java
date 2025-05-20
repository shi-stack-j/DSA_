package BackTracking;
//Here we will se the code of permutations of array of string using recursion and backtracking

public class Permutations {
    static void printPer(String st,String res){
        if(st.equals("")){
            System.out.println(res);
            return;
        }
        for(int i=0;i<st.length();i++){
            char ch=st.charAt(i);
            String left=st.substring(0,i);
            String right=st.substring(i+1);
            String rem=left+right;
            printPer(rem,res+ch);
        }
    }
    public static void main(String[]args){
        String st="abc";
        String res="";
        printPer(st,res);

    }
}
