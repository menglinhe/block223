package ca.mcgill.ecse223.block.application;

import ca.mcgill.ecse223.block.model.*;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223Page;

public class Block223Application {
	
	private static Block223 block223;
	// returns the root block223 object
	public static Block223 getBlock223() {
		if (block223 == null) {
			// load model
			block223 = Block223Persistence.load();
		}
		return block223;
	}
	
	
	// forces a load from the file and return the root block223 object
	public static resetBlock223() {
		
	}
	
	
	// remember the currently logged in user role
	public static void setCurrentUserRole(UserRole aUserRole) {
		
	}

	
	// return the currently logged in user role
	public static getCurrentUserRole() {
		
	}
	
	
	// remember the current game
	public static void setCurrentGame(Game aGame) {
		
	}
	
	
	// return the current game
	public static getCurrentGame() {
		
	}	
		
}
