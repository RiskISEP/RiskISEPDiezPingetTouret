package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission6 extends Mission {

    public Mission6() {
        super("fr.isep.riskIsep.Mission.Mission6", "Controler 24 territoires.");
    }


    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 24;
    }
}
