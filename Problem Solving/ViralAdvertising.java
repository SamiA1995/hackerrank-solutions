import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class ViralAdvertising {

    public static int viralAdvertising(int n) {
        int shared = 5;
        int cumulative = 2;
        int liked = 2;
        
        if(n == 1) {
            return 2;
        } else {
            for(int i = 1; i < n; i++) {
                shared = liked * 3;
                liked = shared / 2;
                cumulative += liked;
            }
        }
        
        return cumulative;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}