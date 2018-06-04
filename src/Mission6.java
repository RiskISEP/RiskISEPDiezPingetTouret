public class Mission6 extends Mission {

    public Mission6(Game game, Player player) {
        super("Mission6", "Controler 24 territoires.", game, player);
    }

    @Override
    boolean reached() {
        return getPlayer().getTerritories().size() >= 24;
    }
}
