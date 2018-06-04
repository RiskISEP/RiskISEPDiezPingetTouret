public class Mission8 extends Mission {

    public Mission8() {
        super("Mission8", "Controler l'Asie et une autre region.");
    }


    @Override
    boolean reached(Game game, Player player) {
        Region asia = null;
        for (Region region :
                game.getRegions()) {
            if (region.getName().equals("Asia")) {
                asia = region;
                break;
            }
        }

        return (player.getRegions().contains(asia)) && (player.getRegions().size() >= 2);
    }
}
