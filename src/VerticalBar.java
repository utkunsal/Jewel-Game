import java.util.ArrayList;

public class VerticalBar extends MathSymbol{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        try {
            if (grid.get(row-1).get(column) instanceof MathSymbol) {
                if (grid.get(row-2).get(column) instanceof MathSymbol) {
                    return 2;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (grid.get(row+1).get(column) instanceof MathSymbol) {
                if (grid.get(row+2).get(column) instanceof MathSymbol) {
                    return 8;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        return 0;
    }
    @Override
    public String toString() {
        return "|";
    }
}
