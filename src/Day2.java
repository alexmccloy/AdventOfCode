import java.util.ArrayList;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Day2 implements Day {
    ArrayList<String> lines;

    public Day2(String inFile) {
        lines = Util.readFileLineByLine(inFile);
    }

    @Override
    public String run() {
        StringBuilder sb = new StringBuilder();
        int curNum = 5;
        for (String line : lines) {
            int nextNum = sumNumPadInputLine(line, curNum);
            sb.append(nextNum);
            curNum = nextNum;
        }
        return sb.toString();
    }

    private int sumNumPadInputLine(String l, int previousNum) {
        Pair<Integer, Integer> previousCoord = getNumpadCoords(previousNum);
        //Count occurances of each UDLR
        int U = l.length() - l.replace("U", "").length();
        int D = l.length() - l.replace("D", "").length();
        int L = l.length() - l.replace("L", "").length();
        int R = l.length() - l.replace("R", "").length();

        int row = previousCoord.getLeft() + D - U;
        int col = previousCoord.getRight() + R - L;

        return getNumPadChar(row, col);
    }

    /*
    col  0 1 2   row
       [ 1 2 3 ]   0
       [ 4 5 6 ]   1
       [ 7 8 9 ]   2
     */
    private int getNumPadChar(int row, int col) {

        return 1 + boundInt(col,0,2) + (3 * boundInt(row,0,2));
    }

    //(row,col)
    private Pair<Integer,Integer> getNumpadCoords(int n) {
        return new Pair<Integer, Integer>((n-1)/3, (n%3)-1);
    }

    private int boundInt(int i, int lower, int upper) {
        if (i < lower) i = lower;
        if (i > upper) i = upper;
        return i;
    }
}
