package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission5 extends Mission {

    public Mission5() {
        super("fr.isep.riskIsep.Mission.Mission5", "Controler 30 territoires.");
    }

    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 30;
    }
}
