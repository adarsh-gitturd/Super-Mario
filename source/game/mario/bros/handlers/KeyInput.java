package game.mario.bros.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.mario.bros.graphics.Assets;
import game.mario.bros.main.Game;

public class KeyInput implements KeyListener{
	Game game;
	
	public KeyInput(Game game){
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			game.getMario().setxVel(-7);
			game.getMario().setImage(Assets.r_m_l);
			game.getMario().facing = 0;
		}
		if(code == KeyEvent.VK_RIGHT){
			game.getMario().setxVel(7);
			game.getMario().setImage(Assets.r_m_r);
			game.getMario().facing = 1;
		}
		if(code == KeyEvent.VK_UP){
			game.getMario().setJumping(true);
			if(game.getMario().facing == 1)
				game.getMario().setImage(Assets.j_m_r);
			if(game.getMario().facing == 0)
				game.getMario().setImage(Assets.j_m_l);
		}
		if(code == KeyEvent.VK_SPACE){
			game.getMario().createPlatform();
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			game.getMario().setxVel(0);
			game.getMario().setImage(Assets.s_m_l);
		}
		if(code == KeyEvent.VK_RIGHT){
			game.getMario().setxVel(0);
			game.getMario().setImage(Assets.s_m_r);
		}
		if(code == KeyEvent.VK_UP){
			game.getMario().setJumping(false);
			if(game.getMario().facing == 1)
				game.getMario().setImage(Assets.s_m_r);
			if(game.getMario().facing == 0)
				game.getMario().setImage(Assets.s_m_l);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
