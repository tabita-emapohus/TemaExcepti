
public class Main {

	public static void main(String[] args) {
		Game game1 = new Game("Team1", "Team2");
        game1.simulate();
        System.out.println(game1);

        Game game2 = new Game("Team3", "Team4");
        game2.simulate();
        System.out.println(game2);

	}

}
