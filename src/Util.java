import enumerators.Dir;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Util {

    /**
     * Reads a file and returns entire file in a giant string
     * @param fileName
     * @return
     */
    public static String readFile(String fileName) {
        ArrayList<String> lines = readFileLineByLine(fileName);
        StringBuilder sb = new StringBuilder();
        for (String line:lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static ArrayList<String> readFileLineByLine(String fileName) {
        ArrayList<String> ret = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(ret::add); //wizardry
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }


    public static Dir rotateDir(Dir cur, boolean clockwise) {
        //System.out.println("Dir - " + cur + (clockwise?"   R":"   L"));
        if(clockwise) { //RIGHT
            switch (cur) {
                case NORTH:
                    return Dir.EAST;
                case EAST:
                    return Dir.SOUTH;
                case SOUTH:
                    return Dir.WEST;
                case WEST:
                    return Dir.NORTH;
            }
        } else { //LEFT
            switch (cur) {
                case NORTH:
                    return Dir.WEST;
                case WEST:
                    return Dir.SOUTH;
                case SOUTH:
                    return Dir.EAST;
                case EAST:
                    return Dir.NORTH;
            }
        }

        System.err.println("Something went wrong with rotateDir()");
        return cur;
    }

    public static Point moveInDirection(Point old, int distance, Dir dir){
        //System.out.println("Point - " + old.toString() + " Distance - " + distance + " dir -  " + dir.toString());
        switch(dir) {
            case NORTH:
                old.setLocation(old.getX(), old.getY()+distance);
                break;
            case SOUTH:
                old.setLocation(old.getX(), old.getY()-distance);
                break;
            case EAST:
                old.setLocation(old.getX()+distance, old.getY());
                break;
            case WEST:
                old.setLocation(old.getX()-distance, old.getY());
                break;
            default:
                System.err.println("Something went wrong in moveInDirection()");
        }
        //System.out.println("Result - " + old.toString());
        //System.out.println("-------------------------------------------------------------------------------------");
        return old;
    }
}
