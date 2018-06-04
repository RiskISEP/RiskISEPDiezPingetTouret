public class Mission3 extends Mission {

    public Mission3() {
        super("Misssion3", "Controler 3 regions et au moins 18 territoires");
    }


    @Override
    boolean reached(Game game, Player player) {
        return (player.getRegions().size() >= 3) && (player.getTerritories().size() > 18);
    }
}
