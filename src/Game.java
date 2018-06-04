import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

	Scanner scanner = new Scanner(System.in);
	private List<Player> players = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();

	public void init() {

		System.out.println("Binvenu dans Risk !");
		initRegion();
		initPlayers();

	}

	private void initRegion() {
		for (String name :
				Arrays.asList("Asia", "Europe", "Oceania", "Africa", "SouthAmerica", "NorthAmerica")) {
			Region region = new Region(name);
			regions.add(region);
			initTerritory(region);
		}
	}

	private void initTerritory(Region region) {
		switch (region.getName()){
			case "Asia":
				for (String name:
				     Arrays.asList("Afghanistan", "Siam", "India", "MiddleEast", "China", "Mongolia", "Japan", "Kamchatka", "Irkutsk", "Yakutsk", "Siberia", "Ural")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
					initAsiaBorder(territory);
				}

			case "Europe":
				for (String name:
				     Arrays.asList("")) {

				}

			case "Oceania":
				for (String name:
				     Arrays.asList("")) {

				}

			case "Africa":
				for (String name:
				     Arrays.asList("")) {

				}

			case "SouthAmerica":
				for (String name:
				     Arrays.asList("")) {

				}

			case "NorthAmerica":
				for (String name:
				     Arrays.asList("")) {

				}

		}
	}

	private void initAsiaBorder(Territory territory) {

	}

	private void initPlayers() {

		System.out.print("nombre de joueurs humains : ");
		int nbPlayers = scanner.nextInt();
		scanner.nextLine();

		for (int it = 0; it < nbPlayers; it++) {
			System.out.print("nom du joueur " + (it + 1) + " : ");
			String name = scanner.nextLine();
			players.add(new Player(name));
		}
	}

}
