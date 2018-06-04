public class Mission7 extends Mission {

    public Mission7(Game game, Player player) {
        super("Mission7", "Controler 21 territoires", game, player);
    }

    @Override
    boolean reached() {
        return getPlayer().getTerritories().size() >= 21;
    }
}
