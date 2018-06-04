public class Mission6 extends Mission {

    public Mission6() {
        super("Mission6", "Controler 24 territoires.");
    }


    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 24;
    }
}
