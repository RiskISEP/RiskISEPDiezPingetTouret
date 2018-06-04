public abstract class Unit {

	private Territory territory;
	private int cost;
	private int power;
	private int attack;
	private int defence;
	private int movement;

	public Unit(int cost, int power, int attack, int defence, int movement) {
		this.cost = cost;
		this.power = power;
		this.attack = attack;
		this.defence = defence;
		this.movement = movement;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
}
