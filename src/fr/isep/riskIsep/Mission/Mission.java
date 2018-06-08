package fr.isep.riskIsep.Mission;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;

public abstract class Mission {

    private String name;
    private String description;

    public Mission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    La mission est elle accomplie ?
    public abstract boolean reached(Game game, Player player);


}
