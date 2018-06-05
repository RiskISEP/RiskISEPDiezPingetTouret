package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission2 extends Mission {

    public Mission2() {
        super("fr.isep.riskIsep.Mission.Mission2", "Conquerir tous les territoires.");
    }

    @Override
    boolean reached(Game game, Player player) {
        return player.getTerritories().size() == 42;
    }
}
