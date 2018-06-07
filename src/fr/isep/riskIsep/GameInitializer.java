package fr.isep.riskIsep;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import fr.isep.riskIsep.unit.Infantry;

import java.util.*;


public class GameInitializer {

	private Scanner scanner = new Scanner(System.in);

	private List<Player> players = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();

	public GameInitializer(List<Player> players, List<Region> regions) {
		this.players = players;
		this.regions = regions;
	}

	public void start() throws SlickException {
		initRegion();
		if (players.size()!=0){
			initPlayers(players);
		}
		//initPlayers();
	}

	private void initPlayers(List<Player> players) {
		List<Territory> allTerritory = new ArrayList<>();
		for (Region region : regions) {
			allTerritory.addAll(region.getTerritories());
		}

		Collections.shuffle(allTerritory);

		for (int i = 0; i < allTerritory.size(); i = i + players.size()) {
			for (int j = 0; j < players.size(); j++) {
				if (!(i + j >= allTerritory.size())) {
					players.get(j).addTerritory(allTerritory.get(i + j));
					allTerritory.get(i + j).setPlayer(players.get(j));
				}
			}
		}
		for (int i = 0; i<players.size(); i++) {
			for (int j = 0; j < 40 - 5 * (players.size()-2); j++) {
				players.get(i).addUnit(new Infantry());
			}
		}
	}

