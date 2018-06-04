public class Mission5 extends Mission {

    public Mission5() {
        super("Mission5", "Controler 30 territoires.");
    }

    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 30;
    }
}
