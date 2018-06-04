public class Mission2 extends Mission {

    public Mission2() {
        super("Mission2", "Conquerir tous les territoires.");
    }

    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() == 42;
    }
}
