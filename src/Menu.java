import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void askForPlayers(List<Player> players) {

        System.out.print("nombre de joueurs humains : ");
        int nbPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int it = 0; it < nbPlayers; it++) {
            System.out.print("nom du joueur " + (it + 1) + " : ");
            String name = scanner.nextLine();
            players.add(new Player(name, false));

        }

        System.out.print("nombre d'IA : ");
        int nbAI = scanner.nextInt();
        scanner.nextLine();

        for (int ai = 0; ai < nbAI; ai++) {
            String name = "joueur" + ai;
            players.add(new Player(name, true));
        }
    }
}
