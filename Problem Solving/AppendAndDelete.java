import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String appendAndDelete(String s, String t, int k) {
        String convertible = "No";
        
        int substring_length = 0;
        int shorter_string_length = 0;
        if(s.length() <= t.length()) {
            shorter_string_length = s.length();
        } else {
            shorter_string_length = t.length();
        }
        System.out.println(shorter_string_length);
        
        for(int i = 0; i < shorter_string_length; i++) {
            if(s.substring(0, i+1).equals(t.substring(0, i+1))) {
                substring_length++; 
            }
        }
        int deletions = s.length() - substring_length;
        int additions = t.length() - substring_length;
        if(k - deletions - additions == 0 || (k - t.length() >= s.length())) {
            return "Yes";
        }
        
        k -= substring_length;
        if(k % 2 == 0) {
            return "Yes";
        }
        
        k += substring_length;
        int difference = 0;
        if(s.length() >= t.length()) {
            difference = s.length() - t.length();
        } else {
            difference = t.length() - s.length();
        }
        System.out.println(difference);
        if(k >= difference &&
            k % 2 == 0) {
            return "Yes";
        }
        
        return convertible;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}