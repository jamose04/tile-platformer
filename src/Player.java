import java.awt.Graphics;
import java.awt.Color;

public class Player extends Sprite {
	private final double a;
	private double acc;
	private boolean onGround;
	private CollisionMap collisionMap;
	
	public Player(int x, int y, double a, CollisionMap collisionMap) {
		super(x, y);
		this.a = a;
		this.onGround = false;
		this.acc = a;
		this.collisionMap = collisionMap;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.ORANGE);
		g.drawOval(x, y, 10, 10);
	}
	
	@Override
	public void move() {
		setDy(getDy() + acc);
//		if (getY() > Viewport.W_HEIGHT - 10) {
//			setDy(0);
//			setY(Viewport.W_HEIGHT - 10);
//			acc = 0;
//			onGround = true;
//		}
		setX(getX() + (int) getDx());
		Tile xCollided = collisionMap.checkCollision(getX(), getY());
		if (xCollided != null) {
			// Then we know there is a collision in the x direction.
			// must uncollide
			if (getDx() > 0) {
				setDx(0);
				setX(xCollided.getX() - 10);
			}
			
			if (getDx() < 0) {
				setDx(0);
				setX(xCollided.getX() + Tile.TILE_WIDTH);
			}
		}
		setY(getY() + (int) getDy());
		Tile yCollided = collisionMap.checkCollision(getX(), getY());
		if (yCollided != null) {
			if (getDy() > 0) {
				onGround = true;
				setDy(0);
				setY(yCollided.getY() - 10);
			}
			
			if (getDy() < 0) {
				setDy(0);
				setY(yCollided.getY() + Tile.TILE_HEIGHT);
			}
		}
	}
	
	public void jump() {
		if (onGround) {
			onGround = false;
			acc = a;
			setDy(-6);
		}
	}
}
