public class Mission8 extends Mission {

    public Mission8(Game game, Player player) {
        super("Mission8", "Controler l'Asie et une autre region.", game, player);
    }

    @Override
    boolean reached() {

        Region asia = null;
        for (Region region :
                getGame().getRegions()) {
            if (region.getName().equals("Asia")) {
                asia = region;
                break;
            }
        }

        return (getPlayer().getRegions().contains(asia)) && (getPlayer().getRegions().size() >= 2);
    }
}
