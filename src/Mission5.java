public class Mission5 extends Mission {

    public Mission5(Game game, Player player) {
        super("Mission5", "Controler 30 territoires.", game, player);
    }

    @Override
    boolean reached() {
        return getPlayer().getTerritories().size() >= 30;
    }
}
