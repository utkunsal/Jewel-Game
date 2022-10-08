import java.util.ArrayList;

public class Wildcard implements Jewel{

    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {

        try {
            if (!(grid.get(row-2).get(column) instanceof NullJewel || grid.get(row-1).get(column) instanceof NullJewel)) {
                if (grid.get(row-1).get(column) instanceof Wildcard || grid.get(row-2).get(column) instanceof Wildcard ||
                        grid.get(row-1).get(column).getClass().equals(grid.get(row-2).get(column).getClass())) {
                    return 2;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (!(grid.get(row+2).get(column) instanceof NullJewel || grid.get(row+1).get(column) instanceof NullJewel)) {
                if (grid.get(row+1).get(column) instanceof Wildcard || grid.get(row+2).get(column) instanceof Wildcard ||
                        grid.get(row+1).get(column).getClass().equals(grid.get(row+2).get(column).getClass())) {
                    return 8;
                }
            }
        } catch (IndexOutOfBoundsException e){}

        try {
            if (!(grid.get(row).get(column - 2) instanceof NullJewel || grid.get(row).get(column - 1) instanceof NullJewel)) {
                if (grid.get(row).get(column - 1) instanceof Wildcard || grid.get(row).get(column - 2) instanceof Wildcard ||
                        grid.get(row).get(column - 1).getClass().equals(grid.get(row).get(column - 2).getClass())) {
                    return 4;
                }
            }
        } catch (IndexOutOfBoundsException e){}
        try {
            if (!(grid.get(row).get(column + 2) instanceof NullJewel || grid.get(row).get(column + 1) instanceof NullJewel)) {
                if (grid.get(row).get(column + 1) instanceof Wildcard || grid.get(row).get(column + 2) instanceof Wildcard ||
                        grid.get(row).get(column + 1).getClass().equals(grid.get(row).get(column + 2).getClass())) {
                    return 6;
                }
            }
        } catch (IndexOutOfBoundsException e){}

        try{
            if (!(grid.get(row - 2).get(column - 2) instanceof NullJewel || grid.get(row - 1).get(column - 1) instanceof NullJewel)) {
                if (grid.get(row - 1).get(column - 1) instanceof Wildcard || grid.get(row - 2).get(column - 2) instanceof Wildcard ||
                        grid.get(row - 1).get(column - 1).getClass().equals(grid.get(row - 2).get(column - 2).getClass())) {
                    return 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(!(grid.get(row+2).get(column+2) instanceof NullJewel || grid.get(row+1).get(column+1) instanceof NullJewel)){
                if(grid.get(row+1).get(column+1) instanceof Wildcard || grid.get(row+2).get(column+2) instanceof Wildcard ||
                        grid.get(row+1).get(column+1).getClass().equals(grid.get(row+2).get(column+2).getClass())){
                    return 9;
                }
            }
        } catch (IndexOutOfBoundsException e) {}

        try{
            if(!(grid.get(row-2).get(column+2) instanceof NullJewel || grid.get(row-1).get(column+1) instanceof NullJewel)){
                if(grid.get(row-1).get(column+1) instanceof Wildcard || grid.get(row-2).get(column+2) instanceof Wildcard ||
                        grid.get(row-1).get(column+1).getClass().equals(grid.get(row-2).get(column+2).getClass())){
                    return 3;
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        try{
            if(!(grid.get(row+2).get(column-2) instanceof NullJewel || grid.get(row+1).get(column-1) instanceof NullJewel)){
                if(grid.get(row+1).get(column-1) instanceof Wildcard || grid.get(row+2).get(column-2) instanceof Wildcard ||
                        grid.get(row+1).get(column-1).getClass().equals(grid.get(row+2).get(column-2).getClass())){
                    return 7;
                }
            }
        } catch (IndexOutOfBoundsException e) {}

        return 0;
    }

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public String toString() {
        return "W";
    }
}
