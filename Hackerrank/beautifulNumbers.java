import java.io.*;
import java.util.*;

/** Problem Statement:
  * A numeric string, "s", is considered beautiful if that string can be
  * split into a sequence of two or more smaller numeric strings, a1,...,an
  * satisfying the following conditions:
  * 1.  Each element in the sequence is greater than the previous element by
  *     exactly one.
  * 2.  None of the sequences contain any leading zeroes
  * 3.  The individual characters of all the smaller strings appear in
  *     their original order
  * 
  * Given a list of numeric strings, determine whether or not it meets these
  * harsh standards of beauty and if so, print the first number of the
  * sequence it represents.
  * 
  * Input format:
  * The first line contains an integer denoting "q" (the number of numeric
  * strings to evaluate)
  * Each of the following lines (exactly "q" of them!) contains a numeric
  * string to evaluate.
  * 
  * Examples:
  *     Input:
  *         7
  *         1234
  *         91011
  *         99100
  *         101103
  *         010203
  *         13
  *         1
  *     Output:
  *         YES 1
  *         YES 9
  *         YES 99
  *         NO
  *         NO
  *         NO
  *         NO
  */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            System.out.println(judgeBeauty(s));
        }
    }
    
    public static String judgeBeauty(String numbers){
        if(numbers.length() < 2){
            return "NO";
        }
        
        windowChecker:
        for(int window = 1; window < (1 + numbers.length()/2); ++window){
            if(window > 1 && numbers.charAt(0) == '0'){
                return "NO";
            }
            long firstNumber = Long.parseLong( numbers.substring(0,window) );
            long currentNumber = firstNumber;
            //System.out.printf("Checking the string %s with window size %d starting at %d\n",numbers,window,currentNumber);
            String target = Long.toString(currentNumber+1);
            int startIndex = window;
            while(startIndex < numbers.length()){
                int endIndex = startIndex + target.length();
                if(endIndex > numbers.length()){
                    //System.out.printf("\tNot enough numbers left!\n");
                    continue windowChecker;
                }
                String nextNumber = numbers.substring(startIndex, endIndex);
                //System.out.printf("\t%s vs %s\n",target,nextNumber);
                if(nextNumber.equals(target) == false){
                    //System.out.printf("\tFAIL!\n");
                    continue windowChecker;
                }
                else{
                    //System.out.printf("\tPASS!\n");
                    startIndex = endIndex;
                    target = Long.toString(currentNumber+2);
                    //System.out.printf("\tChanged target to %s\n",target);
                    ++currentNumber;
                }
            }
            return "YES "+firstNumber;
        }
        
        return "NO";
    }
}
