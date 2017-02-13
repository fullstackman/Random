import java.util.*;

/** Problem Statement:
 * A kidnapper wrote a ransom note but is worried it will be traced back to him.
 * He found a magazine and wants to know if he can cut out whole words from it and
 * use them to create an untraceable replica of his ransom note. The words in his
 * note are case-sensitive and he must use whole words available in the magazine,
 * meaning he cannot use substrings or concatenation to create the words he needs.
 * Given the words in the magazine and the words in the ransom note, print Yes if
 * he can replicate his ransom note exactly using whole words from the magazine;
 * otherwise, print No.
 * Input Format
 * The first line contains two space-separated integers describing the respective
 * values of (the number of words in the magazine) and (the number of words in the
 * ransom note). The second line contains space-separated strings denoting the
 * words present in the magazine. The third line contains space-separated strings
 * denoting the words present in the ransom note.
 */

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    String targetNote;
    
    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        for(String word : magazine.split(" ")){
            Integer previousOccurences = magazineMap.get(word);
            magazineMap.put(word, (previousOccurences == null) ? 1 : ++previousOccurences);
        }
        targetNote = note;
    }
    
    public boolean solve() {
        for(String word : targetNote.split(" ")){
            Integer amount = magazineMap.get(word);
            if(amount == null || amount < 1)
                return false;
            else
                magazineMap.put(word, --amount);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        if(n > m){
            System.out.println("No");
            return;
        }
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}