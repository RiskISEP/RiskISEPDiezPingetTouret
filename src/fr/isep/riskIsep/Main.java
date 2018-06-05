package fr.isep.riskIsep;

import fr.isep.riskIsep.gui.States;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {

		Game game = new Game();

		AppGameContainer gameContainer = new AppGameContainer(new States(game), 1920, 1080, true);
		gameContainer.start();

	}

}
