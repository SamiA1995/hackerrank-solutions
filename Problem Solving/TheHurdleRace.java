import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int hurdleRace(int k, List<Integer> height) {
        int max_hurdle = k;
        for(int i = 0; i < height.size(); i++) {
            if(height.get(i) > max_hurdle) {
                max_hurdle = height.get(i);
            }
        }
        return max_hurdle - k;
    }

}

public class TheHurdleRace {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] heightTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> height = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightTemp[i]);
            height.add(heightItem);
        }

        int result = Result.hurdleRace(k, height);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
