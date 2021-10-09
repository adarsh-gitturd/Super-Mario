package game.mario.bros.clones;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import game.mario.bros.entites.Chomper;
import game.mario.bros.main.Game;
import game.mario.bros.tiles.Pipe;
import game.mario.bros.tiles.Tile;

public class PipeSpawner extends CloneManager<Pipe>{
	private ArrayList<Chomper> chompers;
	private Random random;
	
	public PipeSpawner(Game game) {
		super(game);
		chompers = new ArrayList<Chomper>();
		random = new Random();
		createObjects();
		spawnChomperOnPipe();
	}

	public void update() {
		for(int i = 0; i < items.size(); i++){
			items.get(i).update();
		}
		for(int i = 0; i < chompers.size(); i++){
			chompers.get(i).update();
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < chompers.size(); i++){
			chompers.get(i).render(g);
		}
		for(int i = 0; i < items.size(); i++){
			items.get(i).render(g);
		}
	}

	protected void createObjects() {
		int y = Game.HEIGHT - Tile.tile_size - 110;
		for(int i = 0; i < 4; i++){
			items.add(new Pipe(game, random.nextInt(4000), y));
		}
	}
	
	private void spawnChomperOnPipe(){
		for(int i = 0; i < items.size(); i++){
			chompers.add(new Chomper(game,items.get(i).getX(),items.get(i).getY() - 40));
		}
	}
	
	public ArrayList<Chomper> getChompers(){
		return chompers;
	}

}
