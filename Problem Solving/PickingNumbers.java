import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int pickingNumbers(List<Integer> a) {
        int max_size = 0;
        for(int i = 0; i < a.size(); i++) {
            int current_size = 0;
            for(int j = 0; j < a.size(); j++) {
                if(a.get(j) == a.get(i) || a.get(j) == a.get(i)+1) {
                    current_size += 1;
                }
            }
            if(current_size > max_size) {
                max_size = current_size;
            }
        }
        return max_size;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}