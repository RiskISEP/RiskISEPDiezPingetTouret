import java.util.List;

public class Territory {

	private String name;
	private Region region;
	private Player player;
	private List<Territory> borders;
	private List<Unit> units;

	public Territory(String name, Region region) {
		this.name = name;
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Territory> getBorders() {
		return borders;
	}

	public void setBorders(List<Territory> borders) {
		this.borders = borders;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}
}
