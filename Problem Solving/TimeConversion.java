import java.io.*;

class Result {

    public static String timeConversion(String s) {
        String[] timeHMS = s.split(":");
        String timeH = timeHMS[0];
        String timeM = timeHMS[1];
        String timeS = timeHMS[2].substring(0,2);
        String ampm = timeHMS[2].substring(2,4);
        
        if(ampm.equals("AM")) {
            if(timeH.equals("12")) {
                timeH = "00";
            }
            return timeH + ":" + timeM + ":" + timeS;
        } else {
            if(timeH.equals("12")) {
                timeH = "00";
            }
            int time24H = 12 + Integer.valueOf(timeH);
            return time24H + ":" + timeM + ":" + timeS;
        }
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
