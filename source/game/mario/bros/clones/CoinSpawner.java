package game.mario.bros.clones;

import game.mario.bros.entites.Coin;
import game.mario.bros.main.Game;

public class CoinSpawner extends CloneManager<Coin>{

	public CoinSpawner(Game game) {
		super(game);
		createObjects();
	}

	protected void createObjects() {
		for(int i = 0; i < 30; i++){
			add(new Coin(game,i*200,100));		
		}
	}

}
