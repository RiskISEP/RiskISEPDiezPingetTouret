public class Mission7 extends Mission {

    public Mission7() {
        super("Mission7", "Controler 21 territoires");
    }


    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 21;
    }
}
