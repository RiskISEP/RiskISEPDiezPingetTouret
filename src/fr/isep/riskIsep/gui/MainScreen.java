package fr.isep.riskIsep.gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainScreen extends BasicGameState {
	public static final int ID = 1;

	private int WIDTH;
	private int HEIGHT;

	private Image background;
	private Image logo;
	private int logoWidth;
	private int logoHeight;

	private StateBasedGame stateBasedGame;
	private GameContainer container;

	@Override
	public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
		this.stateBasedGame = stateBasedGame;
		WIDTH = container.getWidth();
		HEIGHT = container.getHeight();

		this.background = new Image("/res/background.png");
		this.logo = new Image("/res/logo-jeu-risk.png");

		logoWidth = WIDTH / 2;
		logoHeight = logo.getHeight() * logoWidth / logo.getWidth();
		this.container = container;
		Music background = new Music("TheLoomingBattle.OGG");
		background.loop();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0, 0, WIDTH, HEIGHT);
		logo.draw((WIDTH - logoWidth) / 2, (HEIGHT - logoHeight) / 2, logoWidth, logoHeight);
		g.drawString("Appuyer sur une touche", WIDTH / 2 - 100, HEIGHT / 6 * 5);
	}


	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}

	@Override
	public void keyReleased(int key, char c) {
		stateBasedGame.enterState(MenuScreen.ID);
	}

	@Override
	public int getID() {
		return ID;
	}
}
