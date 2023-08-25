import java.awt.Graphics;
import java.awt.Color;

public class TestSprite extends Sprite {
	public TestSprite() {
		super(400, 200);
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.drawOval(x, y, 10, 20);
	}
}
