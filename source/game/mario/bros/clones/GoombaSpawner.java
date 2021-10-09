package game.mario.bros.clones;

import game.mario.bros.entites.Goomba;
import game.mario.bros.main.Game;
import game.mario.bros.tiles.Tile;

public class GoombaSpawner extends CloneManager<Goomba>{

	public GoombaSpawner(Game game) {
		super(game);
		createObjects();
	}

	public void createObjects() {
		int y = Game.HEIGHT - Tile.tile_size - 50;
		add(new Goomba(game,100,y));
		add(new Goomba(game,400,y));
		add(new Goomba(game,700,y));
		add(new Goomba(game,1000,y));
		add(new Goomba(game,1300,y));
		add(new Goomba(game,1600,y));
		add(new Goomba(game,1900,y));
		add(new Goomba(game,2200,y));
	}

}
