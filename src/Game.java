import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static ArrayList<ArrayList<Jewel>> grid = new ArrayList<>();
    private static Player player = new Player();

    public static void createGrid(String gameGrid){
        try {
            Scanner f = new Scanner(new File(gameGrid));
            while (f.hasNextLine()) {
                String[] line = f.nextLine().split(" ");
                ArrayList<Jewel> row = new ArrayList<>();
                for (String jewel: line){
                    switch (jewel){
                        case "D":
                            row.add(new Diamond());
                            break;
                        case "S":
                            row.add(new Square());
                            break;
                        case "T":
                            row.add(new Triangle());
                            break;
                        case "W":
                            row.add(new Wildcard());
                            break;
                        case "/":
                            row.add(new Slash());
                            break;
                        case "-":
                            row.add(new MinusSign());
                            break;
                        case "+":
                            row.add(new PlusSign());
                            break;
                        case "\\":
                            row.add(new Backslash());
                            break;
                        case "|":
                            row.add(new VerticalBar());
                            break;
                    }
                }
                grid.add(row);
            }
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void play(String commandFile, String outputFile, String leaderboard){
        try {

            FileWriter out = new FileWriter(outputFile);
            out.write("Game grid:\n\n");
            out.write(getGridAsString());

            Scanner commands = new Scanner(new File(commandFile));

            while (commands.hasNextLine()){
                String line = commands.nextLine().trim();
                if (line.equals("E")){
                    out.write("Select coordinate or enter E to end the game: E\n\n");
                    out.write(String.format("Total score: %d points\n\n", player.getTotalScore()));
                    String playerName = commands.nextLine().trim();
                    player.setName(playerName);
                    out.write(String.format("Enter name: %s\n\n", playerName));

                    int rank = Integer.parseInt(player.getRank().split("/")[0]);
                    int playerCount = Integer.parseInt(player.getRank().split("/")[1]);
                    if (rank == 1)
                        out.write(String.format("Your rank is %s, your score is %d points higher than %s\n\n", player.getRank(),
                                player.compareScoreToThePlayerBehind(), Player.getPlayers().get(rank)));
                    else if (rank == playerCount)
                        out.write(String.format("Your rank is %s, your score is %d points lower than Bob\n\n", player.getRank(),
                                player.compareScoreToThePlayerInFront(), Player.getPlayers().get(rank-2)));
                    else
                        out.write(String.format("Your rank is %s, your score is %d points lower than %s and %d points higher than %s\n\n",
                                player.getRank(), player.compareScoreToThePlayerInFront(), Player.getPlayers().get(rank-2),
                                player.compareScoreToThePlayerBehind(), Player.getPlayers().get(rank)));
                    out.write("Good bye!");

                    FileWriter lb = new FileWriter(leaderboard, true);
                    lb.write(String.format("\n%s %d", player, player.getTotalScore()));
                    lb.close();
                    break;
                } else {
                    String[] coordinates = line.split(" ");
                    int row = Integer.parseInt(coordinates[0]);
                    int column = Integer.parseInt(coordinates[1]);

                    out.write(String.format("Select coordinate or enter E to end the game: %d %d\n\n",row,column));

                    if (row >= grid.size() || column >= grid.get(0).size() || row < 0 || column < 0){
                        out.write("Please enter a valid coordinate\n\n");
                        continue;
                    }

                    Jewel chosenJewel = grid.get(row).get(column);
                    int pointsEarned;
                    switch (chosenJewel.search(grid,row,column)){
                        // search returns the direction of the match, returns 0 if there is no match, returns -1 if the coordinates are not valid.
                        // 1 2 3
                        // 4 x 6 , x is the chosen jewel.
                        // 7 8 9
                        case -1:
                            out.write("Please enter a valid coordinate\n\n");
                            break;
                        case 0:
                            out.write(getGridAsString());
                            out.write("Score: 0 points\n\n");
                            break;
                        case 1:
                            pointsEarned = delete(row,column,row-1,column-1,row-2,column-2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 2:
                            pointsEarned = delete(row,column,row-1,column,row-2,column);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 3:
                            pointsEarned = delete(row,column,row-1,column+1,row-2,column+2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 4:
                            pointsEarned = delete(row,column,row,column-1,row,column-2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 6:
                            pointsEarned = delete(row,column,row,column+1,row,column+2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 7:
                            pointsEarned = delete(row,column,row+1,column-1,row+2,column-2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 8:
                            pointsEarned = delete(row,column,row+1,column,row+2,column);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                        case 9:
                            pointsEarned = delete(row,column,row+1,column+1,row+2,column+2);
                            out.write(getGridAsString());
                            out.write(String.format("Score: %d points\n\n",pointsEarned));
                            break;
                    }


                }
            }

        commands.close();
        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static int delete(int y1,int x1,int y2,int x2,int y3,int x3){ // returns earned points.
        int p1 = grid.get(y1).get(x1).getValue();
        grid.get(y1).set(x1, new NullJewel());
        int p2 = grid.get(y2).get(x2).getValue();
        grid.get(y2).set(x2, new NullJewel());
        int p3 = grid.get(y3).get(x3).getValue();
        grid.get(y3).set(x3, new NullJewel());
        int points = p1+p2+p3;
        player.updateScore(points);


        int b = grid.get(grid.size()-1).size()-1;
        while (b >= 0){
            int a = grid.size()-1;
            while (a >= 1) {
                if (grid.get(a).get(b) instanceof NullJewel) {
                    int z = 1;
                    if (a-1 > 0)
                        if (grid.get(a-1).get(b) instanceof NullJewel) {
                            z = 2;
                            if (a-2 > 0)
                                if (grid.get(a-2).get(b) instanceof NullJewel)
                                    z = 3; }
                    grid.get(a).set(b, grid.get(a - z).get(b));
                    grid.get(a - z).set(b, new NullJewel());
                }
                a--;
            }
            b--;
        }
        return points;
    }

    private static String getGridAsString(){
        return grid.toString().replace("]]","\n\n").replace("], ","\n").replace("[","").replace(",","");
    }

}
