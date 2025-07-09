import java.io.*;
import java.util.*;

class Result {

    public static int sockMerchant(int n, List<Integer> ar) {
        int total_pairs = 0;
        for(int i = 0; i < ar.size()-1; i++) {
            for(int j = i+1; j < ar.size(); j++) {
                if(ar.get(j) == -1) {
                    continue;
                }
                if(ar.get(i) == ar.get(j)) {
                    total_pairs++;
                    ar.set(i, -1);
                    ar.set(j, -1);
                }
            }
        }
        return total_pairs;
    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
