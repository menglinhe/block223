/*
 * Block223, author p17 of ecse223 2019W class
 * Students: Ahmet Akgul, Mehdi Ammar, Nick Prudie, Omar Noor, Tian Ci Liu, Menglin He
 * Block223: term-long course project, simple block/ball game
 * Functionality: as an admin, define game setting (levels, balls, blocks, test and publish game
 * as a player, start/pause/resume the game by hitting space key, move the paddle by hitting the
 * left/right arrow key on the keyboard, let the ball bounces on the paddle and hits the block
 */

package ca.mcgill.ecse223.block.persistence;

import ca.mcgill.ecse223.block.model.Block223;

public class Block223Persistence {

	private static String filename = "data.block223";
	
	public static void save(Block223 block223) {
		PersistenceObjectStream.serialize(block223);
	}
	
	public static Block223 load() {
		PersistenceObjectStream.setFilename(filename);
		Block223 block223 = (Block223) PersistenceObjectStream.deserialize();
		// if model can not be loaded, create an empty Block223
		if (block223 == null) {
			block223 = new Block223();
		}
		else {
			block223.reinitialize();
		}
		return block223;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}
