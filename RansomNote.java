import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    //R: O(n), S: O(n)
    
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        
        //map to store values
        Map<String, Integer> map = new HashMap<>();

        //put values from magazine into map
        for(String m: magazine){
            map.put(m, map.getOrDefault(m,0) + 1);
        }

        // Remove values from note into map
        // We should remove matching elements found in map,
        // if we find a value with 0, that means theres no match and
        // we cannot construct a pair. Otherwise, we decrement the
        // match and continue until we've verified that we can make
        // a note usig the values in magazine.

        for(String n: note){
            //if matching value not in note, false 
            if(map.getOrDefault(n,0) == 0){
                System.out.println("No");
                return;
            } 
            //remove the matching value found in note
            else{
                map.put(n,map.get(n)-1);
            }
        }
        
        System.out.println("Yes");




    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
