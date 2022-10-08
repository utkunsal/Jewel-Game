import java.util.ArrayList;

public interface Jewel {

    int search(ArrayList<ArrayList<Jewel>> grid, int row, int column);
    // returns the direction of the match, returns 0 if there is no match, returns -1 if the coordinates are not valid.
    // 1 2 3
    // 4 x 6 , x is the chosen jewel.
    // 7 8 9

    int getValue();
}
