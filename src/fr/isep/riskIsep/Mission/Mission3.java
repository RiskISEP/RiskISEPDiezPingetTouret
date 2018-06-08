package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission3 extends Mission {

    public Mission3() {
        super("Misssion3", "Controler 3 regions et\nau moins 18 territoires");
    }


    @Override
    public boolean reached(Game game, Player player) {
        return (player.getRegions().size() >= 3) && (player.getTerritories().size() > 18);
    }
}
