import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int number_divisible = s.size();
        while(number_divisible != 0) {
            number_divisible = 0;
            int[][] potential_divisors = new int[s.size()][2];
            for(int i = 0; i < s.size(); i++) {
                for(int j = i+1; j < s.size(); j++) {
                    if((s.get(i) + s.get(j)) % k == 0) {
                        potential_divisors[i][0] = s.get(i);
                        potential_divisors[i][1] = s.get(j);
                        number_divisible++;
                    }
                }
            }
            if(number_divisible == 0) {
                return s.size();
            }
            
            int[] occurences = new int[s.size()];
            for(int i = 0; i < occurences.length; i++) {
                occurences[i] = 0;
            }
            
            for(int i = 0; i < s.size(); i++) {
                for(int j = 0; j < potential_divisors.length; j++) {
                    if(s.get(i) == potential_divisors[j][0]) {
                        occurences[i]++;
                    }
                    if(s.get(i) == potential_divisors[j][1]) {
                        occurences[i]++;
                    }
                }
            }
            
            int most_occurences = occurences[0];
            int most_occurences_position = 0;
            for(int i = 1; i < occurences.length; i++) {
                if(occurences[i] > most_occurences) {
                    most_occurences = occurences[i];
                    most_occurences_position = i;
                }
            }
            s.remove(most_occurences_position);
            }
        return s.size();
    }
}

public class NonDivisibleSubset {
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
