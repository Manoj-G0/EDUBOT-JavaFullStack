// Interface CricketPlayer
interface CricketPlayer {
    void beABatter();
    void beABowler();
}

// Class PlayCricket implementing CricketPlayer interface
class PlayCricket implements CricketPlayer {
    @Override
    public void beABatter() {
        System.out.println("I am playing as a batter.");
    }

    @Override
    public void beABowler() {
        System.out.println("I am playing as a bowler.");
    }

    public static void main(String[] args) {
        PlayCricket player = new PlayCricket();
        player.beABatter();
        player.beABowler();
    }
}
