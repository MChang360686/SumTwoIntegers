import java.io.*;

public class getSum {
    //based off the solution at
    // https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/

    static int sum(int a, int b){
        while(b!=0){
            //The idea is to use a half adder and bitwise operands
            //& is bitwise AND
            //^ is bitwise OR
            //<< is bitwise shift left
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    static int sumRecursive(int a, int b){
        //The same thing as above, but recursively
        //First, check for zeroes
        if(a == 0 && b == 0){
            return 0;
        }else  if(b == 0){
                return a;
            }else if(a == 0){
                return b;
        }else{
            //Otherwise, just recursively call the method
            //the new a is a XOR b
            //the new b is a AND b shifted left one place
            return sumRecursive((a ^ b), (a & b) << 1);
        }
    }

    public static void main(String[] args){
        System.out.println(sum(100,2));
        System.out.println(sumRecursive(3,4));
        System.out.println(sumRecursive(0,4));
        System.out.println(sumRecursive(3,0));
        System.out.println(sumRecursive(0,0));
    }
}
