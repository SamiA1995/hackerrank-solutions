import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static String appendAndDelete(String s, String t, int k) {
        //Check how much of the first equals the second
        //Keep a count of this  (how much to delete)
        
        //Check the length of the second and add it to how much to delete
        //If it is the same as k, return yes
        
        int deleted_letters = 0;
        int number_of_letters_to_add = 0;
        int shortest_string_length = 0;
        if(s.length() <= t.length()) {
            shortest_string_length = s.length();
        } else {
            shortest_string_length = t.length();
        }
        for(int i = 0; i < shortest_string_length; i++) {
            if(s.charAt(i) == (t.charAt(i))) {
                continue;
            } else {
                deleted_letters = s.length() - i;
                number_of_letters_to_add = t.length() - i;
                break;
            }
        }
        
        if(deleted_letters + number_of_letters_to_add <= k) {
            return "Yes";
        } else {
            return "No";
        }
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
