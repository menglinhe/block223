package ca.mcgill.ecse223.block.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ca.mcgill.ecse223.block.model.*;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.application.Block223Application;
import ca.mcgill.ecse223.block.controller.TOUserMode.Mode;

public class Block223Controller {

	// ****************************
	// Modifier methods
	// ****************************

	// feature 1 add a game
	public static void createGame(String name) throws InvalidInputException {
		Block223 block223 = Block223Application.getBlock223();
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) 
		{
			throw new InvalidInputException("Admin privileges are required to create a game.");
		}
		UserRole role = Block223Application.getCurrentUserRole();
		Admin admin = (Admin) role;
		try {
			Game game = new Game(false, name,1,admin,1,1,0,0,1,1, 1, 10, 0, 100, 10, block223);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		try {
			selectGame(name);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

	// feature 2 define game settings
	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException 
	{
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) 
		{
			throw new InvalidInputException("Admin privileges are required to define game settings.");
		}

		Game game = Block223Application.getCurrentGame();

		if (game == null) 
		{
			throw new InvalidInputException("A game must be selected to define game settings.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) 
		{
			throw new InvalidInputException("Only the admin who created the game can define its game settings.");
		}
		if (nrLevels < 1 || nrLevels > 99)
		{
			throw new InvalidInputException("The number of levels must be between 1 and 99.");
		}
		if ((minBallSpeedX == 0) && (minBallSpeedY == 0)) {
			throw new InvalidInputException("The minimum speed of the ball must be greater than zero.");
		}
		
        try {
		game.setNrBlocksPerLevel(nrBlocksPerLevel);
        }
        catch (RuntimeException e) {
        	throw new InvalidInputException(e.getMessage());
        }
		Ball ball = game.getBall();
		try {
			game.setNrBlocksPerLevel(nrBlocksPerLevel);
			ball.setMinBallSpeedX(minBallSpeedX);
			ball.setMinBallSpeedY(minBallSpeedY);
			ball.setBallSpeedIncreaseFactor(ballSpeedIncreaseFactor);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		Paddle paddle = game.getPaddle();
		try {
			paddle.setMaxPaddleLength(maxPaddleLength);
			paddle.setMinPaddleLength(minPaddleLength);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		List<Level> levels = game.getLevels();
		int size = levels.size();
		while (nrLevels > size) {
			game.addLevel();
			size = levels.size();
		}
		while (nrLevels < size) {
			Level level = game.getLevel(size-1);
			level.delete();
			size = levels.size();
		}
	}

	// feature 3 delete a game
	public static void deleteGame(String name) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		if (!(currentRole instanceof Admin)) {
			JOptionPane.showMessageDialog(null, "Admin privileges are required to delete a game.");
			throw new InvalidInputException("Admin privileges are required to delete a game.");
		}
		else {
			Block223 block223 = Block223Application.getBlock223();
			Game game = block223.findGame(name);
			if(game != null) {
				if ((game.getAdmin()!=currentRole)) {
					JOptionPane.showMessageDialog(null, "Only the admin who created the game can delete the game.");
					throw new InvalidInputException("Only the admin who created the game can delete the game.");
				}
				else {
					game.delete();
					Block223Persistence.save(block223);
				}
			}
		}
	}

	// feature 4 update a game
	public static void selectGame(String name) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		if (!(currentRole instanceof Admin)) {
			JOptionPane.showMessageDialog(null, "Admin privileges are required to select a game.");
			throw new InvalidInputException("Admin privileges are required to select a game.");
		}
		else {
			Block223 block223 = Block223Application.getBlock223();
			Game game = block223.findGame(name);
			if(game == null) {
				JOptionPane.showMessageDialog(null, "A game with name " + name + " does not exist.");
				throw new InvalidInputException("A game with name " + name + " does not exist.");
			}
			else {
				if ((game.getAdmin()!=currentRole)) {
					JOptionPane.showMessageDialog(null, "Only the admin who created the game can select the game.");
					throw new InvalidInputException("Only the admin who created the game can select the game.");
				}
				else
				{
					Block223Application.setCurrentGame(game);
				}
			}
		}
	}

	// feature 4
	public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		if (currentRole instanceof Admin) {
			Game game = Block223Application.getCurrentGame();
			if(game != null) {
				if (game.getAdmin().equals(currentRole)) {
					if(!game.getName().equals(name)) { //game name is not same as before
						if (!game.setName(name))	{ //game name does not copy another existing game's name
							JOptionPane.showMessageDialog(null, "The name of a game must be unique.");
							throw new InvalidInputException("The name of a game must be unique.");
						}
					}
					setGameDetails(nrLevels, nrBlocksPerLevel, minBallSpeedX, minBallSpeedY, ballSpeedIncreaseFactor, maxPaddleLength, minPaddleLength);
				}
				else {
					JOptionPane.showMessageDialog(null, "Only the admin who created the game can define its game settings.");
					throw new InvalidInputException("Only the admin who created the game can define its game settings.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "A game must be selected to define game settings.");
				throw new InvalidInputException("A game must be selected to define game settings.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Admin privileges are required to define game settings.");
			throw new InvalidInputException("Admin privileges are required to define game settings.");
		}
		
	}

	// feature 5 add a block to the game
	public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();

		if(!(currentRole instanceof Admin)) {
			String error = "Admin privileges are required to add a block.";
			throw new InvalidInputException(error);
		}
		Game game = Block223Application.getCurrentGame();
		if(game==null) {
			String error = "A game must be selected to add a block.";
			throw new InvalidInputException(error);
		}
		if(!game.getAdmin().equals(currentRole)) {
			String error = "Only the admin who created the game can add a block.";
			throw new InvalidInputException(error);
		}
		List<Block> blocks = game.getBlocks();
		for(Block block : blocks) {
			if(block.getRed()==red && block.getGreen()==green && block.getBlue()==blue) {
				String error = "A block with the same color already exists for the game.";
				throw new InvalidInputException(error);
			}
		}

		try{
			Block newBlock = new Block(red, green, blue, points, game);
		} 
		catch (RuntimeException e) {
			String error = e.getMessage();
			throw new InvalidInputException(error);
		}
	}

	// feature 6 delete a block from a game
	public static void deleteBlock(int id) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();

		if(!(currentRole instanceof Admin)) {
			String error = "Admin privileges are required to delete a block.";
			throw new InvalidInputException(error);
		}
		Game game = Block223Application.getCurrentGame();
		if(game==null) {
			String error = "A game must be selected to delete a block.";
			throw new InvalidInputException(error);
		}
		if(game.getAdmin()!=currentRole) {
			String error = "Only the admin who created the game can delete a block.";
			throw new InvalidInputException(error);
		}
		Block toDelete = game.findBlock(id);
		if(toDelete!=null) {
			toDelete.delete();
		}
	}

	// feature 7
	public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to update a block.");
		}
		Game game = Block223Application.getCurrentGame();
		if (game == null) {
			throw new InvalidInputException("A game must be selected to update a block.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can update a block.");
		}

		List<Block> blocks = game.getBlocks();
		for (Block aBlock : blocks) {
			if (aBlock.getRed() == red && aBlock.getGreen() == green && aBlock.getBlue() == blue) {
				throw new InvalidInputException("A block with the same color already exists for the game.");
			}
		} 

		Block block = game.findBlock(id);
		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}

		try {
			block.setRed(red);
			block.setGreen(green);
			block.setBlue(blue);
			block.setPoints(points);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	// feature 8
	public static void positionBlock(int id, int levelIndex, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to position a block.");
		}
		Game game = Block223Application.getCurrentGame();
		if (game == null) {
			throw new InvalidInputException("A game must be selected to position a block.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can position a block.");
		}

		Level level;
		try {
			level = game.getLevel(levelIndex - 1);
		}
		catch(IndexOutOfBoundsException e) {
			throw new InvalidInputException(e.getMessage());
		}

		if (level.numberOfBlockAssignments() >= game.getNrBlocksPerLevel()) {
			throw new InvalidInputException("The number of blocks has reached the maximum number (" + game.getNrBlocksPerLevel() + ") allowed for this game.");
		}

		if (level.findBlockAssignment(gridHorizontalPosition, gridVerticalPosition) != null) {
			throw new InvalidInputException("A block already exists at location " + gridHorizontalPosition + "/" + gridVerticalPosition + ".");	
		}

		Block block = game.findBlock(id);
		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}
		
		try {
			BlockAssignment blockAssignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition, level, block, game);
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	// feature 9
	public static void moveBlock(int indexLevel, int oldGridHorizontalPosition, int oldGridVerticalPosition,
			int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
		Level level = null;
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to move a block.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to move a block.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can move a block.");
		}
		Game game = Block223Application.getCurrentGame();
		try {
			level = game.getLevel(indexLevel - 1);
		}
		catch(IndexOutOfBoundsException e) {
			throw new InvalidInputException(e.getMessage());
		}	

		if (level.findBlockAssignment(newGridHorizontalPosition, newGridVerticalPosition) != null) { // method findBlockAssignment under "added methods" in level class
			throw new InvalidInputException("A block already exists at location " + newGridHorizontalPosition + "/" + newGridVerticalPosition + ".");
		}
		BlockAssignment assignment = level.findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition); 
		if (assignment == null) {
			throw new InvalidInputException("A block does not exist at location " + oldGridHorizontalPosition + "/" + oldGridVerticalPosition + ".");
		}
		try {
			assignment.setGridHorizontalPosition(newGridHorizontalPosition); 			
		}
		catch(RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		try {
			assignment.setGridVerticalPosition(newGridVerticalPosition); 
		}
		catch(RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	// feature 10
	public static void removeBlock(int indexLevel, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {		
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to remove a block.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to remove a block.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can remove a block.");
		}	
		Game game = Block223Application.getCurrentGame();
		Level level = game.getLevel(indexLevel - 1);
		BlockAssignment assignment = level.findBlockAssignment(gridHorizontalPosition, gridVerticalPosition); // METHOD ADDED INSIDE THE LEVEL CLASS (UNDER "ADDED METHODS")
		if (assignment != null) {
			assignment.delete();
		}		
	}

	// feature 11
	public static void saveGame() throws InvalidInputException {
		UserRole currentUserRole = Block223Application.getCurrentUserRole();
		
		Game currentGame = Block223Application.getCurrentGame();
		if (currentGame == null) {
			throw new InvalidInputException("A game must be selected to save it.");
		}

		if(!(currentUserRole instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to save a game.");
		}	
		else {
			List<Game> games = ((Admin) currentUserRole).getGames();
			for (Game game: games) {
				if (!(Block223Application.getCurrentUserRole().equals(game.getAdmin()))) {
					throw new InvalidInputException("Only the admin who created the game can save it.");
				}
			}
		}
		Block223 block223 = Block223Application.getBlock223();

		try {
			Block223Persistence.save(block223);}
		catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	// feature 12
	public static void register(String username, String playerPassword, String adminPassword)
			throws InvalidInputException {
		UserRole currentUserRole = Block223Application.getCurrentUserRole();
		Block223 block223 = Block223Application.getBlock223();
		Player player = new Player(playerPassword, block223);
		User user = new User(username, block223, player);
		if (adminPassword != null && adminPassword != "") {
			Admin admin = new Admin(adminPassword, block223);
			user.addRole(admin);
		}
		Block223Persistence.save(block223);

		if (currentUserRole != null) {
			throw new InvalidInputException("Cannot register a new user while a user is logged in.");
		}
		if (playerPassword.equals(adminPassword)) {
			user.delete();
			throw new InvalidInputException("The passwords have to be different.");
		}

		// fail to throw exception of null/empty player password, possible due to the before statement in Block223.ump in UserRole
		// if changed to aPassword.length() == 0, can't register when leaving admin password empty
		try {
			player.setPassword(playerPassword);
		}
		catch(RuntimeException e) {
			user.delete();
			throw new InvalidInputException("The player password needs to be specfied.");
		}

		if (currentUserRole instanceof Admin) {
			List<User> userlist = Block223Application.getBlock223().getUsers();
			for (User currentUser : userlist) {
				if (user.equals(currentUser)) {
					player.delete();
					throw new InvalidInputException("The username has already been taken.");
				}
			}
		}

		// fail to throw exception when username is null/empty with project test package
		// exception throw when running the code (not running the project test)
		try {
			user.setUsername(username);
		}
		catch(RuntimeException e) {
			player.delete();
			throw new InvalidInputException("The username must be specified.");
		}
	}

	// feature 12
	public static void login(String username, String password) throws InvalidInputException {
		Block223 block223 = Block223Application.resetBlock223();
		if (block223 != null) {
			block223.delete();
		}
		Block223Application.setCurrentGame(null);
		block223 = Block223Persistence.load();
		
		User user = User.getWithUsername(username);
		if (user == null) {
			throw new InvalidInputException("The username does not exist.");
		}
		List<UserRole> roles = user.getRoles();

		if (Block223Application.getCurrentUserRole() != null) {
			throw new InvalidInputException("Cannot login a user while a user is already logged in.");
		}	
		if (username == null) {
			throw new InvalidInputException("The username and password do not match.");
			
		}
		
		// currently exception throw  as The username does not exist in test package
		// can get this exception when testing with unmatched username+password
		for (UserRole role : roles) {
			String rolePassword = role.getPassword();
			if (rolePassword.equals(password)) {
				Block223Application.setCurrentUserRole(role);
				return;
			}
		}
		throw new InvalidInputException("The username and password do not match.");	
	}

	// feature 12
	public static void logout() {
		Block223Application.setCurrentUserRole(null);

	}

	// ****************************
	// Query methods
	// ****************************

	// feature 3
	public static List<TOGame> getDesignableGames() throws InvalidInputException {
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			JOptionPane.showMessageDialog(null, "Admin privileges are required to access game information.");
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		else {
			Admin gameAdmin;
			Block223 block223 = Block223Application.getBlock223();
			UserRole admin = Block223Application.getCurrentUserRole();
			List<TOGame> result = new ArrayList<TOGame>();
			List<Game> games = block223.getGames();
			for (Game game : games) {
				gameAdmin = game.getAdmin();
				if (gameAdmin.equals(admin)) {
					TOGame to = new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
							game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(),
							game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
							game.getPaddle().getMinPaddleLength());
					result.add(to);
				}
			}
			return result;
		}
	}

	// feature 4
	public static TOGame getCurrentDesignableGame() throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		if (currentRole instanceof Admin) {
			Game game = Block223Application.getCurrentGame();
			if(game != null) {
				if (game.getAdmin()==currentRole) {
					return new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
							game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(),
							game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
							game.getPaddle().getMinPaddleLength());
				}
				else {
					JOptionPane.showMessageDialog(null, "Only the admin who created the game can access its information.");
					throw new InvalidInputException("Only the admin who created the game can access its information.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "A game must be selected to access its information.");
				throw new InvalidInputException("A game must be selected to access its information.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Admin privileges are required to access game information.");
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
	}

	// feature 6
	public static List<TOBlock> getBlocksOfCurrentDesignableGame() throws InvalidInputException{
		UserRole currentRole = Block223Application.getCurrentUserRole();

		if(!(currentRole instanceof Admin)) {
			String error = "Admin privileges are required to access game information.";
			throw new InvalidInputException(error);
		}
		Game game = Block223Application.getCurrentGame();
		if(game==null) {
			String error = "A game must be selected to access its information.";
			throw new InvalidInputException(error);
		}
		if(!game.getAdmin().equals(currentRole)) {
			String error = "Only the admin who created the game can access its information.";
			throw new InvalidInputException(error);
		}

		ArrayList<TOBlock> result = new ArrayList<TOBlock>();
		List<Block> blocks = game.getBlocks();
		for(Block block : blocks) {
			TOBlock toBlock = new TOBlock(block.getId(), block.getRed(), block.getGreen(), block.getBlue(), block.getPoints());
			result.add(toBlock);
		}

		return result;
	}

	// feature 7
	public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		Game game = Block223Application.getCurrentGame();
		if (game == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}

		Block block = game.findBlock(id);
		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}

		TOBlock to = new TOBlock(block.getId(), block.getRed(), block.getGreen(), block.getBlue(), block.getPoints());
		return to;
	}

	// feature 8
	public static List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int levelIndex) throws InvalidInputException {

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		Game game = Block223Application.getCurrentGame();
		if (game == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (!(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}

		ArrayList<TOGridCell> result = new ArrayList<TOGridCell>();

		Level level;
		try {
			level = game.getLevel(levelIndex - 1);
		}
		catch(IndexOutOfBoundsException e) {
			throw new InvalidInputException(e.getMessage());
		}

		List<BlockAssignment> assignments = level.getBlockAssignments();

		for (BlockAssignment assignment : assignments) {
			TOGridCell to = new TOGridCell(assignment.getGridHorizontalPosition(), assignment.getGridVerticalPosition(), assignment.getBlock().getId(), 
					assignment.getBlock().getRed(), assignment.getBlock().getGreen(), assignment.getBlock().getBlue(),
					assignment.getBlock().getPoints());
			result.add(to);
		}

		return result;
	}

	// feature 12
	public static TOUserMode getUserMode() {
		UserRole userRole = Block223Application.getCurrentUserRole();

		if (userRole == null) {
			TOUserMode to = new TOUserMode(Mode.None);
			return to;
		}

		if (userRole instanceof Player) {
			TOUserMode to = new TOUserMode(Mode.Play);
			return to;
		}

		if (userRole instanceof Admin) {
			TOUserMode to = new TOUserMode(Mode.Design);
			return to;
		}
		return null;

	}
}
