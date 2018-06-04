public class Mission3 extends Mission {

    public Mission3(Game game, Player player) {
        super("Misssion3", "Controler 3 regions et au moins 18 territoires", game, player);
    }

    @Override
    boolean reached() {
        return (getPlayer().getRegions().size() >= 3) && (getPlayer().getTerritories().size() > 18);
    }
}
