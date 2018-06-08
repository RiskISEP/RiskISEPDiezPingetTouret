package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission6 extends Mission {

    public Mission6() {
        super("Mission6", "Controler 24 territoires.");
    }


    @Override
    public boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 24;
    }
}
