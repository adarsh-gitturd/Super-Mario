package game.mario.bros.clones;

import game.mario.bros.graphics.Cloud;
import game.mario.bros.main.Game;

public class CloudSpawner extends CloneManager<Cloud>{
	
	public CloudSpawner(Game game){
		super(game);
		createObjects();
	}

	public void createObjects() {
		for(int i = 0; i < 1000; i++){
			items.add(new Cloud(game,i*20*rand.nextInt(100),100));
		}
	}
}
