import java.util.ArrayList;

public class NullJewel implements Jewel{

    @Override
    public int search(ArrayList<ArrayList<Jewel>> grid, int row, int column) {
        return -1;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String toString() {
        return " ";
    }
}
