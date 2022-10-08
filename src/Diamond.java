import java.util.ArrayList;

public class Diamond implements Jewel{
    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        try{
            if (grid.get(row - 1).get(column - 1) instanceof Diamond) {
                if (grid.get(row - 2).get(column - 2) instanceof Diamond) {
                    return 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(grid.get(row+1).get(column+1) instanceof Diamond){
                if(grid.get(row+2).get(column+2) instanceof Diamond){
                    return 9;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(grid.get(row-1).get(column+1) instanceof Diamond){
                if(grid.get(row-2).get(column+2) instanceof Diamond){
                    return 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(grid.get(row+1).get(column-1) instanceof Diamond){
                if(grid.get(row+2).get(column-2) instanceof Diamond){
                    return 7;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        return 0;
    }

    @Override
    public int getValue() {
        return 30;
    }

    @Override
    public String toString() {
        return "D";
    }
}
