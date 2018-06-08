package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public class Mission7 extends Mission {

    public Mission7() {
        super("Mission7", "Controler 21 territoires");
    }


    @Override
    public boolean reached(Game game, Player player) {
        return player.getTerritories().size() >= 21;
    }
}
