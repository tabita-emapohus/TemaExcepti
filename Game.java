
public class Game {

	private String team1;
    private String team2;
    private int goalsTeam1;
    private int goalsTeam2;
    private int outCount;
    private int cornerCount;

    public Game(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.goalsTeam1 = 0;
        this.goalsTeam2 = 0;
        this.outCount = 0;
        this.cornerCount = 0;
    }

    public void simulate() {
        Ball ball = new Ball(50, 25);
        for (int i = 0; i < 1000; i++) {
            try {
                ball.shoot();
                System.out.println(team1 + " - " + team2 + " : Ball is at coordinates (" + ball.getX() + "," + ball.getY() + ")");
            } catch (OutException e) {
                outCount++;
                System.out.println(e.getMessage());
            } catch (GolException e) {
                if (i % 2 == 0) {
                    goalsTeam1++;
                } else {
                    goalsTeam2++;
                }
                System.out.println(e.getMessage());
                ball = new Ball(50, 25);
            } catch (CornerException e) {
                cornerCount++;
                System.out.println(e.getMessage());
                int newY;
				if (ball.getY() <= 25) {
                    newY = 0;
                } else {
                    newY = 50;
                }
                if (ball.getX() == 0) {
                    ball = new Ball(0, newY);
                } else {
                    ball = new Ball(100, newY);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Match between " + team1 + " and " + team2 + "\n" +
               "Score: " + team1 + " " + goalsTeam1 + " - " + goalsTeam2 + " " + team2 + "\n" +
               "Outs: " + outCount + "\n" +
               "Corners: " + cornerCount;
    }
    
}
