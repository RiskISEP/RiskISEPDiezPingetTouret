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

	public int reinforcementControlled(Player player) {
		return (player.getTerritories().size()) / 3;
	}

	public int regionControlled(Player player) {
		int n = 0;
		for (Region region :
				player.getRegions()) {
			n += region.getTerritories().size() / 2;
		}
		return n;
	}

	public int capturedTerritories(Player player) {
		int p = 0;
		for (int i = 0; i < player.getCapturedTerritories(); i++) {
			if (((int) (Math.random() + 0.5)) == 1) p++;
		}
		return p;
	}

	public int reinforcement(Player player) {
		return reinforcementControlled(player) + regionControlled(player) + capturedTerritories(player);
	}
}
