import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class BeautifulDayAtTheMovies {

    public static int beautifulDays(int i, int j, int k) {
        int beautiful_days = 0;
        while(i <= j) {
            String reverse_int = Integer.toString(i);
            String reverse_int_2 = "";
            int reverse_int_length = 1;
            if(reverse_int.charAt(reverse_int.length()-1) == '0') {
                reverse_int_length++;
            }
            for(int a = reverse_int.length()-reverse_int_length; a >= 0; a--) {
                reverse_int_2 += reverse_int.charAt(a);
            }
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

public class Solution {
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
