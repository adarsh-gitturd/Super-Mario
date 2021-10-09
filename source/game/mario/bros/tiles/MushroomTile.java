package game.mario.bros.tiles;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class MushroomTile extends Entity{

	public MushroomTile(Game game, float x, float y) {
		super(game, EntityID.mushroom_tile, x, y, Tile.tile_size, Tile.tile_size);
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.mushroom_tile, (int)x, (int)y, width, height, null);
	}

}
