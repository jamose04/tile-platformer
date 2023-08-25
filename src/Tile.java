public abstract class Tile {
	
	public final static int TILE_WIDTH = 32;
	public final static int TILE_HEIGHT = 32;
	private int x;
	private int y;
	//private Color color;
	
	// All tiles are 20x20
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		//this.color = color;
	}
	
//	public void draw(Graphics g) {
//		g.setColor(color);
//		g.fillRect(x, y, 20, 20);
//	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
//	public Color getColor() {
//		return color;
//	}
}
