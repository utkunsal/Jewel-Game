import java.util.ArrayList;

public class Triangle implements Jewel{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        try {
            if (grid.get(row-1).get(column) instanceof Triangle) {
                if (grid.get(row-2).get(column) instanceof Triangle) {
                    return 2;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (grid.get(row+1).get(column) instanceof Triangle) {
                if (grid.get(row+2).get(column) instanceof Triangle) {
                    return 8;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        return 0;
    }

    @Override
    public int getValue() {
        return 15;
    }

    @Override
    public String toString() {
        return "T";
    }
}
