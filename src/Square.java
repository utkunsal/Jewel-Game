import java.util.ArrayList;

public class Square implements Jewel{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        try {
            if (grid.get(row).get(column - 1) instanceof Square) {
                if (grid.get(row).get(column - 2) instanceof Square) {
                    return 4;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (grid.get(row).get(column + 1) instanceof Square) {
                if (grid.get(row).get(column + 2) instanceof Square) {
                    return 6;
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
        return "S";
    }
}