	private void initPlayers() {
		Menu menu = new Menu();
		menu.askForPlayers(players);
		List<Territory> allTerritory = new ArrayList<>();
//		System.out.println("Partie initialisée!");
//		System.out.print(".\tRégions : ");
//		System.out.println(regions.size());
		for (Region it : regions) {
//			System.out.print(".\t" + it.getName() + " : ");
//			System.out.print(it.getTerritories().size());
//			System.out.println(" territoires");
			for (Territory territory : it.getTerritories()) {
				allTerritory.add(territory);
			}
		}
		Collections.shuffle(allTerritory);

        switch (players.size()) {
            case 2:
                for (int i = 0; i < allTerritory.size(); i = i + 2) {
                    players.get(0).addTerritory(allTerritory.get(i));
                    players.get(1).addTerritory(allTerritory.get(i + 1));
                }
                for (int i = 0; i < 40; i++) {
                    players.get(0).addUnit(new Infantry());
                    players.get(1).addUnit(new Infantry());
                }


                System.out.println(allTerritory.size());
                System.out.println("nombre de territoires du joueur 1 : " + players.get(0).getTerritories().size());
                System.out.println("nombre d'unites du joueur 1 : "+players.get(0).getUnits().size());
                System.out.println("nombre de territoires du joueur 2 : " + players.get(1).getTerritories().size());
                System.out.println("nombre d'unites du joueur 2 : "+players.get(1).getUnits().size());

                break;
            case 3:
                for (int i = 0; i < allTerritory.size(); i = i + 3) {
                    players.get(0).addTerritory(allTerritory.get(i));
                    players.get(1).addTerritory(allTerritory.get(i + 1));
                    players.get(2).addTerritory(allTerritory.get(i + 2));

                }
                for (int i = 0; i < 35; i++) {
                    players.get(0).addUnit(new Infantry());
                    players.get(1).addUnit(new Infantry());
                    players.get(2).addUnit(new Infantry());
                }
                System.out.println("nombre de territoires du joueur 1 : " + players.get(0).getTerritories().size());
                System.out.println("nombre d'unites du joueur 1 : "+players.get(0).getUnits().size());
                System.out.println("nombre de territoires du joueur 2 : " + players.get(1).getTerritories().size());
                System.out.println("nombre d'unites du joueur 2 : "+players.get(1).getUnits().size());
                System.out.println("nombre de territoires du joueur 3 : " + players.get(2).getTerritories().size());
                System.out.println("nombre d'unites du joueur 3 : "+players.get(2).getUnits().size());

            case 4:
                for (int i = 0; i < allTerritory.size(); i = i + 4) {
                    players.get(0).addTerritory(allTerritory.get(i));
                    players.get(1).addTerritory(allTerritory.get(i + 1));
                    if (i + 2 < allTerritory.size()) {
                        players.get(2).addTerritory(allTerritory.get(i + 2));
                        players.get(3).addTerritory(allTerritory.get(i + 3));
                    }
                }
                for (int i = 0; i < 30; i++) {
                    players.get(0).addUnit(new Infantry());
                    players.get(1).addUnit(new Infantry());
                    players.get(2).addUnit(new Infantry());
                    players.get(3).addUnit(new Infantry());
                }
                System.out.println("nombre de territoires du joueur 1 : " + players.get(0).getTerritories().size());
                System.out.println("nombre d'unites du joueur 1 : "+players.get(0).getUnits().size());
                System.out.println("nombre de territoires du joueur 2 : " + players.get(1).getTerritories().size());
                System.out.println("nombre d'unites du joueur 2 : "+players.get(1).getUnits().size());
                System.out.println("nombre de territoires du joueur 3 : " + players.get(2).getTerritories().size());
                System.out.println("nombre d'unites du joueur 3 : "+players.get(2).getUnits().size());
                System.out.println("nombre de territoires du joueur 4 : " + players.get(3).getTerritories().size());
                System.out.println("nombre d'unites du joueur 4 : "+players.get(3).getUnits().size());
                break;

            case 5:
                for (int i = 0; i < allTerritory.size(); i = i + 5) {
                    players.get(0).addTerritory(allTerritory.get(i));
                    players.get(1).addTerritory(allTerritory.get(i + 1));
                    if (i + 2 < allTerritory.size()) {
                        players.get(2).addTerritory(allTerritory.get(i + 2));
                        players.get(3).addTerritory(allTerritory.get(i + 3));
                        players.get(4).addTerritory(allTerritory.get(i + 4));
                    }
                }
                for (int i = 0; i < 25; i++) {
                    players.get(0).addUnit(new Infantry());
                    players.get(1).addUnit(new Infantry());
                    players.get(2).addUnit(new Infantry());
                    players.get(3).addUnit(new Infantry());
                    players.get(4).addUnit(new Infantry());
                }
                System.out.println("nombre de territoires du joueur 1 : " + players.get(0).getTerritories().size());
                System.out.println("nombre d'unites du joueur 1 : "+players.get(0).getUnits().size());
                System.out.println("nombre de territoires du joueur 2 : " + players.get(1).getTerritories().size());
                System.out.println("nombre d'unites du joueur 2 : "+players.get(1).getUnits().size());
                System.out.println("nombre de territoires du joueur 3 : " + players.get(2).getTerritories().size());
                System.out.println("nombre d'unites du joueur 3 : "+players.get(2).getUnits().size());
                System.out.println("nombre de territoires du joueur 4 : " + players.get(3).getTerritories().size());
                System.out.println("nombre d'unites du joueur 4 : "+players.get(3).getUnits().size());
                System.out.println("nombre de territoires du joueur 5 : " + players.get(4).getTerritories().size());
                System.out.println("nombre d'unites du joueur 5 : "+players.get(4).getUnits().size());
                break;
            case 6:

                for (int i = 0; i < allTerritory.size(); i = i + 6) {
                    players.get(0).addTerritory(allTerritory.get(i));
                    players.get(1).addTerritory(allTerritory.get(i + 1));
                    players.get(2).addTerritory(allTerritory.get(i + 2));
                    players.get(3).addTerritory(allTerritory.get(i + 3));
                    players.get(4).addTerritory(allTerritory.get(i + 4));
                    players.get(5).addTerritory(allTerritory.get(i + 5));
                }
                for (int i = 0; i < 20; i++) {
                    players.get(0).addUnit(new Infantry());
                    players.get(1).addUnit(new Infantry());
                    players.get(2).addUnit(new Infantry());
                    players.get(3).addUnit(new Infantry());
                    players.get(4).addUnit(new Infantry());
                    players.get(5).addUnit(new Infantry());
                }
                System.out.println("nombre de territoires du joueur 1 : " + players.get(0).getTerritories().size());
                System.out.println("nombre d'unites du joueur 1 : "+players.get(0).getUnits().size());
                System.out.println("nombre de territoires du joueur 2 : " + players.get(1).getTerritories().size());
                System.out.println("nombre d'unites du joueur 2 : "+players.get(1).getUnits().size());
                System.out.println("nombre de territoires du joueur 3 : " + players.get(2).getTerritories().size());
                System.out.println("nombre d'unites du joueur 3 : "+players.get(2).getUnits().size());
                System.out.println("nombre de territoires du joueur 4 : " + players.get(3).getTerritories().size());
                System.out.println("nombre d'unites du joueur 4 : "+players.get(3).getUnits().size());
                System.out.println("nombre de territoires du joueur 5 : " + players.get(4).getTerritories().size());
                System.out.println("nombre d'unites du joueur 5 : "+players.get(4).getUnits().size());
                System.out.println("nombre de territoires du joueur 6 : " + players.get(5).getTerritories().size());
                System.out.println("nombre d'unites du joueur 6 : "+players.get(5).getUnits().size());
                break;

		}

	}

