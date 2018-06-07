package fr.isep.riskIsep.gui;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import fr.isep.riskIsep.Region;
import fr.isep.riskIsep.Territory;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MapScreen extends BasicGameState {

	public static final int ID = 3;
	public static Player currentPlayer = null;
	public String mouse = "";
	public String selTerr = "";
	private int WIDTH;
	private int HEIGHT;
	private String playersDisplay = "Players :\n";
	private int playerIndex = 0;

	private Image background;
	private Image dashboard;
	private Image button;
	private Image buttonClicked;

	boolean mouseLeft = false;

	private Territory selectedTerritory;

	private StateBasedGame stateBasedGame;
	private GameContainer container;
	private Game game;

	public MapScreen(Game game) {
		this.game = game;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

		this.container = gameContainer;
		WIDTH = container.getWidth();
		HEIGHT = container.getHeight();

		this.background = new Image("/res/Map/RiskISEP.png");
		this.dashboard = new Image("/res/BlankPanel-3.png");
		this.button = new Image("/res/HUD/NonSelectedLabel.png");
		this.buttonClicked = new Image("/res/HUD/SelectedLabel.png");

		for (Player player :
				game.getPlayers()) {
			playersDisplay += (player.getName() + ",\n");
		}
		playersDisplay = playersDisplay.substring(0, playersDisplay.length() - 2);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		dashboard.draw(0, 0, WIDTH / 5, HEIGHT);
		background.draw(WIDTH / 5, 0, WIDTH * 4 / 5, HEIGHT);
		button.draw(WIDTH/5, HEIGHT-200, WIDTH/5, 100);

		graphics.setColor(Color.white);
		graphics.drawString(currentPlayer == null ? "" : currentPlayer.getName(), 50, 50);
		graphics.drawString(playersDisplay, 50, 1000 - (game.getPlayers().size() * 25));
		graphics.setColor(currentPlayer.getTerritories().contains(selectedTerritory) ? Color.white : Color.red);
		graphics.drawString(selTerr, 50, 65);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		playersDisplay = "Players :\n";
		for (Player player :
				game.getPlayers()) {
			playersDisplay += (player.getName() + ",\n");
		}
		playersDisplay = playersDisplay.substring(0, playersDisplay.length() - 2);
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if (xpos > WIDTH / 5 && xpos < WIDTH * 2 / 5 && ypos > 100 && ypos < 200) {
			if (Mouse.isButtonDown(0)) {
				mouseLeft = true;
			} else {
				if (mouseLeft) {
					// left mouse button was released last frame
					mouseLeft = false;
					nextTurn();
				}
			}
		}
		for (Region region :
				game.getRegions()) {
			for (Territory territory :
					region.getTerritories()) {
				if (selectedTerritory != null) selTerr = selectedTerritory.getName() +
						(currentPlayer.getTerritories().contains(selectedTerritory) ? "" : " (" + selectedTerritory.getPlayer().getName() + ")");
				if (territory.isHovered(xpos, HEIGHT - ypos)) {
					if (selectedTerritory != territory) {
						selectedTerritory = territory;
					}
					break;
				}
			}
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	public void nextTurn() {
		playerIndex = (playerIndex + 1) % game.getPlayers().size();
		currentPlayer = game.getPlayers().get(playerIndex);
	}
}
