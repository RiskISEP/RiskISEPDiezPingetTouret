import java.util.ArrayList;
import java.util.List;

public class Region {

	private String name;
	private List<Territory> territories = new ArrayList<>();
	private List<Player> owners = new ArrayList<>();

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

	public Territory findTerritoryByName(String name) {
		for (Territory territory :
				territories){
			if (territory.getName().equals(name)){
				return territory;
			}
		}
		return null;
	}
}
