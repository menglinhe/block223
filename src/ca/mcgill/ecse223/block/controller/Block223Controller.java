package ca.mcgill.ecse223.block.controller;

import java.util.List;

class Block223Controller {

	// ****************************
	// Modifier methods
	// ****************************
	
	// feature 1 add a game
	public static void createGame(String name) throws InvalidInputException {
	}

	// feature 2 define game settings
	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
	}

	// feature 3 delete a game
	public static void deleteGame(String name) throws InvalidInputException {
	}

	// feature 4 update a game
	public static void selectGame(String name) throws InvalidInputException {
	}

	// feature 4
	public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
	}

	// feature 5 add a block to the game
	public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
	}

	// feature 6 delete a block from a game
	public static void deleteBlock(int id) throws InvalidInputException {
	}

	// feature 7
	public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {
	}

	// feature 8
	public static void positionBlock(int id, int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
	}

	// feature 9
	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
			int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
	}

	// feature 10
	public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
	}

	// feature 11
	public static void saveGame() throws InvalidInputException {
	}
	
	// feature 12
	public static void register(String username, String playerPassword, String adminPassword)
			throws InvalidInputException {
	}

	// feature 12
	public static void login(String username, String password) throws InvalidInputException {
	}

	// feature 12
	public static void logout() {
	}

	// ****************************
	// Query methods
	// ****************************
	
	// feature 3
	public static List<TOGame> getDesignableGames() {
	}

	// feature 4
	public static TOGame getCurrentDesignableGame() {
	}

	// feature 6
	public static List<TOBlock> getBlocksOfCurrentDesignableGame() {
	}

	// feature 7
	public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {
	}

	// feature 8
	public List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
	}

	// feature 12
	public static TOUserMode getUserMode() {
	}

}