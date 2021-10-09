package game.mario.bros.handlers;

import game.mario.bros.clones.GoombaSpawner;
import game.mario.bros.clones.MushroomTileSpawner;
import game.mario.bros.entites.Mario;
import game.mario.bros.main.Game;

public class CollisionManager {
	private Game game;
	private Mario mario;
	private GoombaSpawner goombaSpawner;
	private MushroomTileSpawner mushroomTileSpawner;

	public CollisionManager(Game game){
		this.game = game;
		mario = game.getMario();
		goombaSpawner = game.getGoombaSpawner();
		mushroomTileSpawner = game.getMushroomTileSpawner();
	}
	
	public void update(){
		// mario kills goomba
		for(int i = 0; i < goombaSpawner.getItems().size(); i++){
			if(Collision.isTouching(goombaSpawner.getItems().get(i).getTopBounds(), mario.getBottomBounds())){
				goombaSpawner.getItems().remove(i);
				mario.points += 200;
				mario.jump();
			}
		}
		//mario touches goomba left
		for(int i = 0; i < goombaSpawner.getItems().size(); i++){
			if(Collision.isTouching(goombaSpawner.getItems().get(i).getLeftBounds(), mario.getRightBounds())){
				if(mario.rank == 1)
					mario.lives--;
					mario.pushLeft();
				if(mario.rank == 2)	
					mario.pushLeft();
					mario.rank = 1;
			}
		}
		//mario touches goomba right
		for(int i = 0; i < goombaSpawner.getItems().size(); i++){
			if(Collision.isTouching(goombaSpawner.getItems().get(i).getRightBounds(), mario.getLeftBounds())){
				if(mario.rank == 1)
					mario.lives--;
					mario.pushRight();
				if(mario.rank == 2)	
					mario.pushRight();
					mario.rank = 1;
			}
		}
		//mario touches chomper
		for(int i = 0; i < game.getPipeSpawner().getChompers().size(); i++){
			if(Collision.isTouching(game.getPipeSpawner().getChompers().get(i).getBounds(), mario.getBounds())){
				if(game.getPipeSpawner().getChompers().get(i).attackable)
					if(mario.rank == 1)
						mario.lives--;
						mario.pushRight();
					if(mario.rank == 2)	
						mario.pushRight();
						mario.rank = 1;
			}
		}
		//mario touches turtle
		for(int i = 0; i < game.getTurtleSpawner().getItems().size(); i++){
			if(Collision.isTouching(game.getTurtleSpawner().getItems().get(i).getBounds(), mario.getBounds())){
				if(mario.rank == 1)
					mario.lives--;
					mario.jump();
				if(mario.rank == 2)	
					mario.jump();
					mario.rank = 1;
			}
		}
		//mario hits mushroom tile spawner to spawn mushroom
		for(int i = 0; i < mushroomTileSpawner.getItems().size(); i++){
			if(Collision.isTouching(mushroomTileSpawner.getItems().get(i).getBounds(), mario.getTopBounds())){
				mushroomTileSpawner.spawnMushroom(mushroomTileSpawner.getItems().get(i));
			}
		}
		//mushroom tile spawner spawnes mushroom 
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			for(int j = 0; j < mushroomTileSpawner.getMushrooms().size(); j++){
				if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), mushroomTileSpawner.getMushrooms().get(j).getBottomBounds())){
					mushroomTileSpawner.getMushrooms().get(j).setxVel(1);
					mushroomTileSpawner.getMushrooms().get(j).setTG(true);
				}
				if(!Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), mushroomTileSpawner.getMushrooms().get(j).getBottomBounds())){
					mushroomTileSpawner.getMushrooms().get(j).setTG(false);
				}
			}
		}
		// charging turtle hits goomba
		for(int i = 0; i < game.getTurtleSpawner().getItems().size(); i++){
			for(int j = 0; j < goombaSpawner.getItems().size(); j++){
				if(goombaSpawner.getItems().get(j).getBounds().intersects(game.getTurtleSpawner().getItems().get(i).getBounds())){
					if(game.getTurtleSpawner().getItems().get(i).getState() == 2)
						goombaSpawner.getItems().remove(j);	
				}
			}
		}
		for(int i = 0; i < game.getCoinSpawner().getItems().size(); i++){
			if(game.getMario().getBounds().intersects(game.getCoinSpawner().getItems().get(i).getBounds())){
				game.getCoinSpawner().getItems().remove(i);
				mario.points += 10;
			}
		}
	}
}
