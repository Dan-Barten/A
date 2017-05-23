package school.game;

import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	public ArrayList<Enemy> enemyList;
	public EnemyManager() {
		enemyList = new ArrayList<>();
		
	}
	public void draw(Graphics g) {
		for (Enemy e : enemyList) {
			e.draw(g);
		}
		
	}
	public void update(Player player) {
	for (Enemy e : enemyList) {
		e.update();
		
			
	}
	}

		
	
	

}
