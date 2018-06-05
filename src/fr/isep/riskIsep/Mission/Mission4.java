package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import fr.isep.riskIsep.Territory;

public class Mission4 extends Mission {

    public Mission4() {
        super("fr.isep.riskIsep.Mission.Mission4", "Controler 18 territoires avec au moins 2 armees.");
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
