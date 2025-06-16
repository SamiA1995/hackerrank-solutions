
import java.util.List;

class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1 = 0;
        int diag2 = 0;
        for(int i = 0; i < arr.size(); i++) {
            diag1 += arr.get(i).get(i);
            diag2 += arr.get(i).get(arr.size()-1-i);
        }
        
        int difference = diag1 - diag2;
        if(diag1 - diag2 < 0) {
            return diag2 - diag1;
        } else {
            return difference;
        }
    }
}