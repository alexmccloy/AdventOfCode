import java.util.ArrayList;
import java.util.List;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Main {
    static List<Day> Days;

    public static void main(final String[] args) {
        Days = new ArrayList<>();
        Days.add(new Day1());

        int[] daysToRun = {1};
        runDays(daysToRun);
    }

    private static void runDays(int[] daysToRun) {
        for(int i:daysToRun){
            System.out.println("Day " + Integer.valueOf(i-1) + " result:\n" + Days.get(i-1).run());
        }
    }
}
