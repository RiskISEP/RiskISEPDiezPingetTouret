import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Region> regions = new ArrayList<>();
	private List<Territory> territories = new ArrayList<>();
	private List<Unit> units = new ArrayList<>();
	private Mission mission;
	private boolean isAI;

	public boolean isAI() {
		return isAI;
	}

	public void setAI(boolean AI) {
		isAI = AI;
	}

	public Player(String name, boolean isAI) {
		this.name = name;
		this.isAI = isAI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<Territory> getTerritories() {
		return territories;
	}

	public void setTerritories(List<Territory> territories) {
		this.territories = territories;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public void addTerritory(Territory territory) {
		territories.add(territory);
	}
}
