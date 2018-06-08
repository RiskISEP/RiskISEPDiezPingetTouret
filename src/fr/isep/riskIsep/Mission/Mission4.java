package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import fr.isep.riskIsep.Territory;

public class Mission4 extends Mission {

    public Mission4() {
        super("Mission4", "Controler 18 territoires\navec au moins 2 armees.");
    }


    @Override
    public boolean reached(Game game, Player player) {
        for (Territory territory : player.getTerritories()) {
            if (!(territory.getUnits().size()>=2))
                return false;
        }
        return player.getTerritories().size() >= 18;
    }
}
