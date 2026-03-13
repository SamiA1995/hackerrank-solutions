import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class BeautifulDaysAtTheMovies {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
        int beautiful_days = 0;
        while(i <= j) {
            String reverse_int = Integer.toString(i);
            // for(int a = 0; a <) {
                
            // }
            String reverse_int_2 = "" + reverse_int.charAt(1) + reverse_int.charAt(0);
            int reverse_int_3 = Integer.parseInt(reverse_int_2);
            System.out.println(reverse_int_3);
            int reverse = i - reverse_int_3;
            float result = (float) reverse / k;
            System.out.println(result);
            if(result % 1 == 0) {
                beautiful_days++;
            }
            i++;
            System.out.println();
        }
        return beautiful_days;
    }

}

public class BeautifulDayAtTheMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
