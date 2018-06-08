package fr.isep.riskIsep.gui;

import fr.isep.riskIsep.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class States extends StateBasedGame {
	private Game game;

	public States(Game game) {
		super("Risk'Isep");
		this.game = game;
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		addState(new MainScreen());
		addState(new MenuScreen(game));
		addState(new MapScreen(game));
		addState(new EndScreen());
	}
}
