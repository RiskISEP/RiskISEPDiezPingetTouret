public class Mission4 extends Mission {

    public Mission4() {
        super("Mission4", "Controler 18 territoires avec au moins 2 armees.");
    }


    @Override
    boolean reached(Game game, Player player) {
        for (Territory territory : player.getTerritories()) {
            if (!(territory.getUnits().size()>=2))
                return false;
        }
        return player.getTerritories().size() >= 18;
    }
}
