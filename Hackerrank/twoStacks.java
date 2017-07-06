import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/** Problem Statement
 * Alexa has two stacks of non-negative integers, stack A and stack B where index 0
 * denotes the top of the stack. Alexa challenges Nick to play the following game:
 * In each move, Nick can remove one integer from the top of either stack A or stack B.
 * Nick keeps a running sum of the integers he removes from the two stacks.
 * Nick is disqualified from the game if, at any point, his running sum becomes greater
 * than some integer, x, given at the beginning of the game.
 * Nick's final score is the total number of integers he has removed from the two stacks.
 * Given A, B and x for g games, find the maximum possible score Nick can achieve
 * (i.e., the maximum number of integers he can remove without being disqualified)
 * during each game and print it on a new line.
 * 
 * Input Format
 * 
 * The first line contains an integer, g (the number of games). The 3*g subsequent lines
 * describe each game in the following format:
 * The first line contains three space-separated integers describing the respective
 * values of n (the number of integers in stack A), m (the number of integers in
 * stack B), and x (the number that the sum of the integers removed from the two stacks
 * cannot exceed).
 * The second line contains n space-separated integers describing the respective values
 * of stack A.
 * The third line contains m space-separated integers describing the respective values
 * of stack B.
 * 
 * Sample Input
 * 1
 * 5 4 10
 * 4 2 4 6 1
 * 2 1 8 5
 * 
 * Sample Output
 * 4
 * 
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            System.out.println(playGame(a, b, x, 0));
        }
    }
    
    public static int playGame(int[] stackA, int[] stackB, int max, int currentScore){
        int scoreA = 0;
        int scoreB = 0;
        int newMax = 0;
        if(stackB.length >0){
            newMax = max - stackB[0];
            if(newMax > -1){
                 scoreB = playGame(stackA, Arrays.copyOfRange(stackB, 1, stackB.length), newMax, ++currentScore);
            }
            if(scoreB > currentScore)
                currentScore = scoreB;
        }
        if(stackA.length >0){
            newMax = max - stackA[0];
            if(newMax > -1){
                scoreA = playGame(Arrays.copyOfRange(stackA, 1, stackA.length), stackB, newMax, ++currentScore);
            }
            if(scoreA > currentScore)
                currentScore = scoreA;
        }
        return currentScore;
    }
}
