import java.util.ArrayList;

public class MinusSign extends MathSymbol{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {

        try {
            if (grid.get(row).get(column - 1) instanceof MathSymbol) {
                if (grid.get(row).get(column - 2) instanceof MathSymbol) {
                    return 4;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (grid.get(row).get(column + 1) instanceof MathSymbol) {
                if (grid.get(row).get(column + 2) instanceof MathSymbol) {
                    return 6;
                }
            }
        } catch (IndexOutOfBoundsException e){}

        return 0;
    }
    @Override
    public String toString() {
        return "-";
    }
}
