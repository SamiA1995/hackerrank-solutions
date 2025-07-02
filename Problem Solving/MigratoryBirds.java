import java.io.*;
import java.util.*;

class Result {

    public static int migratoryBirds(List<Integer> arr) {
        int[] commonType = new int[arr.size()+1];
        for(int i = 0; i < arr.size(); i++) {
            commonType[arr.get(i)]++;
        }
        int highestFrequency = 0;
        int highestType = 0;
        for(int j = 1; j < commonType.length; j++) {
            if(commonType[j] > highestFrequency) {
                highestFrequency = commonType[j];
                highestType = j;
            } 
        }
        return highestType;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
