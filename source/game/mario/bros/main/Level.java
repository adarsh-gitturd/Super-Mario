package game.mario.bros.main;

import game.mario.bros.clones.CloneManager;
import game.mario.bros.tiles.MushroomTile;
import game.mario.bros.tiles.Tile;

public class Level extends CloneManager<Tile>{
	
	public Level(Game game){
		super(game);
		createObjects();
	}
	
	public void update(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).update();
		}
		if(game.getPortal().getPortalMode() == 2){
			for(int i = 0; i < items.size(); i++){
				items.remove(i);
			}
			for(int i = 0; i < 20; i++){
				add(new Tile(game, i*Tile.tile_size, Game.HEIGHT - Tile.tile_size));
			}
			game.getMario().begin();
		}
	}
	
	public void createObjects(){
		if(game.getPortal().getPortalMode() == 1){
			for(int i = 0; i < 1000; i++){
				add(new Tile(game,i*Tile.tile_size,Game.HEIGHT-Tile.tile_size));
			}
			for(int i = 0; i < 5; i++){
				add(new Tile(game,400 + i*Tile.tile_size,350));
			}
			for(int i = 0; i < 10; i++){
				add(new Tile(game,1400 + i*Tile.tile_size,350));
			}
			for(int i = 0; i < 4; i++){
				add(new Tile(game,2400,Game.HEIGHT-(i*Tile.tile_size)));
			}
			for(int i = 0; i < 5; i++){
				add(new Tile(game, 700 + i*Tile.tile_size, 200));
			}
			for(int i = 0; i < 5; i++){
				add(new Tile(game, 1000 + i*Tile.tile_size, 250));
			}
			for(int i = 0; i < 5; i++){
				add(new Tile(game, 2000 + i*Tile.tile_size, 250));
			}
		}
	}
	
	public void spawnTileOnMushroomTile(MushroomTile mushroomTile){
		items.add(new Tile(game,mushroomTile.getX(),mushroomTile.getY()));
	}
}
