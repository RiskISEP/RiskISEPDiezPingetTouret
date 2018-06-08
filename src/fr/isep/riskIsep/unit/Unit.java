package fr.isep.riskIsep.unit;

import fr.isep.riskIsep.Territory;

import java.util.Comparator;
import java.util.Random;

public abstract class Unit {

	private Territory territory;
	private int cost;
	private int power;
	private int attack;
	private int defence;
	private int movement;
	private int scoreDice;

	public int getScoreDice() {
		return scoreDice;
	}

	public void setScoreDice(int scoreDice) {
		this.scoreDice = scoreDice;
	}



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

	// simulation du lance de de
	public int dice() {
		Random die = new Random();

		return die.nextInt(5) + 1 + power;
	}

	// creation des differents comparateurs
	// suivant l'attribut power
	public static Comparator<Unit> unitPowCompare = new Comparator<Unit>() {

		public int compare(Unit s1, Unit s2) {

			int power1 = s1.getPower();
			int power2 = s2.getPower();

			return power2 - power1;
		}
	};

	// suivant l'attribut priorite de defense
	public static Comparator<Unit> unitDefenseCompare = new Comparator<Unit>() {

		public int compare(Unit s1, Unit s2) {

			int defense1 = s1.getDefence();
			int defense2 = s2.getDefence();

			return defense1 - defense2;
		}
	};

	// suivant l'attribut de priorite d'attaque
	public static Comparator<Unit> unitAttackCompare = new Comparator<Unit>() {

		public int compare(Unit s1, Unit s2) {

			int attack1 = s1.getAttack();
			int attack2 = s2.getAttack();

			return attack1 - attack2;
		}
	};

	// si jamais egalite dans le lance de de pour les unites attaquantes
	public static Comparator<Unit> unitADiceCompare = new Comparator<Unit>() {

		public int compare(Unit s1, Unit s2) {

			int scoreDice1 = s1.getScoreDice();
			int scoreDice2 = s2.getScoreDice();
			int attack1 = s1.getAttack();
			int attack2 = s2.getAttack();

			if (scoreDice1 == scoreDice2){
				return attack1 - attack2;
			}else{
				return scoreDice2 - scoreDice1;
			}
		}
	};

	// si jamais egalite dans le lance de de pour les unites defensives
	public static Comparator<Unit> unitDDiceCompare = new Comparator<Unit>() {

		public int compare(Unit s1, Unit s2) {

			int scoreDice1 = s1.getScoreDice();
			int scoreDice2 = s2.getScoreDice();
			int defense1 = s1.getDefence();
			int defense2 = s2.getDefence();

			if (scoreDice1 == scoreDice2){
				return defense1 - defense2;
			}else{
				return scoreDice2 - scoreDice1;
			}
		}
	};
}
