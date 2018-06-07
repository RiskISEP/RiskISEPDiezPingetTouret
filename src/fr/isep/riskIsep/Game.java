package fr.isep.riskIsep;

import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Player> players = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public void init() throws SlickException {

		System.out.println("Bienvenue dans Risk !");
		GameInitializer initializer = new GameInitializer(players, regions);
		initializer.start();

	}

	public void init(List<Player> players) throws SlickException {

		System.out.println("Bienvenue dans Risk !");
		this.players = players;
		GameInitializer initializer = new GameInitializer(this.players, this.regions);
		initializer.start();

	}


}
