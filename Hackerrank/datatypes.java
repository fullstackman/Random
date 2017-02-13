import java.util.*;
import java.io.*;

/** Problem Statement:
 * Given an input integer, you must determine which primitive data types are
 * capable of properly storing that input.
 * The first line of input contains an integer, T, denoting the number of test
 * cases. Each test case, T, is comprised of a single line with an integer, n,
 * which can be arbitrarily large or small.
 */


class Solution{
    public static void main(String []argh)
    {

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                long intLimit = -( (long) Math.pow(2, 31) );
                if(x>= intLimit && x<= (-intLimit) -1)System.out.println("* int");
                double longLimit = - Math.pow(2, 63);
                if(x>= longLimit && x<= (-longLimit) -1)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
            finally{
                sc.close();
            }
        }
    }
}