import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void initKeys(JFrame frame, Game game, Set<Integer> keys) {
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				keys.add(e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				keys.remove(e.getKeyCode());
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				return;
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Scrolling");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(640, 515);
		File cf = new File("collision");
		CollisionMap cm = new CollisionMap(cf);
		Game game = new Game(cm);
		
		File f = new File("tilemap");
		
		ColorTileMap tm = new ColorTileMap(f);
		
		Viewport viewport = new Viewport(game, tm, 0, 200, 200);
		frame.add(viewport);
		frame.setVisible(true);
		
		Set<Integer> keys = new HashSet<Integer>();
		
		initKeys(frame, game, keys);
		
		Timer timer = new Timer(17, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().sync();
				game.run(keys);
				frame.repaint();
			}
		});
		
		timer.start();
	}
}
