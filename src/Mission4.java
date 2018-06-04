public class Mission4 extends Mission {

    public Mission4(Game game, Player player) {
        super("Mission4", "Controler 18 territoires avec au moins 2 armees.", game, player);
    }

    @Override
    boolean reached() {

        for (Territory territory : getPlayer().getTerritories()) {
            if (!(territory.getUnits().size()>=2))
                return false;
        }
        return getPlayer().getTerritories().size() >= 18;
    }
}
