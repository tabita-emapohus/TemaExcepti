
public class Ball {

	private int x;
    private int y;
    
    
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
    
	public void shoot() throws OutException, GolException, CornerException {
        CoordinateGenerator generator = new CoordinateGenerator();
        int newX = generator.generateX();
        int newY = generator.generateY();

        x = newX;
        y = newY;

        if (y == 0 || y == 50) {
            throw new OutException("Out: Minge la coordonatele (" + x + "," + y + ")");
        }
        if ((x == 0 || x == 100) && y >= 20 && y <= 30) {
            throw new GolException("Gol: Minge la coordonatele (" + x + "," + y + ")");
        }
        if ((x == 0 || x == 100) && (y < 20 || y > 30)) {
            throw new CornerException("Corner: Minge la coordonatele (" + x + "," + y + ")");
        }
    }
    
}
