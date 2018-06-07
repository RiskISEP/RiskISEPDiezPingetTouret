package fr.isep.riskIsep.gui;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import fr.isep.riskIsep.Region;
import fr.isep.riskIsep.Territory;
import fr.isep.riskIsep.unit.Artillery;
import fr.isep.riskIsep.unit.Cavalry;
import fr.isep.riskIsep.unit.Infantry;
import fr.isep.riskIsep.unit.Unit;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Arrays;

public class MapScreen extends BasicGameState {

	public static final int ID = 3;
	public static Player currentPlayer = null;
	public String selTerr = "";
	boolean mouseLeft = false;
	private int WIDTH;
	private int HEIGHT;
	private String playersDisplay = "Players :\n";
	private int playerIndex = 0;
	private int roundNumber = 0;
	private Image background;
	private Image dashboard;
	private Image button;
	private Image buttonClicked;
	private int gameState = 0;
	private int[] diceResult = new int[5];
	private Territory selectedTerritory;
	private Territory lastSelectedTerritory;

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
		button.draw(WIDTH / 5, HEIGHT - 200, WIDTH / 5, 100);

		graphics.setColor(Color.white);
		graphics.drawString(currentPlayer == null ? "" : currentPlayer.getName(), 50, 50);
		graphics.drawString(playersDisplay, 50, 1000 - (game.getPlayers().size() * 25));
		graphics.drawString("Dés attaque : ", 50, 155);
		for (int i = 0; i < 3; i++) {
			if (diceResult[i] != 0)
				graphics.drawString(String.valueOf(diceResult[i]), 50, 170 + i * 15);
		}
		graphics.drawString("Dés defense : ", 50, 215);
		for (int i = 3; i < 5; i++) {
			if (diceResult[i] != 0)
				graphics.drawString(String.valueOf(diceResult[i]), 50, 230 + i * 15);
		}
		graphics.drawString("Tour Suivant", WIDTH * 3 / 10, HEIGHT - 150);
		graphics.setColor(currentPlayer.getTerritories().contains(selectedTerritory) ? Color.white : Color.red);
		graphics.drawString(selTerr, 50, 65);
		if (selectedTerritory != null) {
			drawTerritoryInfo(gameContainer, stateBasedGame, graphics);
		}
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
					if (Mouse.isButtonDown(0)) {
						mouseLeft = true;
					} else {
						if (mouseLeft) {
							// left mouse button was released last frame
							mouseLeft = false;
							updateTerritory(gameContainer, stateBasedGame, i);
							lastSelectedTerritory = selectedTerritory;
						}
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
		if (playerIndex == game.getPlayers().size() - 1) roundNumber++;
		currentPlayer = game.getPlayers().get(playerIndex);
		playerIndex = (playerIndex + 1) % game.getPlayers().size();
		lastSelectedTerritory = null;
	}

	public void drawTerritoryInfo(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		int[] unitsPopulation = new int[3];
		for (Unit unit : selectedTerritory.getUnits()) {
			if (unit instanceof Infantry) unitsPopulation[0]++;
			if (unit instanceof Cavalry) unitsPopulation[1]++;
			if (unit instanceof Artillery) unitsPopulation[2]++;
		}

		graphics.drawString("Garrison :", 50, 95);
		graphics.drawString("Infantry  x" + unitsPopulation[0], 50, 110);
		graphics.drawString("Cavalry   x" + unitsPopulation[1], 50, 125);
		graphics.drawString("Artillery x" + unitsPopulation[2], 50, 140);

	}

	public void updateTerritory(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		switch (gameState) {
			case 0: //Reception de renforts
				if (currentPlayer.getUnits().size() == 0) {
					if (roundNumber == 0) {
						gameState = 0;
					} else {
						gameState = 1;
					}
					break;
				}
				if (currentPlayer.isMine(selectedTerritory))
					selectedTerritory.getUnits().add(currentPlayer.getUnits().remove(0));
				break;

			case 1: //Attaque
				if (lastSelectedTerritory != null && lastSelectedTerritory.getUnits().size()>1) {
					diceResult = lastSelectedTerritory.attackTerritory(selectedTerritory, new ArrayList<>(Arrays.asList(lastSelectedTerritory.getUnits().get(0),
							lastSelectedTerritory.getUnits().get(1),
							lastSelectedTerritory.getUnits().get(2))));
				}
		}
	}
}
