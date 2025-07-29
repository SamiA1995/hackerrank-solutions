import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int formingMagicSquare(List<List<Integer>> s) {
        int difference_sum = 0;
        if(s.get(1).get(1) != 5 && s.get(1).get(1) < 5) {
            difference_sum += 5 - s.get(1).get(1);
            s.get(1).set(1, 5);
        } else if(s.get(1).get(1) != 5 && s.get(1).get(1) > 5) {
            difference_sum += s.get(1).get(1) - 5;
            s.get(1).set(1, 5);
        }
        
        if(s.get(0).get(0) + s.get(2).get(2) != 10) {
            int num = 10 - s.get(2).get(2);
            if(num > s.get(0).get(0)) {
                difference_sum += num - s.get(0).get(0);
            } else {
                difference_sum += s.get(0).get(0) - num;
            }
            s.get(0).set(0, num);
        }
        if(s.get(0).get(1) + s.get(2).get(1) != 10) {
            int num = 10 - s.get(2).get(1);
            if(num > s.get(0).get(1)) {
                difference_sum += num - s.get(0).get(1);
            } else {
                difference_sum += s.get(0).get(1) - num;
            }
            s.get(0).set(1, num);
        }
        if(s.get(0).get(2) + s.get(2).get(0) != 10) {
            int num = 10 - s.get(2).get(0);
            if(num > s.get(0).get(2)) {
                difference_sum += num - s.get(0).get(2);
            } else {
                difference_sum += s.get(0).get(2) - num;
            }
            s.get(0).set(2, num);
        }
        if(s.get(1).get(0) + s.get(1).get(2) != 10) {
            int num = 10 - s.get(1).get(2);
            if(num > s.get(1).get(0)) {
                difference_sum += num - s.get(1).get(0);
            } else {
                difference_sum += s.get(1).get(0) - num;
            }
            s.get(1).set(0, num);
        }
        return difference_sum;
    }

}

public class FormingAMagicSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}