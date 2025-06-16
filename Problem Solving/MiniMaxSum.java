import java.io.*;
import java.util.*;

class Result {

    public static void miniMaxSum(List<Integer> arr) {
        long biggest = arr.get(0);
        int biggestPosition = 0;
        long smallest = arr.get(0);
        int smallestPosition = 0;
        for (int i = 1; i < arr.size(); i++) {
            long current = arr.get(i);
            if(current < smallest) {
                smallest = current;
                smallestPosition = i;
            } else if (current > biggest){
                biggest = current;
                biggestPosition = i;
            }
        }
        
        long smallestSum = 0;
        long biggestSum = 0;
        for(int j = 0; j < arr.size(); j++) {
            if(j != biggestPosition) {
                smallestSum += arr.get(j);
            }
            if(j != smallestPosition) {
                biggestSum += arr.get(j);
            }
        }
        System.out.print(smallestSum + " " + biggestSum);
    }
}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}