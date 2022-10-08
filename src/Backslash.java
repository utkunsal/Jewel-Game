import java.util.ArrayList;

public class Backslash extends MathSymbol{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        try{
            if (grid.get(row - 1).get(column - 1) instanceof MathSymbol) {
                if (grid.get(row - 2).get(column - 2) instanceof MathSymbol) {
                    return 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(grid.get(row+1).get(column+1) instanceof MathSymbol){
                if(grid.get(row+2).get(column+2) instanceof MathSymbol){
                    return 9;
                }
            }
        } catch (IndexOutOfBoundsException e) {}

        return 0;
    }
    @Override
    public String toString() {
        return "\\";
    }
}
