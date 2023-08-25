import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Viewport extends JPanel {
	static public final int W_WIDTH = 640;
	static public final int W_HEIGHT = 480;
	
	// This contains info for sprites and the tilemap
	private Game game;
	// This is the x-coordinate of the left edge of the viewport.
	// y is fixed as of now
	private int x;
	
	private int marginX;
	private int marginY;
	
	private Sprite target;
	
	private ColorTileMap colorMap;
	
	public Viewport(Game game, ColorTileMap colorMap, int x, int marginX, int marginY) {
		super();
		this.game = game;
		this.x = x;
		this.marginX = marginX;
		this.marginY = marginY;
		this.target = game.targetSprite();
		this.colorMap = colorMap;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		colorMap.draw(g, x);
		if (target.getX() > (x + W_WIDTH) - marginX) {
			x = target.getX() - (W_WIDTH - marginX);
		}
		
		if (target.getX() < x + marginX) {
			x = target.getX() - marginX;
		}
		
		ArrayList<Sprite> sprites = game.getSprites();
		for (int i = 0; i < sprites.size(); i++) {
			Sprite current = sprites.get(i);
			if (x <= current.getX() && current.getX() <= x + W_WIDTH) {
				current.draw(g, current.getX() - x, current.getY());
			}
		}
	}
}
