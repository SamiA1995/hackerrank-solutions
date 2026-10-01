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
        int deleted_letters = 0;
        int number_of_letters_to_add = 0;
        int shortest_string_length = 0;
        if(s.length() <= t.length()) {
            shortest_string_length = s.length();
        } else {
            shortest_string_length = t.length();
        }
        int i = 0;
        for(; i < shortest_string_length; i++) {
            if(s.charAt(i) == (t.charAt(i))) {
                continue;
            } else {
                break;
            }
        }

        deleted_letters = s.length() - i;
        number_of_letters_to_add = t.length() - (s.length() - deleted_letters);
        int difference = t.length() - shortest_string_length;
        if(deleted_letters + number_of_letters_to_add == k || 
        deleted_letters + number_of_letters_to_add < k && difference % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

}

public class AppendAndDelete {
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