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

	public void init() {

		System.out.println("Bienvenue dans Risk !");
		GameInitializer initializer = new GameInitializer(players, regions);
		initializer.start();

	}



}
