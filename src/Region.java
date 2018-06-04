import java.util.ArrayList;
import java.util.List;

public class Region {

	private String name;
	private List<Territory> territories;
	private List<Player> owners;

	public Region(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Territory> getTerritories() {
		return territories;
	}

	public void setTerritories(List<Territory> territories) {
		this.territories = territories;
	}

	public void addTerritories(Territory territory) {
		this.territories.add(territory);
	}

	public List<Player> getOwners() {
		return owners;
	}

	public void setOwners(List<Player> owners) {
		this.owners = owners;
	}

	public List<Player> getPlayers(){
		List<Player> players = new ArrayList<>();
		for (Territory territory :
				territories) {
			if (!players.contains(territory.getPlayer())){
				players.add(territory.getPlayer());
			}
		}
		setOwners(players);
		return players;
	}
}
