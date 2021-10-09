package game.mario.bros.clones;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import game.mario.bros.entites.Entity;
import game.mario.bros.main.Game;

public abstract class CloneManager<T extends Entity>{
	protected ArrayList<T> items;
	protected Random rand;
	protected Game game;
	
	protected CloneManager(Game game){
		this.game = game;
		items = new ArrayList<T>();
		rand = new Random();
	}
	
	public void update(){
		for(int i = 0; i < items.size(); i++){
			items.get(i).update();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < items.size(); i++){
			items.get(i).render(g);
		}
	}

	protected abstract void createObjects();

	protected void add(T t){
		items.add(t);
	}
	
	public ArrayList<T> getItems(){
		return items;
	}
}
