package game.mario.bros.clones;

import java.util.Random;

import game.mario.bros.entites.Turtle;
import game.mario.bros.main.Game;
import game.mario.bros.tiles.Tile;

public class TurtleSpawner extends CloneManager<Turtle>{

	public TurtleSpawner(Game game) {
		super(game);
		createObjects();
	}

	public void createObjects() {
		int y = Game.HEIGHT - Tile.tile_size - 60;
		for(int i = 0; i < 3; i++){
			items.add(new Turtle(game, new Random().nextInt(2000), y));
		}
	}

}
