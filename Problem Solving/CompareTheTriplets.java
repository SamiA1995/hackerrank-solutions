import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CompareTheTriplets {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();
        int aliceScore = 0;
        int bobScore = 0;
        for(int i = 0; i < 3; i++) {
            if(a.get(i) < b.get(i)) {
                bobScore += 1;
            } else if(a.get(i) > b.get(i)) {
                aliceScore += 1;
            }
        }
        result.add(aliceScore);
        result.add(bobScore);
        return result;
    }

}