import java.awt.Color;
import java.awt.Graphics;

public abstract class Sprite {
	private int x;
	private int y;
	
	private double dx;
	private double dy;
	
	public Sprite(int x, int y) {
		this.dx = 0;
		this.dy = 0;
		
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics g, int x, int y);
	
	public void move() {
		x += dx;
		y += dy;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}
}
