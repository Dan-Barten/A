package school.game;

import java.awt.Color;
import java.awt.Graphics;

public class SeekerEnemy extends Enemy {
	Player playerCopy;
	
	public SeekerEnemy(int x, int y, Player player) {
		super(x, y, 20, 20);
		playerCopy = player;
	}


	public void update() {
		horVelc = 0;
		vertVelc = 0;
		search(playerCopy);
		x += horVelc;
		y += vertVelc;
		
		
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.red);
	g.drawOval(x, y, width, height);
		
	}

	
	public void search(Player player) {
		if (player.x > x ) {
			horVelc += 4;
		} 
		if (player.x < x ) {
			horVelc -= 4;
		} 
		if (player.y > y ) {
			vertVelc += 4;
		} 
		if (player.y < y ) {
			vertVelc -= 4;
		} 
		
		
	}


	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

}
