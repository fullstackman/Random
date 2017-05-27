import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/** Problem Satement:
  * A left rotation operation on an array of size n shifts each of the array's elements
  * 1 unit to the left. For example, if 2 left rotations are performed on array [1,2,3,4,5],
  * then the array would become [3,4,5,1,2].
  * 
  * Given an array of n integers and a number, d, perform d left rotations on the array.
  * Then print the updated array as a single line of space-separated integers.
  * 
  * Input Format:
  * The first line contains two space-separated integers denoting the respective values
  * of n (the number of integers) and d (the number of left rotations you must perform).
  * The second line contains n space-separated integers describing the respective
  * elements of the array's initial state.
  * 
  * Output Format:
  * Print a single line of n space-separated integers denoting the final state of the
  * array after performing d left rotations.
  * 
  * Sample Input:
  * 5 4
  * 1 2 3 4 5
  * 
  * Sample Output:
  * 5 1 2 3 4
  */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        //read in all the required information as given by the input format
        int arrLength=sc.nextInt();
        int numRotations=sc.nextInt();
        int[] input = new int[arrLength];
        for(int b=0; b<arrLength;++b){
            input[b] = sc.nextInt();
        }
        /* Sanity check:
         * If the number of rotations exceeds the size of the input array, then the
         * equivalent number of rotations is exactly equal to the remainder of the
         * number of rotations divided by the size. This saves us some computational
         * complexity.
         */
        numRotations = numRotations % arrLength;
        //prepare a result array
        int[] result = new int[arrLength];
        //keep track of what index of the input array we are at
        int currentIndex=numRotations;
        /* Loop through the result array and insert the value at the current index of
         * the input array. In the input array, we start at a position equal to the
         * number of rotations that will be performed, then loop forward. When we go
         * off the end of the input array, we reset the current index to the front
         * of the input array to add those values to the end of the resultant array.
         */
        for(int z=0; z<arrLength; ++z){
            if(currentIndex >= arrLength){
                currentIndex=0;
            }
            result[z]=input[currentIndex];
            ++currentIndex;
        }
        //Loop through the resultant array and print to standard out
        for(int i=0; i<arrLength; ++i){
            System.out.print(result[i]+" ");
        }
        //end
    }
}