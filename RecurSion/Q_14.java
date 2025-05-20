package RecurSion;
import java.util.ArrayList;
public class Q_14 {
    static void subSetArr(ArrayList<Integer>num,ArrayList<Integer>a,int idx,int sum){
        if(num.size()<=idx){
            System.out.println(a+" sum :- "+sum);
            return;
        }
        //Including
        //Adding the element to the array
        a.add(num.get(idx));
        sum=sum+num.get(idx);
        subSetArr(num,a,idx+1,sum);
        //Excluding
        //Removing the element from the array
        a.remove(num.get(idx));
        sum=sum-num.get(idx);
        subSetArr(num,a,idx+1,sum);
    }
    static void subsetString(String st,StringBuilder sb,int idx){
        if(st.length()<=idx){
            System.out.println(sb);
            return;
        }
        //Including
        sb.append(st.charAt(idx));
        subsetString(st,sb,idx+1);
        //Excluding
        String s=st.substring(idx,idx+1);
        sb.deleteCharAt(sb.lastIndexOf(s));
        subsetString(st,sb,idx+1);
    }
    static void subString2(String st,String curStr){
        if(st.length()==0){
            System.out.println(curStr);
            return;
        }
        subString2(st.substring(1),curStr+st.charAt(0));
        subString2(st.substring(1),curStr);
    }
    public static void main(String[]args){
        ArrayList<Integer>num=new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        ArrayList<Integer>a=new ArrayList<>();
        subSetArr(num,a,0,0);
//        for(ArrayList<Integer>obj:c){
//            System.out.println(obj);
//        }
        String str="abcd";
        StringBuilder sb=new StringBuilder();
        subsetString(str,sb,0);
        System.out.println("Using more optimized method:- ");
        subString2(str,"");
    }
}
