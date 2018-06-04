public class Mission2 extends Mission {

    public Mission2(Game game, Player player) {
        super("Mission2", "Conquerir tous les territoires.", game, player);
    }

    @Override
    boolean reached() {
        return getPlayer().getTerritories().size() == 42;
    }
}
