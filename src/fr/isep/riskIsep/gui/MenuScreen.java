package fr.isep.riskIsep.gui;

import fr.isep.riskIsep.Game;
import fr.isep.riskIsep.Player;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuScreen extends BasicGameState {

	public static final int ID = 2;
	private StateBasedGame stateBasedGame;
	private GameContainer container;
	private Game game;

	private int WIDTH;
	private int HEIGHT;

	private Image background;
	private TrueTypeFont font;

	private int fontWidth;
	private int fontHeight;

	private Image nameField;
	private Image nameFieldClicked;
	private int nbJoueurs = 2;
	private boolean[] checkedValue = {false, false, false, false, true};
	private boolean isPlayerHovered = false;
	private boolean isPlayClicked = false;

	private String debugText = "";

	private Image button;
	private Image buttonC;

	private List<TextField> names = new ArrayList<>();


	public MenuScreen(Game game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		this.stateBasedGame = stateBasedGame;
		this.container = gameContainer;

		WIDTH = this.container.getWidth();
		HEIGHT = this.container.getHeight();

		background = new Image("/res/HUD/background.png");
		nameField = new Image("/res/HUD/NonSelectedLabel.png");
		nameFieldClicked = new Image("/res/HUD/SelectedLabel.png");
		button = new Image("/res/HUD/NonCheckedPoint.png");
		buttonC = new Image("/res/HUD/CheckedPoint.png");


		InputStream inputStream = ResourceLoader.getResourceAsStream("/res/Font/CM_Old_Western.ttf");

		try {
			Font fontStream = Font.createFont(Font.TRUETYPE_FONT, inputStream);

			fontStream = fontStream.deriveFont(65f);

			font = new TrueTypeFont(fontStream, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		names.add(new TextField(gameContainer, font, 150, 300, 400, 75));
		names.get(0).setBackgroundColor(Color.transparent);
		names.get(0).setBorderColor(Color.transparent);
		names.get(0).setTextColor(Color.black);
		names.add(new TextField(gameContainer, font, 150, 400, 400, 75));
		names.get(1).setBackgroundColor(Color.transparent);
		names.get(1).setBorderColor(Color.transparent);
		names.get(1).setTextColor(Color.black);
		names.add(new TextField(gameContainer, font, 150, 500, 400, 75));
		names.get(2).setBackgroundColor(Color.transparent);
		names.get(2).setBorderColor(Color.transparent);
		names.get(2).setTextColor(Color.black);
		names.add(new TextField(gameContainer, font, 150, 600, 400, 75));
		names.get(3).setBackgroundColor(Color.transparent);
		names.get(3).setBorderColor(Color.transparent);
		names.get(3).setTextColor(Color.black);
		names.add(new TextField(gameContainer, font, 150, 700, 400, 75));
		names.get(4).setBackgroundColor(Color.transparent);
		names.get(4).setBorderColor(Color.transparent);
		names.get(4).setTextColor(Color.black);
		names.add(new TextField(gameContainer, font, 150, 800, 400, 75));
		names.get(5).setBackgroundColor(Color.transparent);
		names.get(5).setBorderColor(Color.transparent);
		names.get(5).setTextColor(Color.black);
	}

	@Override
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		background.draw(0, 0, WIDTH, HEIGHT);
		font.drawString((WIDTH - fontWidth) / 2, (50 + fontHeight) / 2, "MENU", Color.black);
		font.drawString(WIDTH - 440, 210, "JOUEURS", isPlayerHovered ? Color.red : Color.black);
		for (int i = 0; i < 5; i++) {
			if (checkedValue[i]) {
				buttonC.draw(WIDTH - 150 - i * 75, 300, 20, 20);
			} else {
				button.draw(WIDTH - 150 - i * 75, 300, 20, 20);
			}
			font.drawString(WIDTH - 150 - i * 75, 330, String.valueOf(6 - i), Color.black);
		}
		for (int i = 0; i < nbJoueurs; i++) {
			nameField.draw(100, 300 + i * 100, 500, 75);
			names.get(i).render(gameContainer, graphics);
		}

		if (isPlayClicked){
			nameFieldClicked.draw((WIDTH - 200) / 2, HEIGHT - 200, 200, 75);
		} else {
			nameField.draw((WIDTH - 200) / 2, HEIGHT - 200, 200, 75);
		}
		graphics.drawString("PLAY !", (WIDTH - 50) / 2, HEIGHT - 175);
	}

	@Override
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
		fontWidth = font.getWidth("MENU");
		fontHeight = font.getWidth("MENU");
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		if (xPos < (WIDTH - 110) && xPos > (WIDTH - 470) && yPos < HEIGHT - 300 && yPos > HEIGHT - 400) {
			isPlayerHovered = true;
			if (Mouse.isButtonDown(0)) {
				switch ((int) ((xPos - (WIDTH - 468)) / 71.4)) {
					case 0:
						nbJoueurs = 2;
						checkedValue[0] = false;
						checkedValue[1] = false;
						checkedValue[2] = false;
						checkedValue[3] = false;
						checkedValue[4] = true;
						break;
					case 1:
						nbJoueurs = 3;
						checkedValue[0] = false;
						checkedValue[1] = false;
						checkedValue[2] = false;
						checkedValue[3] = true;
						checkedValue[4] = false;
						break;
					case 2:
						nbJoueurs = 4;
						checkedValue[0] = false;
						checkedValue[1] = false;
						checkedValue[2] = true;
						checkedValue[3] = false;
						checkedValue[4] = false;
						break;
					case 3:
						nbJoueurs = 5;
						checkedValue[0] = false;
						checkedValue[1] = true;
						checkedValue[2] = false;
						checkedValue[3] = false;
						checkedValue[4] = false;
						break;
					case 4:
						nbJoueurs = 6;
						checkedValue[0] = true;
						checkedValue[1] = false;
						checkedValue[2] = false;
						checkedValue[3] = false;
						checkedValue[4] = false;
						break;
				}
			}
		} else isPlayerHovered = false;
		if (xPos > 860 && xPos < 1060 && yPos > 125 && yPos < 200) {
			isPlayClicked = Mouse.isButtonDown(0);
			List<Player> players = new ArrayList<>();
			for (int it = 0; it < nbJoueurs; it ++){
				players.add(new Player(names.get(it).getText(), false));
			}
			game.init(players);
			MapScreen.currentPlayer = game.getPlayers().get(0);
			stateBasedGame.enterState(MapScreen.ID);
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}
