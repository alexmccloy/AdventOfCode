import enumerators.Dir;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by amccl_000 on 04/12/2016.
 * http://adventofcode.com/2016/day/1
 */
public class Day1 implements Day {
    final String input = "L3, R1, L4, L1, L2, R4, L3, L3, R2, R3, L5, R1, R3, L4, L1, L2, R2, R1, L4, L4, R2, L5, R3, R2, R1, L1, L2, R2, R2, L1, L1, R2, R1, L3, L5, R4, L3, R3, R3, L5, L190, L4, R4, R51, L4, R5, R5, R2, L1, L3, R1, R4, L3, R1, R3, L5, L4, R2, R5, R2, L1, L5, L1, L1, R78, L3, R2, L3, R5, L2, R2, R4, L1, L4, R1, R185, R3, L4, L1, L1, L3, R4, L4, L1, R5, L5, L1, R5, L1, R2, L5, L2, R4, R3, L2, R3, R1, L3, L5, L4, R3, L2, L4, L5, L4, R1, L1, R5, L2, R4, R2, R3, L1, L1, L4, L3, R4, L3, L5, R2, L5, L1, L1, R2, R3, L5, L3, L2, L1, L4, R4, R4, L2, R3, R1, L2, R1, L2, L2, R3, R3, L1, R4, L5, L3, R4, R4, R1, L2, L5, L3, R1, R4, L2, R5, R4, R2, L5, L3, R4, R1, L1, R5, L3, R1, R5, L2, R1, L5, L2, R2, L2, L3, R3, R3, R1";
    //final String input = "L1, R2, L5, L2, R4, R3, L2";
    Dir dir;
    Point pos;


    public Day1(String inFile) {
        dir = Dir.NORTH;
        pos = new Point(0, 0);
    }

    @Override
    public String run() {
        int count = 0;
        //Add instructions to iterable list
        ArrayList<String> instructions = new ArrayList<>();
        ArrayList<Point> visitedPoints = new ArrayList<>();
        for (String s : input.split(",")) {
            instructions.add(s.trim());
        }

        for (String instruction : instructions) {
            count++;
            //System.out.println(pos + " - " + instruction);
            String newDir = instruction.substring(0, 1);
            String dist = instruction.substring(1);
            //Rotate then move
            dir = Util.rotateDir(dir, newDir.equals("R"));
            for (int i = 0; i < Integer.valueOf(dist); i++) {
                pos = Util.moveInDirection(pos, 1, dir);
                //Check if visted this point before with lambda magic
                visitedPoints.forEach(p -> {if(pos.equals(p)) System.out.println("Visited point twice: " + pos);});
                visitedPoints.add(new Point(pos));
            }
        }

        System.out.println("Count is " + count);
        return "Pos:" + pos.toString() + ", Dir:" + dir;
    }
}
