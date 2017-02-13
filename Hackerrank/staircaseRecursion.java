import java.io.*;
import java.util.*;

/** Problem Statement:
 * Davis has 's' staircases in his house and he likes to climb each staircase 1,
 * 2, or 3 steps at a time. Being a very precocious child, he wonders how many ways
 * there are to reach the top of the staircase. Given the respective heights for
 * each of the  staircases in his house, find and print the number of ways he can
 * climb each staircase on a new line.
 * Input Format
 * The first line contains a single integer, s, denoting the number of staircases
 * in his house. Each line 'i' of the 's' subsequent lines contains a single
 * integer, n, denoting the height of staircase 'i'.
 * Constraints
 * 1 <= s <= 5
 * 1 <= n <= 36
 */

public class Solution {
    /*We can take advantage of the fact that each staircase will be no more than
        36 steps tall and do some dynamic programming!*/
    private static int[] prevSolutions = new int[37];
    
    public static void main(String[] args) {
        ++prevSolutions[0];
        ++prevSolutions[1];
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            stepCounter(n);
            System.out.println(prevSolutions[n]);
        }
    }
    
    public static void stepCounter(int numSteps){
        if(numSteps < 0)
            return;
        if(numSteps < 2) return;
        if(prevSolutions[numSteps] > 0)
            return;
        for(int i = 3; i>0; --i){
            if( (numSteps - i) < 0)
                continue;
            if(prevSolutions[numSteps-i] == 0)
                stepCounter(numSteps-i);
            prevSolutions[numSteps] += prevSolutions[numSteps-i];
        }
    }
}
