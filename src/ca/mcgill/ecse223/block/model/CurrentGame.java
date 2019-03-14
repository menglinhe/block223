/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 27 "../../../../../Block223Update.ump"
public class CurrentGame
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextPausedGame = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CurrentGame Attributes
  private int lifeRemaining;
  private int currentScore;

  //Autounique Attributes
  private int pausedGame;

  //CurrentGame Associations
  private Game game;
  private Player player;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CurrentGame(int aLifeRemaining, int aCurrentScore, Game aGame, Player aPlayer)
  {
    lifeRemaining = aLifeRemaining;
    currentScore = aCurrentScore;
    pausedGame = nextPausedGame++;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create currentGame due to game");
    }
    boolean didAddPlayer = setPlayer(aPlayer);
    if (!didAddPlayer)
    {
      throw new RuntimeException("Unable to create currentgame due to player");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLifeRemaining(int aLifeRemaining)
  {
    boolean wasSet = false;
    lifeRemaining = aLifeRemaining;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentScore(int aCurrentScore)
  {
    boolean wasSet = false;
    currentScore = aCurrentScore;
    wasSet = true;
    return wasSet;
  }

  public int getLifeRemaining()
  {
    return lifeRemaining;
  }

  public int getCurrentScore()
  {
    return currentScore;
  }

  public int getPausedGame()
  {
    return pausedGame;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    if (aGame == null)
    {
      return wasSet;
    }

    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      existingGame.removeCurrentGame(this);
    }
    game.addCurrentGame(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    if (aPlayer == null)
    {
      return wasSet;
    }

    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removeCurrentgame(this);
    }
    player.addCurrentgame(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removeCurrentGame(this);
    }
    Player placeholderPlayer = player;
    this.player = null;
    if(placeholderPlayer != null)
    {
      placeholderPlayer.removeCurrentgame(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "pausedGame" + ":" + getPausedGame()+ "," +
            "lifeRemaining" + ":" + getLifeRemaining()+ "," +
            "currentScore" + ":" + getCurrentScore()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null");
  }
}