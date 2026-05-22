import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        int length_of_cut;
        List<Integer> sticks_cut = new ArrayList<Integer>();
        sticks_cut.add(arr.size());
        int sticks_left = arr.size();
    
        while(sticks_left != 0) {
            sticks_left = 0;
            length_of_cut = 1000;
            
            for(int i = 0; i < arr.size(); i++) {
                if (arr.get(i) < length_of_cut && arr.get(i) > 0) {
                    length_of_cut = arr.get(i);
                }
            }   
            
            for(int j = 0; j < arr.size(); j++) {
                arr.set(j, arr.get(j)-length_of_cut);
                if(arr.get(j) > 0) {
                    sticks_left++;
                }
            }
            if(sticks_left == 0) {
                return sticks_cut;
            }
            sticks_cut.add(sticks_left);
        } 
        
        return sticks_cut;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.cutTheSticks(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}