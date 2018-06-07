package fr.isep.riskIsep;

import fr.isep.riskIsep.unit.Artillery;
import fr.isep.riskIsep.unit.Cavalry;
import fr.isep.riskIsep.unit.Infantry;
import fr.isep.riskIsep.unit.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void askForPlayers(List<Player> players) {

        do {

            for (int it = players.size() - 1; it >= 0; it--) {
                players.remove(it);
            }

            System.out.print("nombre de joueurs humains : ");
            int nbPlayers = scanner.nextInt();
            scanner.nextLine();

            for (int it = 0; it < nbPlayers; it++) {
                System.out.print("nom du joueur " + (it + 1) + " : ");
                String name = scanner.nextLine();
                if (name.equals("")) {
                    name = "joueur " + (it + 1);
                }
                players.add(new Player(name, false));

            }

            System.out.print("nombre d'IA : ");
            int nbAI = scanner.nextInt();
            scanner.nextLine();

            for (int ai = 0; ai < nbAI; ai++) {
                String name = "joueur " + (players.size() + 1);
                players.add(new Player(name, true));
            }

            System.out.println("nombre de joueurs initialisés : " + players.size());
            int i = 0;
            for (Player player :
                    players) {
                System.out.println(".\tJoueur " + (i++) + " : " + player.getName());
            }
            System.out.println((players.size() < 2 || players.size() > 6) ? "nombre incorrect" : "c'est parti!");
        } while (players.size() < 2 || players.size() > 6);
    }

    public void move(Territory depart, Territory arrive, List<Unit> units) {

        List<Unit> infantriesDepart = new ArrayList<>();
        List<Unit> cavalriesDepart = new ArrayList<>();
        List<Unit> artilleriesDepart = new ArrayList<>();

        for (Unit unit :
                units) {
            if (unit instanceof Infantry) {
                infantriesDepart.add(unit);
            }
            if (unit instanceof Cavalry) {
                cavalriesDepart.add(unit);
            }
            if (unit instanceof Artillery) {
                artilleriesDepart.add(unit);
            }
        }

        System.out.println("Vous avez " + infantriesDepart.size() + " de soldats sur ce territoire.");
        System.out.println("Vous avez " + cavalriesDepart.size() + " de cavaliers sur ce territoire.");
        System.out.println("Vous avez " + artilleriesDepart.size() + " de canons sur ce territoire.");

        int nbMovingSoldier;
        int nbMovingCavalry;
        int nbMovingCanon;

        do {
            System.out.println("Combien de soldats voulez-vous deplacer ?");
            nbMovingSoldier = scanner.nextInt();
            scanner.nextLine();
        } while (infantriesDepart.size()>=nbMovingSoldier);

        do {
            System.out.println("Combien de cavaliers voulez-vous deplacer ?");
            nbMovingCavalry = scanner.nextInt();
            scanner.nextLine();
        } while (cavalriesDepart.size()>=nbMovingCavalry);

        do {
            System.out.println("Combien de canons voulez-vous deplacer ?");
            nbMovingCanon = scanner.nextInt();
            scanner.nextLine();
        } while (artilleriesDepart.size()>=nbMovingCanon);


        for (Unit unit :
                units) {
            if (unit instanceof Infantry && nbMovingSoldier > 0) {
                units.remove(unit);
                arrive.getUnits().add(unit);
                nbMovingSoldier --;
            }
            if (unit instanceof Cavalry && nbMovingCavalry > 0) {
                units.remove(unit);
                arrive.getUnits().add(unit);
                nbMovingCavalry --;
            }
            if (unit instanceof Artillery && nbMovingCanon > 0) {
                units.remove(unit);
                arrive.getUnits().add(unit);
                nbMovingCanon --;
            }
        }

        List<Unit> infantriesArrive = new ArrayList<>();
        List<Unit> cavalriesArrive = new ArrayList<>();
        List<Unit> artilleriesArrive = new ArrayList<>();

        for (Unit unit :
                arrive.getUnits()) {
            if (unit instanceof Infantry) {
                infantriesArrive.add(unit);
            }
            if (unit instanceof Cavalry) {
                cavalriesArrive.add(unit);
            }
            if (unit instanceof Artillery) {
                artilleriesArrive.add(unit);
            }
        }

        System.out.println("Il vous reste " + infantriesDepart.size() + "dans votre territoire de départ.");
        System.out.println("Vous avez maintenant " + infantriesArrive.size() + "dans votre territoire d'arrivee.");
        System.out.println("Il vous reste " + cavalriesDepart.size() + "dans votre territoire de départ.");
        System.out.println("Vous avez maintenant " + cavalriesArrive.size() + "dans votre territoire d'arrivee.");
        System.out.println("Il vous reste " + artilleriesDepart.size() + "dans votre territoire de départ.");
        System.out.println("Vous avez maintenant " + artilleriesArrive.size() + "dans votre territoire d'arrivee.");

    }

    public int[] attack(Territory attacker, Territory defender, List<Unit> attackingUnits) {
    	int[] diceResult = new int[5];

        System.out.println(attacker.getName());
        System.out.println(defender.getName());
        System.out.println(attackingUnits);

        if (/**!(attacker.getPlayer().isMine(defender)) &&**/ attacker.isBorderOf(defender)) {
            List<Unit> defendingUnits = new ArrayList<>();
            System.out.println("prout0");
            if (attackingUnits.size() <= 3) {
                Collections.sort(defender.getUnits(), Unit.unitDefenseCompare);
                defendingUnits.add(defender.getUnits().get(0));
                if (attackingUnits.size() >= 2) {
                    defendingUnits.add(defender.getUnits().get(1));
                    System.out.println(defendingUnits.get(0));
                }
            }

	        int c = 0;
            for (Unit unit :
                    attackingUnits) {
	            diceResult[c] = unit.dice();
                unit.setScoreDice(diceResult[c]);
	            c++;
            }
            Collections.sort(attackingUnits, Unit.unitADiceCompare);
            System.out.println(attackingUnits);

            System.out.println(attackingUnits.get(0));

            c = 0;
            for (Unit unit :
                    defendingUnits) {
            	diceResult[3+c] = unit.dice();
                unit.setScoreDice(diceResult[3+c]);
                c++;
            }
            Collections.sort(defendingUnits, Unit.unitDDiceCompare);
            System.out.println("prout3");

            System.out.println("prout4");

            for (int i = 0; i < attackingUnits.size(); i++) {
                for (int j = 0; j < defendingUnits.size(); j++) {
                    if (i == j) {
                        if (attackingUnits.get(i).getScoreDice() > defendingUnits.get(j).getScoreDice()) {
                            defender.getUnits().remove(defendingUnits.get(j));
                            defendingUnits.remove(defendingUnits.get(j));
                            System.out.println("prout5");
                        }
                        else if (attackingUnits.get(i).getScoreDice() < defendingUnits.get(j).getScoreDice() || attackingUnits.get(i).getScoreDice() == defendingUnits.get(j).getScoreDice()) {
                            attacker.getUnits().remove(attackingUnits.get(i));
                            attackingUnits.remove(attackingUnits.get(i));
                        }
                    }
                }
            }

            System.out.println("prout6");

            if (defender.getUnits().size() == 0) {
                move(attacker, defender, attackingUnits);
                defender.getPlayer().getTerritories().remove(defender);
                attacker.getPlayer().getTerritories().add(defender);
            }

            System.out.println("prout7");

            //}
        }
        return diceResult;
    }
}
