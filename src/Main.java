import java.util.ArrayList;
import java.util.List;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Main {
    static List<Day> Days;

    public static void main(final String[] args) {
        Days = new ArrayList<>();
        Days.add(new Day1("inputs/Day1.txt"));
        Days.add(new Day2("inputs/test/Day2.txt"));

        int[] daysToRun = {2};
        runDays(daysToRun);
    }

    private static void runDays(int[] daysToRun) {
        for(int i:daysToRun){
            System.out.println("Day " + Integer.valueOf(i) + " result:\n" + Days.get(i-1).run());
        }
    }
}
