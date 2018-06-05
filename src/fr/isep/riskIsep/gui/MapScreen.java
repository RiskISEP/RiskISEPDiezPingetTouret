package fr.isep.riskIsep.gui;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class MapScreen extends BasicGameState {

	public static final int ID = 2;
	private int WIDTH;
	private int HEIGHT;
	public String mouse = "";
	public String selTerr = "";
	private String playersDisplay = "Players : ";
	private Image background;
	private Image dashboard;
	private StateBasedGame stateBasedGame;
	private GameContainer container;
	private Game game;

	public MapScreen(Game game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.container = gameContainer;
		WIDTH = container.getWidth();
		HEIGHT = container.getHeight();

		this.background = new Image("/res/Map/RiskISEP.png");
		this.dashboard = new Image("/res/BlankPanel-3.png");

		for (Player player :
				game.getPlayers()) {
			playersDisplay += (player.getName() + ", ");
		}
		playersDisplay = playersDisplay.substring(0, playersDisplay.length()-2);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		dashboard.draw(0, 0, WIDTH / 5, HEIGHT);
		background.draw(WIDTH / 5, 0, WIDTH * 4 / 5, HEIGHT);
		System.out.println();
		graphics.setColor(Color.white);
		graphics.drawString(mouse, 50, 50);
		graphics.drawString(selTerr, 50, 65);
		graphics.drawString(playersDisplay, 50, 1000);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

	}

	@Override
	public int getID() {
		return ID;
	}
}
