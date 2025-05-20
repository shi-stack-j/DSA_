class Greet{
    String nam;
    String C;
    int na;
    protected int pr;
    private int cr;
    Greet(int na,String nam,String C,int pr,int cr){
        this.nam=nam;
        this.C=C;
        this.na=na;
        this.pr=pr;
        this.cr=cr;
    }
}
public class Practice{
//    public static class Greet{
//        String nam;
//        String C;
//        int na;
//        protected int pr;
//        private int cr;
//        Greet(int na,String nam,String C,int pr,int cr){
//            this.nam=nam;
//            this.C=C;
//            this.na=na;
//            this.pr=pr;
//            this.cr=cr;
//        }
//    }
    public static void main(String[]args){
        Greet obj=new Greet(1,"Shi","Ga",1,12);
        System.out.println(obj.na);
        System.out.println(obj.pr);
        //System.out.println(obj.cr);
    }
}