import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CollisionMap {
	private ArrayList<CollisionTile> tiles;
	
	public CollisionMap(File file) throws IOException {
		tiles = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		int r = 0;
		while (scanner.hasNextLine()) {
			String row = scanner.nextLine();
			for (int i = 0; i < row.length(); i++) {
				if (row.charAt(i) == '1') {
					tiles.add(new CollisionTile(i * Tile.TILE_WIDTH, r * Tile.TILE_HEIGHT));
				}
			}
			r++;
		}
	}
	
	public Tile checkCollision(int x, int y) {
		for (CollisionTile tile : tiles) {
			if (x + 10 > tile.getX()
					&& x < tile.getX() + Tile.TILE_WIDTH
					&& y + 10 > tile.getY()
					&& y < tile.getY() + Tile.TILE_HEIGHT) {
				return tile;
			}
		}
		
		return null;
	}
}
