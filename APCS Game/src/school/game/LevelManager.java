package school.game;
import java.util.ArrayList;
import java.util.Random;
public class LevelManager {
int level, baseSeekers, baseRandoms, numSeekers, numRandoms;
Random generator = new Random();
public LevelManager() {
	level = 0;
	
baseSeekers = -1;
baseRandoms = 1;
}
public void nextLevel(ArrayList arr, Player player) {
	
	System.out.println("NEXT LEVEL"); 
	level++;
	numSeekers = baseSeekers + generator.nextInt(2);
	numRandoms = baseRandoms + generator.nextInt(2);
	
	for (int i = numRandoms; i > 0; i--) {
		arr.add(new RandomEnemy(generator.nextInt(Game.WINDOW_WIDTH), generator.nextInt(Game.WINDOW_HEIGHT)));
		
	}
	for (int i = numSeekers; i > 0; i--) {
		arr.add(new SeekerEnemy(generator.nextInt(Game.WINDOW_WIDTH),generator.nextInt(Game.WINDOW_HEIGHT),player));
		
	}
	baseSeekers++; baseRandoms++;
	 player.x = (Game.WINDOW_WIDTH - player.width) / 2;
     player.y = (Game.WINDOW_HEIGHT - player.height) / 2;
}
}
