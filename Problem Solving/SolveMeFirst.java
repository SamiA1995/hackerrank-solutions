import java.util.*;

public class SolveMeFirst {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
	}

    static int solveMeFirst(int a, int b) {
        return a+b;
    }
}