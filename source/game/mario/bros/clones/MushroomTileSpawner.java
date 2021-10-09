package game.mario.bros.clones;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import game.mario.bros.entites.Mushroom;
import game.mario.bros.main.Game;
import game.mario.bros.tiles.MushroomTile;

public class MushroomTileSpawner extends CloneManager<MushroomTile>{
	private ArrayList<Mushroom> mushrooms;
	private Random random;
	
	public MushroomTileSpawner(Game game) {
		super(game);
		mushrooms = new ArrayList<Mushroom>();
		random = new Random();
		createObjects();
	}

	public void update() {
		for(int i = 0; i < items.size(); i++){
			items.get(i).update();
		}
		for(int i = 0; i < mushrooms.size(); i++){
			mushrooms.get(i).update();
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < items.size(); i++){
			items.get(i).render(g);
		}
		for(int i = 0; i < mushrooms.size(); i++){
			mushrooms.get(i).render(g);
		}
	}

	protected void createObjects() {
		for(int i = 0; i < 4; i++){
			items.add(new MushroomTile(game,random.nextInt(2000),350));
		}
	}
	
	public void spawnMushroom(MushroomTile mushroomTile){
		mushrooms.add(new Mushroom(game,mushroomTile.getX(), mushroomTile.getY() - 42));
		items.remove(mushroomTile);
		game.getLevel().spawnTileOnMushroomTile(mushroomTile);
	}
	
	public ArrayList<Mushroom> getMushrooms(){
		return mushrooms;
	}
}
