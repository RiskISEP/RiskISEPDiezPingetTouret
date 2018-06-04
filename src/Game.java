import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Player> players = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();

	public void init() {

		System.out.println("Bienvenue dans Risk !");
		GameInitializer initializer = new GameInitializer(players, regions);
		initializer.start();

	}

}
