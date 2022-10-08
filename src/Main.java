public class Main {

    public static void main(String[] args) {
        Player.readLeaderboard("leaderboard.txt");
        Game.createGrid(args[0]);
        Game.play(args[1], "monitoring.txt", "leaderboard.txt");
    }
}
