package stacks;
//Here we will solve the problem of given equationin the form of string
import java.util.Stack;
public class Infix {
    public static void Solve(String str){
        Stack<Integer> num=new Stack<>();
        Stack<Character> opr=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<=57) num.push(ascii-48);
            else if(opr.isEmpty()) opr.push(ch);
            else{
                if(ch=='-' || ch=='+'){
                    int val2=num.pop();
                    int val1=num.pop();
                    if(opr.peek()=='+') num.push(val1+val2);
                    if(opr.peek()=='-') num.push(val1-val2);
                    if(opr.peek()=='/') num.push(val1/val2);
                    if(opr.peek()=='*') num.push(val1*val2);
                    opr.pop();
                    opr.push(ch);
                }if(ch=='*' || ch=='/'){
                    if(opr.peek()=='*' || opr.peek()=='/'){
                        int val2=num.pop();
                        int val1=num.pop();
                        if(opr.peek()=='*')num.push(val1*val2);
                        if(opr.peek()=='/')num.push(val1/val2);
                        opr.pop();
                        opr.push(ch);
                    }
                    else{
                        opr.push(ch);
                    }
                }

            }
        }
        while(num.size()>1){
            int val2=num.pop();
            int val1=num.pop();
            if(opr.peek()=='+') num.push(val1+val2);
            if(opr.peek()=='-') num.push(val1-val2);
            if(opr.peek()=='/') num.push(val1/val2);
            if(opr.peek()=='*') num.push(val1*val2);
            opr.pop();
        }
        System.out.println("The evaluation of expression is :- "+num.peek());

    }
    public static void Solve2(String str){
        Stack<Integer> num=new Stack<>();
        Stack<Character> opr=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<=57) num.push(ascii-48);
            else if(opr.isEmpty() || ch=='(' || opr.peek()=='(') opr.push(ch);
            else if(ch==')') {
                while(opr.peek()!='(') {
                    int val2 = num.pop();
                    int val1 = num.pop();
                    if (opr.peek() == '+') num.push(val1 + val2);
                    if (opr.peek() == '-') num.push(val1 - val2);
                    if (opr.peek() == '/') num.push(val1 / val2);
                    if (opr.peek() == '*') num.push(val1 * val2);
                    opr.pop();
                }
                opr.pop();
            }else{
                if(ch=='-' || ch=='+'){
                    int val2=num.pop();
                    int val1=num.pop();
                    if(opr.peek()=='+') num.push(val1+val2);
                    if(opr.peek()=='-') num.push(val1-val2);
                    if(opr.peek()=='/') num.push(val1/val2);
                    if(opr.peek()=='*') num.push(val1*val2);
                    opr.pop();
                    opr.push(ch);
                }if(ch=='*' || ch=='/'){
                    if(opr.peek()=='*' || opr.peek()=='/'){
                        int val2=num.pop();
                        int val1=num.pop();
                        if(opr.peek()=='*')num.push(val1*val2);
                        if(opr.peek()=='/')num.push(val1/val2);
                        opr.pop();
                        opr.push(ch);
                    }
                    else{
                        opr.push(ch);
                    }
                }

            }
        }
        while(num.size()>1){
            int val2=num.pop();
            int val1=num.pop();
            if(opr.peek()=='+') num.push(val1+val2);
            if(opr.peek()=='-') num.push(val1-val2);
            if(opr.peek()=='/') num.push(val1/val2);
            if(opr.peek()=='*') num.push(val1*val2);
            opr.pop();
        }
        System.out.println("The evaluation of expression is :- "+num.peek());}
    public static void prefix(String str){
        Stack<Character> op=new Stack<>();
        Stack<String> val=new Stack<>();
        int n=str.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                String st=""+ch;
                val.push(st);
            }else if(op.isEmpty() || ch=='(' ||op.peek()=='('){
                op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    String val2= val.pop();
                    String val1=val.pop();
                    String o=""+op.pop();
                    String expre=o+val1+val2;
                    val.push(expre);
                }
                op.pop();
            }else{
                if(ch=='+' || ch=='-'){
                    String val2= val.pop();
                    String val1=val.pop();
                    String o=""+op.pop();
                    String expre=o+val1+val2;
                    val.push(expre);
                    op.push(ch);
                }else if(ch=='*'||ch=='/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String val2 = val.pop();
                        String val1 = val.pop();
                        String o = "" + op.pop();
                        String expre = o + val1 + val2;
                        val.push(expre);
                        op.push(ch);
                    } else op.push(ch);
                }
            }
        }
        while(val.size()>1){
            String val2= val.pop();
            String val1=val.pop();
            String o=""+op.pop();
            String expre=o+val1+val2;
            val.push(expre);
        }
        System.out.println(val.peek());
    }
    public static void Evaluation_Post_Fix(String str){
        int len=str.length();
        Stack<Integer> val=new Stack<>();
        for(int i=0;i<len;i++){
            char ch= str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                val.push(ascii-48);
            }else{
                int val2=val.pop();
                int val1=val.pop();
                if(ch=='-')val.push(val1-val2);
                if(ch=='+')val.push(val1+val2);
                if(ch=='/')val.push(val1/val2);
                if(ch=='*')val.push(val1*val2);
            }
        }
        System.out.println(val.peek());
    }
    public static void Evaluation_Pre_Fix(String str){
        int n=str.length();
        Stack<Integer> val=new Stack<>();
        for(int i=n-1;i>=0;i--){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                val.push(ascii-48);
            }
            else{
                int val1=val.pop();
                int val2=val.pop();
                if(ch=='-')val.push(val1-val2);
                if(ch=='+')val.push(val1+val2);
                if(ch=='/')val.push(val1/val2);
                if(ch=='*')val.push(val1*val2);

            }
        }
        System.out.println(val.peek());
    }
    public static void PreFix_To_PostFix(String str){
        int n=str.length();
        Stack<String> val=new Stack<>();
        for(int i=n-1;i>=0;i--){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                val.push(""+ch);
            }else{
                String val1=val.pop();
                String val2=val.pop();
                String op=""+ch;
                String expr=val1+val2+op;
                val.push(expr);
            }
        }
        System.out.println(val.peek());
    }
    public static void PostFix_To_PreFix(String str){
        int n=str.length();
        Stack<String> val=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                val.push(""+ch);
            }else{
                String val2=val.pop();
                String val1=val.pop();
                String op=""+ch;
                String expr=op+val1+val2;
                val.push(expr);
            }
        }
        System.out.println(val.peek());
    }
    public static void PreFix_To_Infix(String str){
        int n=str.length();
        Stack<String> val=new Stack<>();
        for(int i=n-1;i>=0;i--){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 &&  ascii<58){
                val.push(""+ch);
            }else{
                String val1=val.pop();
                String val2=val.pop();
                String op=""+ch;
                String expr="("+val1+op+val2+")";
                val.push(expr);
            }
        }
        System.out.println(val.peek());
    }
    public static void PostFix_To_Infix(String str){
        int n=str.length();
        Stack<String> val=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int ascii=(int)(ch);
            if(ascii>=48 && ascii<58){
                val.push(""+ch);
            }else{
                String val2=val.pop();
                String val1=val.pop();
                String op=""+ch;
                String expr="("+val1+op+val2+")";
                val.push(expr);
            }
        }
        System.out.println(val.peek());
    }
    public static void main(String[]args){
        String str="5+4-6*2/3";
        Solve(str);
        Solve2("5+4+(6-2)*4/2");
        prefix("4+3-1+2*4/1");
        Evaluation_Post_Fix("953+4*6/-");
        Evaluation_Pre_Fix("-9/*+5346");
        PreFix_To_PostFix("-9/*+5346");
        PostFix_To_PreFix("953+4*6/-");
        PreFix_To_Infix("-9/*+5346");
        PostFix_To_Infix("953+4*6/-");


    }
}
