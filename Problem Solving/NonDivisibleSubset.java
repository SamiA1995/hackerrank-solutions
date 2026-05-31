import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        boolean divisors_remaining = true;
        while(divisors_remaining) {
            divisors_remaining = false;
            int most_occurences = 0;
            int most_occurences_position = 0;
            for(int i = 0; i < s.size(); i++) {
                int current_occurences = 0;
                for(int j = 0; j < s.size(); j++) {
                    if(i != j) {
                        if((s.get(i) + s.get(j)) % k == 0) {
                            current_occurences++;
                            divisors_remaining = true;
                        }
                    }
                }
                if(current_occurences > most_occurences) {
                    most_occurences = current_occurences;
                    most_occurences_position = i;
                }
            }
            s.remove(most_occurences_position);
        }
        return s.size()+1;         
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}