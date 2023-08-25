import java.awt.Graphics;
import java.awt.Color;

public class ColorTile extends Tile {
	private Color color;
	
	public ColorTile(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(getX(), getY(), TILE_WIDTH, TILE_HEIGHT);
	}
	
	public Color getColor() {
		return color;
	}
}
