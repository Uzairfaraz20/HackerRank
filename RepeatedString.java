import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //R: O(s.length() + n%s.length()) S: O(1)
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        
        
        //total count
        long count = 0;
        
        //find a's in original string
        for(int x = 0; x < s.length(); x++){
            if(s.charAt(x) == 'a'){
                count++;
            }
        }

        //count full occurences of string s
        long repeats = (n/s.length());

        //multiply number of a's in s by the number
        //if times it appears fully
        count *= repeats;

        //get the remaining non full occurence of string s
        long remainder = (n%s.length());

        //see what a's occur in remainder
        for(int y = 0; y < remainder; y++){
            if(s.charAt(y) == 'a'){
                count++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
