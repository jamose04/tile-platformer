import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

// 0 - white, 1 - red, 2 - blue, 3 - green
public class ColorTileMap {
	private ArrayList<ColorTile> tileMap;
	
	/**
	 * Constructor for TileMap. Build a tilemap based one the contents
	 * of file.
	 * @param file
	 */
	public ColorTileMap(File file) throws IOException {
		tileMap = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		int r = 0;
		while (scanner.hasNextLine()) {
			String row = scanner.nextLine();
			for (int c = 0; c < row.length(); c++) {
				assert('0' <= row.charAt(c) && '3' <= row.charAt(c));
				Color color = Color.white;
				boolean add = true;
				switch (row.charAt(c)) {
				case '0':
					color = Color.white;
					break;
				case '1':
					color = Color.red;
					break;
				case '2':
					color = Color.blue;
					break;
				case '3':
					color = Color.green;
					break;
				default:
					add = false;
					break;
				}
				if (add) {
					tileMap.add(new ColorTile(c * Tile.TILE_WIDTH, r * Tile.TILE_HEIGHT, color));
				}
			}
			r++;
		}
		
		scanner.close();
	}
	
	public void draw(Graphics g, int vpX) {
		for (int i = 0; i < tileMap.size(); i++) {
			if (vpX - Tile.TILE_WIDTH < tileMap.get(i).getX() && tileMap.get(i).getX() < (vpX + Viewport.W_WIDTH)) {
				g.setColor(tileMap.get(i).getColor());
				g.fillRect(tileMap.get(i).getX() - vpX, tileMap.get(i).getY(), Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
			}
		}
	}
}
