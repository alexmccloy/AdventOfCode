import enumerators.Dir;

import java.awt.*;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Util {
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
