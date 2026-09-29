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
        for(int i = 0; i < t.length(); i++) {
            if(s.substring(0, i+1).equals(t.substring(0, i+1))) {
                substring_length++; 
            }
        }
        int deletions = s.length() - substring_length;
        int additions = t.length() - substring_length;
        if(k - deletions - additions == 0) {
            convertible = "Yes";
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