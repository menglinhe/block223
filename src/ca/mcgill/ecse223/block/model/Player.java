/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.io.Serializable;
import java.util.*;

// line 40 "../../../../../Block223Persistence.ump"
// line 23 "../../../../../Block223Update.ump"
// line 52 "../../../../../Block223.ump"
public class Player extends UserRole implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Associations
  private List<CurrentGame> currentgames;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aPassword, Block223 aBlock223)
  {
    super(aPassword, aBlock223);
    currentgames = new ArrayList<CurrentGame>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public CurrentGame getCurrentgame(int index)
  {
    CurrentGame aCurrentgame = currentgames.get(index);
    return aCurrentgame;
  }

  public List<CurrentGame> getCurrentgames()
  {
    List<CurrentGame> newCurrentgames = Collections.unmodifiableList(currentgames);
    return newCurrentgames;
  }

  public int numberOfCurrentgames()
  {
    int number = currentgames.size();
    return number;
  }

  public boolean hasCurrentgames()
  {
    boolean has = currentgames.size() > 0;
    return has;
  }

  public int indexOfCurrentgame(CurrentGame aCurrentgame)
  {
    int index = currentgames.indexOf(aCurrentgame);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCurrentgames()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public CurrentGame addCurrentgame(int aLifeRemaining, int aCurrentScore, Game aGame)
  {
    return new CurrentGame(aLifeRemaining, aCurrentScore, aGame, this);
  }

  public boolean addCurrentgame(CurrentGame aCurrentgame)
  {
    boolean wasAdded = false;
    if (currentgames.contains(aCurrentgame)) { return false; }
    Player existingPlayer = aCurrentgame.getPlayer();
    boolean isNewPlayer = existingPlayer != null && !this.equals(existingPlayer);
    if (isNewPlayer)
    {
      aCurrentgame.setPlayer(this);
    }
    else
    {
      currentgames.add(aCurrentgame);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCurrentgame(CurrentGame aCurrentgame)
  {
    boolean wasRemoved = false;
    //Unable to remove aCurrentgame, as it must always have a player
    if (!this.equals(aCurrentgame.getPlayer()))
    {
      currentgames.remove(aCurrentgame);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCurrentgameAt(CurrentGame aCurrentgame, int index)
  {  
    boolean wasAdded = false;
    if(addCurrentgame(aCurrentgame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentgames()) { index = numberOfCurrentgames() - 1; }
      currentgames.remove(aCurrentgame);
      currentgames.add(index, aCurrentgame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCurrentgameAt(CurrentGame aCurrentgame, int index)
  {
    boolean wasAdded = false;
    if(currentgames.contains(aCurrentgame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCurrentgames()) { index = numberOfCurrentgames() - 1; }
      currentgames.remove(aCurrentgame);
      currentgames.add(index, aCurrentgame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCurrentgameAt(aCurrentgame, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (currentgames.size() > 0)
    {
      CurrentGame aCurrentgame = currentgames.get(currentgames.size() - 1);
      aCurrentgame.delete();
      currentgames.remove(aCurrentgame);
    }
    
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 43 "../../../../../Block223Persistence.ump"
  private static final long serialVersionUID = 5L ;

  
}