import enumerators.Dir;

/**
 * Created by amccl_000 on 04/12/2016.
 */
public class Util {
    public Dir rotateDir(Dir cur, boolean clockwise) {
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
}
