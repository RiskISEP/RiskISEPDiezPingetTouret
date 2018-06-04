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

//  TODO faire les liaisons inter-Regions
	private void initNorthAmericaBorder(Region northAmerica) {
		for (Territory territory :
				northAmerica.getTerritories()) {
			switch (territory.getName()) {
				case "CentralAmerica":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("WesternUnitedStates"),
									northAmerica.findTerritoryByName("EasternUnitedStates"))) {
						territory.addBorder(border);
					}
				case "WesternUnitedStates":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("Alberta"),
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("EasternUnitedStates"),
									northAmerica.findTerritoryByName("CentralAmerica"))) {
						territory.addBorder(border);
					}
				case "EasternUnitedStates":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("CentralAmerica"),
									northAmerica.findTerritoryByName("WesternUnitedStates"),
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("Quebec"))) {
						territory.addBorder(border);
					}
				case "Quebec":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("Greenland"),
									northAmerica.findTerritoryByName("EasternUnitedStates"))) {
						territory.addBorder(border);
					}
				case "Ontario":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("NorthwestTerritory"),
									northAmerica.findTerritoryByName("Greenland"),
									northAmerica.findTerritoryByName("Quebec"),
									northAmerica.findTerritoryByName("EasternUnitedStates"),
									northAmerica.findTerritoryByName("WesternUnitedStates"),
									northAmerica.findTerritoryByName("Alberta"))) {
						territory.addBorder(border);
					}
				case "Alaska":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("Alberta"),
									northAmerica.findTerritoryByName("NorthwestTerritory"))) {
						territory.addBorder(border);
					}
				case "Alberta":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("Alaska"),
									northAmerica.findTerritoryByName("NorthwestTerritory"),
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("WesternUnitedStates"))) {
						territory.addBorder(border);
					}
				case "NorthwestTerritory":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("Alaska"),
									northAmerica.findTerritoryByName("Greenland"),
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("Alberta"))) {
						territory.addBorder(border);
					}
				case "Greenland":
					for (Territory border :
							Arrays.asList(
									northAmerica.findTerritoryByName("NorthwestTerritory"),
									northAmerica.findTerritoryByName("Ontario"),
									northAmerica.findTerritoryByName("Quebec"))) {
						territory.addBorder(border);
					}
			}
		}
	}

	private void initSouthAmericaBorder(Region southAmerica) {
		for (Territory territory :
				southAmerica.getTerritories()) {
			switch (territory.getName()) {
				case "Argentina":
					for (Territory border :
							Arrays.asList(
									southAmerica.findTerritoryByName("Peru"),
									southAmerica.findTerritoryByName("Brazil"))) {
						territory.addBorder(border);
					}
				case "Brazil":
					for (Territory border :
							Arrays.asList(
									southAmerica.findTerritoryByName("Venezuela"),
									southAmerica.findTerritoryByName("Argentina"),
									southAmerica.findTerritoryByName("Peru"))) {
						territory.addBorder(border);
					}
				case "Peru":
					for (Territory border :
							Arrays.asList(
									southAmerica.findTerritoryByName("Venezuela"),
									southAmerica.findTerritoryByName("Brazil"),
									southAmerica.findTerritoryByName("Argentina"))) {
						territory.addBorder(border);
					}
				case "Venezuela":
					for (Territory border :
							Arrays.asList(
									southAmerica.findTerritoryByName("Brazil"),
									southAmerica.findTerritoryByName("Peru"))) {
						territory.addBorder(border);
					}
			}
		}
	}

	private void initAfricaBorder(Region africa) {
		for (Territory territory :
				africa.getTerritories()) {
			switch (territory.getName()) {
				case "Madagascar":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("EastAfrica"),
									africa.findTerritoryByName("SouthAfrica"))) {
						territory.addBorder(border);
					}
				case "SouthAfrica":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("Congo"),
									africa.findTerritoryByName("EastAfrica"),
									africa.findTerritoryByName("Madagascar"))) {
						territory.addBorder(border);
					}
				case "Congo":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("NorthAfrica"),
									africa.findTerritoryByName("EastAfrica"),
									africa.findTerritoryByName("SouthAfrica"))) {
						territory.addBorder(border);
					}
				case "EastAfrica":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("Egypt"),
									africa.findTerritoryByName("Madagascar"),
									africa.findTerritoryByName("SouthAfrica"),
									africa.findTerritoryByName("Congo"),
									africa.findTerritoryByName("NorthAfrica"))) {
						territory.addBorder(border);
					}
				case "Egypt":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("EastAfrica"),
									africa.findTerritoryByName("NorthAfrica"))) {
						territory.addBorder(border);
					}
				case "NorthAfrica":
					for (Territory border :
							Arrays.asList(
									africa.findTerritoryByName("Egypt"),
									africa.findTerritoryByName("Congo"),
									africa.findTerritoryByName("EastAfrica"))) {
						territory.addBorder(border);
					}
			}
		}
	}

	private void initOceaniaBorder(Region oceania) {
		for (Territory territory :
				oceania.getTerritories()) {
			switch (territory.getName()) {
				case "Indonesia":
					for (Territory border :
							Arrays.asList(
									oceania.findTerritoryByName("NewGuinea"),
									oceania.findTerritoryByName("WesternAustralia"))) {
						territory.addBorder(border);
					}
				case "NewGuinea":
					for (Territory border :
							Arrays.asList(
									oceania.findTerritoryByName("Indonesia"),
									oceania.findTerritoryByName("EasternAustralia"),
									oceania.findTerritoryByName("WesternAustralia"))) {
						territory.addBorder(border);
					}
				case "EasternAustralia":
					for (Territory border :
							Arrays.asList(
									oceania.findTerritoryByName("NewGuinea"),
									oceania.findTerritoryByName("WesternAustralia"))) {
						territory.addBorder(border);
					}
				case "WesternAustralia":
					for (Territory border :
							Arrays.asList(
									oceania.findTerritoryByName("Indonesia"),
									oceania.findTerritoryByName("NewGuinea"),
									oceania.findTerritoryByName("EasternAustralia"))) {
						territory.addBorder(border);
					}
			}
		}
	}

	private void initEuropeBorder(Region europe) {
		for (Territory territory :
				europe.getTerritories()) {
			switch (territory.getName()) {
				case "GreatBritain":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("Iceland"),
									europe.findTerritoryByName("Scandinavia"),
									europe.findTerritoryByName("NorthernEurope"),
									europe.findTerritoryByName("WesternEurope"))) {
						territory.addBorder(border);
					}
				case "Iceland":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("GreatBritain"),
									europe.findTerritoryByName("Scandinavia"))) {
						territory.addBorder(border);
					}
				case "Scandinavia":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("GreatBritain"),
									europe.findTerritoryByName("Ukraine"),
									europe.findTerritoryByName("NorthernEurope"),
									europe.findTerritoryByName("Iceland"))) {
						territory.addBorder(border);
					}
				case "Ukraine":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("Scandinavia"),
									europe.findTerritoryByName("SouthernEurope"),
									europe.findTerritoryByName("NorthernEurope"))) {
						territory.addBorder(border);
					}
				case "NorthernEurope":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("GreatBritain"),
									europe.findTerritoryByName("Ukraine"),
									europe.findTerritoryByName("SouthernEurope"),
									europe.findTerritoryByName("WesternEurope"),
									europe.findTerritoryByName("Scandinavia"))) {
						territory.addBorder(border);
					}
				case "SouthernEurope":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("WesternEurope"),
									europe.findTerritoryByName("NorthernEurope"),
									europe.findTerritoryByName("Ukraine"))) {
						territory.addBorder(border);
					}
				case "WesternEurope":
					for (Territory border :
							Arrays.asList(
									europe.findTerritoryByName("GreatBritain"),
									europe.findTerritoryByName("NorthernEurope"),
									europe.findTerritoryByName("SouthernEurope"))) {
						territory.addBorder(border);
					}
			}
		}
	}

	private void initAsiaBorder(Region asia) {
		for (Territory territory :
				asia.getTerritories()) {
			switch (territory.getName()) {
				case "Afghanistan":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Ural"),
									asia.findTerritoryByName("China"),
									asia.findTerritoryByName("India"),
									asia.findTerritoryByName("MiddleEast"))) {
						territory.addBorder(border);
					}
				case "Siam":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("India"),
									asia.findTerritoryByName("China"))) {
						territory.addBorder(border);
					}
				case "India":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("MiddleEast"),
									asia.findTerritoryByName("Afghanistan"),
									asia.findTerritoryByName("China"),
									asia.findTerritoryByName("Siam"))) {
						territory.addBorder(border);
					}
				case "MiddleEast":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Afghanistan"),
									asia.findTerritoryByName("India"))) {
						territory.addBorder(border);
					}
				case "China":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Afghanistan"),
									asia.findTerritoryByName("Siberia"),
									asia.findTerritoryByName("Mongolia"),
									asia.findTerritoryByName("Siam"),
									asia.findTerritoryByName("India"),
									asia.findTerritoryByName("Ural"))) {
						territory.addBorder(border);
					}
				case "Mongolia":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Siberia"),
									asia.findTerritoryByName("Irkutsk"),
									asia.findTerritoryByName("Kamchatka"),
									asia.findTerritoryByName("Japan"),
									asia.findTerritoryByName("China"))) {
						territory.addBorder(border);
					}
				case "Japan":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Kamchatka"),
									asia.findTerritoryByName("Mongolia"))) {
						territory.addBorder(border);
					}
				case "Kamchatka":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Yakutsk"),
									asia.findTerritoryByName("Japan"),
									asia.findTerritoryByName("Mongolia"),
									asia.findTerritoryByName("Irkutsk"))) {
						territory.addBorder(border);
					}
				case "Irkutsk":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Siberia"),
									asia.findTerritoryByName("Yakutsk"),
									asia.findTerritoryByName("Kamchatka"),
									asia.findTerritoryByName("Mongolia"))) {
						territory.addBorder(border);
					}
				case "Yakutsk":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Siberia"),
									asia.findTerritoryByName("Kamchatka"),
									asia.findTerritoryByName("Irkutsk"))) {
						territory.addBorder(border);
					}
				case "Siberia":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Ural"),
									asia.findTerritoryByName("Yakutsk"),
									asia.findTerritoryByName("Irkutsk"),
									asia.findTerritoryByName("Mongolia"),
									asia.findTerritoryByName("China"))) {
						territory.addBorder(border);
					}
				case "Ural":
					for (Territory border :
							Arrays.asList(
									asia.findTerritoryByName("Siberia"),
									asia.findTerritoryByName("Afghanistan"),
									asia.findTerritoryByName("China"))) {
						territory.addBorder(border);
					}
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
