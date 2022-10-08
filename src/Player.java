import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player implements Comparable<Player> {
    private String name;
    private int score;
    private static ArrayList<Player> players = new ArrayList<>();


    public Player(){
        players.add(this);
    }

    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.score, score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateScore(int points){
        score += points;
    }

    public int getTotalScore() {
        return score;
    }

    public static void readLeaderboard(String fileName){
        try {
            Scanner f = new Scanner(new File(fileName));
            while (f.hasNextLine()){
                String[] line = f.nextLine().trim().split(" ");
                if (line.length >= 2)
                    players.add(new Player(line[0],Integer.parseInt(line[1])));
            }
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getRank(){
        Collections.sort(players);
        int rank = Collections.binarySearch(players, this) + 1;
        int playerCount = players.size();
        return String.format("%d/%d",rank,playerCount);
    }

    public int compareScoreToThePlayerInFront(){
        try {
            Collections.sort(players);
            int index = Collections.binarySearch(players, this);
            return players.get(index - 1).score - this.score;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public int compareScoreToThePlayerBehind(){
        try {
            Collections.sort(players);
            int index = Collections.binarySearch(players, this);
            return this.score - players.get(index + 1).score;
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }
}