	private void initRegion() throws SlickException {
		for (String name :
				Arrays.asList("Asia", "Europe", "Oceania", "Africa", "SouthAmerica", "NorthAmerica")) {
			Region region = new Region(name);
			regions.add(region);
			System.out.println(".\tregion " + region.getName() + " créée!");
			System.out.println(".\tInitialisation de ses territoires");
			initTerritory(region);
		}
	}

	private void initTerritory(Region region) throws SlickException {
		switch (region.getName()) {
			case "Asia":
				for (String name :
						Arrays.asList("Afghanistan", "Siam", "India", "MiddleEast", "China", "Mongolia", "Japan", "Kamchatka", "Irkutsk", "Yakutsk", "Siberia", "Ural")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/Asia/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initAsiaBorder(region);
				break;

			case "Europe":
				for (String name :
						Arrays.asList("GreatBritain", "Iceland", "Scandinavia", "Ukraine", "NorthernEurope", "SouthernEurope", "WesternEurope")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/Europe/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initEuropeBorder(region);
				break;

			case "Oceania":
				for (String name :
						Arrays.asList("Indonesia", "NewGuinea", "EasternAustralia", "WesternAustralia")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/Oceania/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initOceaniaBorder(region);
				break;

			case "Africa":
				for (String name :
						Arrays.asList("Madagascar", "SouthAfrica", "Congo", "EastAfrica", "Egypt", "NorthAfrica")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/Africa/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initAfricaBorder(region);
				break;

			case "SouthAmerica":
				for (String name :
						Arrays.asList("Argentina", "Brazil", "Peru", "Venezuela")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/SouthAmerica/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initSouthAmericaBorder(region);
				break;

			case "NorthAmerica":
				for (String name :
						Arrays.asList("CentralAmerica", "WesternUnitedStates", "EasternUnitedStates", "Quebec", "Ontario", "Alaska", "Alberta", "NorthwestTerritory", "Greenland")) {
					Territory territory = new Territory(name, region);
					territory.setOccupancy(new Image("/res/Map/NorthAmerica/" + territory.getName() + ".png"));
					region.addTerritories(territory);
					System.out.println(".\t.\tterritoire " + territory.getName() + " créé!");
				}
				System.out.println(".\tInitialisation des frontieres internes");
				initNorthAmericaBorder(region);
				break;
		}
		initOtherBorders();
	}

	private void initOtherBorders() {
		for (Region region : regions) {
			for (Region region1 : regions) {
				if (region.getName().equals("Asia")) {
					if (region1.getName().equals("NorthAmerica")) {

						region.findTerritoryByName("Kamchatka").addBorder(region1.findTerritoryByName("Alaska"));
						region1.findTerritoryByName("Alaska").addBorder(region.findTerritoryByName("Kamchatka"));

					} else if (region1.getName().equals("Oceania")) {

						region.findTerritoryByName("Siam").addBorder(region1.findTerritoryByName("Indonesia"));
						region1.findTerritoryByName("Indonesia").addBorder(region.findTerritoryByName("Siam"));

					} else if (region1.getName().equals("Africa")) {

						region.findTerritoryByName("MiddleEast").addBorder(region1.findTerritoryByName("Egypt"));
						region1.findTerritoryByName("Egypt").addBorder(region.findTerritoryByName("MiddleEast"));

						region.findTerritoryByName("MiddleEast").addBorder(region1.findTerritoryByName("EastAfrica"));
						region1.findTerritoryByName("EastAfrica").addBorder(region.findTerritoryByName("MiddleEast"));

					} else if (region1.getName().equals("Europe")) {

						region.findTerritoryByName("MiddleEast").addBorder(region1.findTerritoryByName("SouthernEurope"));
						region1.findTerritoryByName("SouthernEurope").addBorder(region.findTerritoryByName("MiddleEast"));

						region.findTerritoryByName("MiddleEast").addBorder(region1.findTerritoryByName("Ukraine"));
						region1.findTerritoryByName("Ukraine").addBorder(region.findTerritoryByName("MiddleEast"));

						region.findTerritoryByName("Ural").addBorder(region1.findTerritoryByName("Ukraine"));
						region1.findTerritoryByName("Ukraine").addBorder(region.findTerritoryByName("Ural"));

						region.findTerritoryByName("Afghanistan").addBorder(region1.findTerritoryByName("Ukraine"));
						region1.findTerritoryByName("Ukraine").addBorder(region.findTerritoryByName("Afghanistan"));

					}
				} else if (region.getName().equals("Africa")) {

					if (region1.getName().equals("SouthAmerica")) {

						region.findTerritoryByName("NorthAfrica").addBorder(region1.findTerritoryByName("Brazil"));
						region1.findTerritoryByName("Brazil").addBorder(region.findTerritoryByName("NorthAfrica"));

					} else if (region1.getName().equals("Europe")) {

						region.findTerritoryByName("NorthAfrica").addBorder(region1.findTerritoryByName("WesternEurope"));
						region1.findTerritoryByName("WesternEurope").addBorder(region.findTerritoryByName("NorthAfrica"));

						region.findTerritoryByName("NorthAfrica").addBorder(region1.findTerritoryByName("SouthernEurope"));
						region1.findTerritoryByName("SouthernEurope").addBorder(region.findTerritoryByName("NorthAfrica"));

						region.findTerritoryByName("Egypt").addBorder(region1.findTerritoryByName("SouthernEurope"));
						region1.findTerritoryByName("SouthernEurope").addBorder(region.findTerritoryByName("Egypt"));

                    }
                } else if (region.getName().equals("Europe")) {

                    if (region1.getName().equals("NorthAmerica")) {

                        region.findTerritoryByName("Iceland").addBorder(region1.findTerritoryByName("Greenland"));
                        region1.findTerritoryByName("Greenland").addBorder(region.findTerritoryByName("Iceland"));

                    }
                } else if (region.getName().equals("NorthAmerica")) {

                    if (region1.getName().equals("SouthAmerica")) {

                        region.findTerritoryByName("CentralAmerica").addBorder(region1.findTerritoryByName("Venezuela"));
                        region1.findTerritoryByName("Venezuela").addBorder(region.findTerritoryByName("CentralAmerica"));

                    }
                }
            }
        }
    }


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


}
