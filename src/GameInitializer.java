import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInitializer {

	private Scanner scanner = new Scanner(System.in);

	private List<Player> players = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();

	public GameInitializer(List<Player> players, List<Region> regions) {
		this.players = players;
		this.regions = regions;
	}

	public void start() {
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
		switch (region.getName()) {
			case "Asia":
				for (String name :
						Arrays.asList("Afghanistan", "Siam", "India", "MiddleEast", "China", "Mongolia", "Japan", "Kamchatka", "Irkutsk", "Yakutsk", "Siberia", "Ural")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initAsiaBorder(region);

			case "Europe":
				for (String name :
						Arrays.asList("GreatBritain", "Iceland", "Scandinavia", "Ukraine", "NorthernEurope", "SouthernEurope", "WesternEurope")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initEuropeBorder(region);

			case "Oceania":
				for (String name :
						Arrays.asList("Indonesia", "NewGuinea", "EasternAustralia", "WesternAustralia")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initOceaniaBorder(region);

			case "Africa":
				for (String name :
						Arrays.asList("Madagascar", "SouthAfrica", "Congo", "EastAfrica", "Egypt", "NorthAfrica")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initAfricaBorder(region);

			case "SouthAmerica":
				for (String name :
						Arrays.asList("Argentina", "Brazil", "Peru", "Venezuela")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initSouthAmericaBorder(region);

			case "NorthAmerica":
				for (String name :
						Arrays.asList("CentralAmerica", "WesternUnitedStates", "EasternUnitedStates", "Quebec", "Ontario", "Alaska", "Alberta", "NorthwestTerritory", "Greenland")) {
					Territory territory = new Territory(name, region);
					region.addTerritories(territory);
				}
				initNorthAmericaBorder(region);

		}
	}

	private void initNorthAmericaBorder(Region northAmerica) {
		for (Territory territory :
				northAmerica.getTerritories()) {
			switch (territory.getName()) {
				case "CentralAmerica":
				case "WesternUnitedStates":
				case "EasternUnitedStates":
				case "Quebec":
				case "Ontario":
				case "Alaska":
				case "Alberta":
				case "NorthwestTerritory":
				case "Greenland":
			}
		}
	}

	private void initSouthAmericaBorder(Region southAmerica) {
		for (Territory territory :
				southAmerica.getTerritories()) {
			switch (territory.getName()) {
				case "Argentina":
				case "Brazil":
				case "Peru":
				case "Venezuela":
			}
		}
	}

	private void initAfricaBorder(Region africa) {
		for (Territory territory :
				africa.getTerritories()) {
			switch (territory.getName()) {
				case "Madagascar":
				case "SouthAfrica":
				case "Congo":
				case "EastAfrica":
				case "Egypt":
				case "NorthAfrica":
			}
		}
	}

	private void initOceaniaBorder(Region oceania) {
		for (Territory territory :
				oceania.getTerritories()) {
			switch (territory.getName()) {
				case "Indonesia":
				case "NewGuinea":
				case "EasternAustralia":
				case "WesternAustralia":
			}
		}
	}

	private void initEuropeBorder(Region europe) {
		for (Territory territory :
				europe.getTerritories()) {
			switch (territory.getName()) {
				case "GreatBritain":
				case "Iceland":
				case "Scandinavia":
				case "Ukraine":
				case "NorthernEurope":
				case "SouthernEurope":
				case "WesternEurope":
			}
		}
	}

	private void initAsiaBorder(Region asia) {
		for (Territory territory :
				asia.getTerritories()) {
			switch (territory.getName()) {
				case "Afghanistan":
				case "Siam":
				case "India":
				case "MiddleEast":
				case "China":
				case "Mongolia":
				case "Japan":
				case "Kamchatka":
				case "Irkutsk":
				case "Yakutsk":
				case "Siberia":
				case "Ural":
			}
		}
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
