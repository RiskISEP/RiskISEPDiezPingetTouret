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

        for (Unit unit :
                units) {
            System.out.println(unit);
        }


    
    }
}
