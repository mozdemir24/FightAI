public class Game {

    private Character winner;
    private Character loser;
    private int round;

    public Game(Character winner, Character loser, int round) {
        this.winner = winner;
        this.loser = loser;
        this.round = round;
    }

    public Character getWinner() {
        return winner;
    }

    public void setWinner(Character winner) {
        this.winner = winner;
    }

    public Character getLoser() {
        return loser;
    }

    public void setLoser(Character loser) {
        this.loser = loser;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "Game{" +
                "winner=" + winner +
                ", loser=" + loser +
                ", round=" + round +
                '}';
    }
}
