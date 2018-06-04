public abstract class Mission {

    private String name;
    private String description;
    private Game game;
    private Player player;

    public Mission(String name, String description, Game game, Player player) {
        this.name = name;
        this.description = description;
        this.game = game;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    abstract boolean reached();


}
