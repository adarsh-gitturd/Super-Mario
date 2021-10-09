package game.mario.bros.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextRenderer{

	public void render(Graphics g, String a, int x, int y, Color color){
		g.setColor(color);
		Font f = new Font(a,30,30);
		g.setFont(f);
		g.drawString(a, x, y);
	}
}
