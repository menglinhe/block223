/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 37 "../../../../../Block223Update.ump"
public class HallOfFameEntry
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HallOfFameEntry Attributes
  private String playerName;
  private int highScore;

  //HallOfFameEntry Associations
  private HallOfFame hallOfFame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HallOfFameEntry(String aPlayerName, int aHighScore, HallOfFame aHallOfFame)
  {
    playerName = aPlayerName;
    highScore = aHighScore;
    boolean didAddHallOfFame = setHallOfFame(aHallOfFame);
    if (!didAddHallOfFame)
    {
      throw new RuntimeException("Unable to create entry due to hallOfFame");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlayerName(String aPlayerName)
  {
    boolean wasSet = false;
    playerName = aPlayerName;
    wasSet = true;
    return wasSet;
  }

  public boolean setHighScore(int aHighScore)
  {
    boolean wasSet = false;
    highScore = aHighScore;
    wasSet = true;
    return wasSet;
  }

  public String getPlayerName()
  {
    return playerName;
  }

  public int getHighScore()
  {
    return highScore;
  }
  /* Code from template association_GetOne */
  public HallOfFame getHallOfFame()
  {
    return hallOfFame;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHallOfFame(HallOfFame aHallOfFame)
  {
    boolean wasSet = false;
    if (aHallOfFame == null)
    {
      return wasSet;
    }

    HallOfFame existingHallOfFame = hallOfFame;
    hallOfFame = aHallOfFame;
    if (existingHallOfFame != null && !existingHallOfFame.equals(aHallOfFame))
    {
      existingHallOfFame.removeEntry(this);
    }
    hallOfFame.addEntry(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    HallOfFame placeholderHallOfFame = hallOfFame;
    this.hallOfFame = null;
    if(placeholderHallOfFame != null)
    {
      placeholderHallOfFame.removeEntry(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "playerName" + ":" + getPlayerName()+ "," +
            "highScore" + ":" + getHighScore()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hallOfFame = "+(getHallOfFame()!=null?Integer.toHexString(System.identityHashCode(getHallOfFame())):"null");
  }
}