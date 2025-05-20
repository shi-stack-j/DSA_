public class To_rev_stringBuilder {
    public static void main(String[]args){
        StringBuilder sb=new StringBuilder("Shivam");
        //We can reverse stringBuilder using method also
        //sb.reverse();
        //We can reverse StringBuilder using Two pointer  approch also as shown below
        /*int i=0;
        int j=sb.length()-1;
        //S h i v a m
        //0 1 2 3 4 5
        //i=0 j=5
        while(i<j){
            char temp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }*/
        //We can reverse StringBuilder using Temp StringBuilder as shown below
        /*
        StringBuilder nsb=new StringBuilder();
        int n=sb.length();
        for(int i=0;i<sb.length();i++){
            nsb.insert(i,sb.charAt(n-i-1));
        }
        System.out.println(sb);
        System.out.println("Temp sb :- "+nsb);*/
    }
}
