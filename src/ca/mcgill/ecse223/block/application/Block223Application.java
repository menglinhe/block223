/*
 * Block223, author p17 of ecse223 2019W class
 * Students: Ahmet Akgul, Mehdi Ammar, Nick Prudie, Omar Noor, Tian Ci Liu, Menglin He
 * Block223: term-long course project, simple block/ball game
 * Functionality: as an admin, define game setting (levels, balls, blocks, test and publish game
 * as a player, start/pause/resume the game by hitting space key, move the paddle by hitting the
 * left/right arrow key on the keyboard, let the ball bounces on the paddle and hits the block
 */
package ca.mcgill.ecse223.block.application;

import javax.swing.UIManager;

import ca.mcgill.ecse223.block.model.*;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223Page;

public class Block223Application {
	
	private static Block223 block223;
	private static UserRole currentUserRole;
	private static Game currentGame;
	private static PlayedGame currentPlayableGame;
	
	public static void main(String[] args) {
	// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                new Block223Page().setVisible(true);
            }
        });
	}
	
	// returns the root block223 object
	public static Block223 getBlock223() {
		if (block223 == null) {
			block223 = Block223Persistence.load();
		}
		return block223;
	}
	
	// forces a load from the file and return the root block223 object
	public static Block223 resetBlock223() {
		if (block223 != null) {
			block223.delete();
		}
		setCurrentGame(null);
		setCurrentPlayableGame(null);
		block223 = Block223Persistence.load();
		return block223;
	}
	
	
	// remember the currently logged in user role
	// change setCurrentUserRole to type UserRole, add return statement, modification wrt the logout() feature
	public static void setCurrentUserRole(UserRole aUserRole) {
		currentUserRole = aUserRole;
	}
	
	// return the currently logged in user role
	public static UserRole getCurrentUserRole() {
		return currentUserRole;
	}	
	
	// remember the current game
	public static void setCurrentGame(Game aGame) {
		currentGame = aGame;
	}
	
	// return the current game
	public static Game getCurrentGame() {
		return currentGame;
	}
	
	public static void setCurrentPlayableGame(PlayedGame aGame) {
		currentPlayableGame = aGame;
	}

	public static PlayedGame getCurrentPlayableGame() {
		return currentPlayableGame;
	}
		
}
