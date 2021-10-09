package game.mario.bros.tiles;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Tile extends Entity{
	public static int tile_size = 50;
	
	public Tile(Game game, float x, float y) {
		super(game, EntityID.tile, x, y, tile_size, tile_size);
	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(Assets.tile, (int)x, (int)y, width, height, null);
	}

}

