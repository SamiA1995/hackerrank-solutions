import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CatsAndAMouse {

    static String catAndMouse(int x, int y, int z) {
        boolean cat_a_on_mouse = false;
        boolean cat_b_on_mouse = false;
        for(int i = 0; i < 100; i++) {
            if(x == z-i || x == z+i) {
                cat_a_on_mouse = true;
            }
            if(y == z-i || y == z+i) {
                cat_b_on_mouse = true;
            }
            
            if(cat_a_on_mouse && cat_b_on_mouse) {
                return "Mouse C";
            } else if(cat_a_on_mouse) {
                return "Cat A";
            } else if(cat_b_on_mouse) {
                return "Cat B";
            }
        }
        return "Mouse C";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
