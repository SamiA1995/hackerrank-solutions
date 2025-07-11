import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int pageCount(int n, int p) {
        int number_of_turns_from_1 = 0;
        int number_of_turns_from_n = 0;
        boolean is_even_number = isEvenNumber(p);
        int p_counter = p;
        if(is_even_number) {
            p_counter++;
        } else {
            p_counter--;
        }
        
        int pageNumber = 1;
        while(pageNumber != p && pageNumber != p_counter) {
            pageNumber += 2;
            number_of_turns_from_1++;
        }
        pageNumber = n;
        while(pageNumber != p && pageNumber != p_counter) {
            pageNumber -= 2;
            number_of_turns_from_n++;
        }
        
        if(number_of_turns_from_1 < number_of_turns_from_n) {
            return number_of_turns_from_1;
        } else {
            return number_of_turns_from_n;
        }
    }
    
    public static boolean isEvenNumber(int p) {
        if(p % 2 == 0) {
            return true;
        } {
            return false;
        }
    }
}

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
