import java.awt.Graphics;
import java.util.Set;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
	Player player;
	ArrayList<Sprite> sprites;
	
	public Game(CollisionMap cm) {
		player = new Player(300, 300, 0.2, cm);
		sprites = new ArrayList<>();
		sprites.add(player);
		sprites.add(new TestSprite());
	}
	
	public Sprite targetSprite() {
		return player;
	}
	
	public ArrayList<Sprite> getSprites() {
		return sprites;
	}
	
	public void upPressed() {
		player.jump();
	}
	
	public void leftPressed() {
		player.setDx(-2);
	}
	
	public void rightPressed() {
		player.setDx(2);
	}
	
	public void run(Set<Integer> keys) {
		player.setDx(0);
		if (keys.contains(KeyEvent.VK_UP)) {
			upPressed();
		}
		
		if (keys.contains(KeyEvent.VK_LEFT)) {
			leftPressed();
		}
		
		if (keys.contains(KeyEvent.VK_RIGHT)) {
			rightPressed();
		}
		
		player.move();
	}
}
