import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int beautifulDays(int i, int j, int k) {
        int beautiful_days = 0;
        
        for(; i <= j; i++) {
            String int_to_string = Integer.toString(i);
            String reverse_int_string = "";
            for(int l = int_to_string.length()-1; l >= 0; l--) {
                reverse_int_string += int_to_string.charAt(l);
            }
            int reverse_int = Integer.parseInt(reverse_int_string);
            
            if((i - reverse_int) % k == 0) {
                beautiful_days++;
            }
        }
        
        return beautiful_days;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
