import java.io.*;
import java.util.*;

class Result {
    public static int birthdayCakeCandles(List<Integer> candles) {
        int total = 0;
        int tallestCandle = 0;
        for(int i = 0; i < candles.size(); i++) {
            if(candles.get(i) > tallestCandle) {
                tallestCandle = candles.get(i);
            }
        }
        for(int j = 0; j < candles.size(); j++) {
            if(candles.get(j) == tallestCandle) {
                total += 1;
            }
        }
        return total;
    }

}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] candlesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < candlesCount; i++) {
            int candlesItem = Integer.parseInt(candlesTemp[i]);
            candles.add(candlesItem);
        }

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
