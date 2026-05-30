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
        int potential_divisors_size = s.size()*s.size();
        int potential_divisors_index = 0;
        //Get all the permutations and put the sums which are divisible by k
        //into the potential divisors double array.
        while(number_divisible != 0) {
            number_divisible = 0;
            int[] potential_divisors = new int[potential_divisors_size];
            for(int i = 0; i < s.size()-1; i++) {
                for(int j = i+1; j < s.size(); j++) {
                    if((s.get(i) + s.get(j)) % k == 0) {
                        potential_divisors[potential_divisors_index] = s.get(i);
                        potential_divisors_index++;
                        potential_divisors[potential_divisors_index] = s.get(j);
                        potential_divisors_index++;
                        number_divisible++;
                    }
                }
            }
            
            //If none of the permutations sum to a values not divisible by k
            //return the size of s (the original array with numbers removed).
            if(number_divisible == 0) {
                return s.size();
            }
            
            //An array to store the number of times each number in s occurs
            //in the potential divisors double array.
            int[] occurences = new int[s.size()];
            for(int i = 0; i < occurences.length; i++) {
                occurences[i] = 0;
            }
            
            //Go through potential divisors, and check how many times s 
            //appears.
            for(int i = 0; i < s.size(); i++) {
                for(int j = 0; j < potential_divisors.length; j++) {
                    if(s.get(i) == potential_divisors[j]) {
                        occurences[i]++;
                    }
                }
            }
            
            //Get the most occurrences and its position and remove from s
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