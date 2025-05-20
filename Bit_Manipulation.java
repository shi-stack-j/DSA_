import java.util.Scanner;
public class Bit_Manipulation {
    public static int getBit(int n,int posi){
        //To get Bit follow the steps
        //1->Find the BitMask of 1
        //2->Perform AND of number by BitMask of 1
        //3->Check if answer after 2 is 1 then bit is 1
        //4->Check if answer after 2 is 0 then bit is 0
        //The number indexing starts from 0 index.
        int BitMask=1<<posi;
        if((BitMask & n)==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setBit(int n,int posi){
        //SetBit to 1
        //To setBit 1 follow the steps
        //1->Find the BitMask of 1
        //->To find bitMask of 1
        //->perform rightShift of 1 by position
        //2->Perform or operation of n by BitMask
        int BitMask=1<<posi;
        n=n | BitMask;
        System.out.println("Bit Set Successfully.....");
        return n;
    }
    public static int clearBit(int n,int posi){
        //SetBit to 0
        //To clearBit 0 follow the steps
        //1->Find the BitMask of 1
        //->To find bitMask of 1
        //->perform rightShift of 1 by position
        //->2->Perform the NOT of BitMask
        //->3->Perform the AND of BitMask with number
        int BitMask=1<<posi;
        BitMask=~BitMask;
        System.out.println("Bit Cleared Successfully.......");
        return (BitMask & n);
    }
    public static void  main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number to find bit :- ");
        int n=sc.nextInt();
        System.out.print("Enter position of bit to find :- ");
        int posi=sc.nextInt();
        System.out.println("Bit is :- "+getBit(n,posi));
        n=setBit(n,posi);
        System.out.println("Number after SettingBit is :- "+n);
        n=clearBit(n,posi);
        System.out.println("Number after ClearingBit is :- "+n);
    }
}