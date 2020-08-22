import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //R: O(1), S: O(1)
    
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    
        int count = 0; int pos = 0; 
        boolean dFound = false; 
        boolean uFound = false;

        for(int x = 0; x < n; x++){
            
            if(s.charAt(x) == 'D'){
                if(pos == 0){
                    dFound = true;
                }
                pos--;
            }else if (s.charAt(x) == 'U'){
                if(pos == -1){
                    uFound = true;
                }
                pos++;
            }

            if(dFound == true && uFound == true){
                count++;
                dFound = false;
                uFound = false;
            }

        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
