/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.io.Serializable;
import java.util.*;

/**
 * classes need to be implemented in SM: Ball, Paddle, Game, Block
 * not sure if we need to put Block223 in the SM
 */
// line 85 "../../../../../Block223Persistence.ump"
// line 17 "../../../../../Block223Update.ump"
// line 6 "../../../../../Block223StateMachine.ump"
// line 186 "../../../../../Block223.ump"
public class Ball implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int BALL_DIAMETER = 10;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ball Attributes
  private int xSpeed;
  private int ySpeed;
  private int xPosition;
  private int yPosition;
  private int minBallSpeedX;
  private int minBallSpeedY;
  private double ballSpeedIncreaseFactor;

  //Ball State Machines
  public enum BallState { HitPaddle, HitWall, HitNothing, HitBlock, OutOfBound }
  private BallState ballState;

  //Ball Associations
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ball(int aXSpeed, int aYSpeed, int aXPosition, int aYPosition, int aMinBallSpeedX, int aMinBallSpeedY, double aBallSpeedIncreaseFactor, Game aGame)
  {
    // line 190 "../../../../../Block223.ump"
    if(aMinBallSpeedX < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    // line 196 "../../../../../Block223.ump"
    if(aMinBallSpeedY < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    // line 202 "../../../../../Block223.ump"
    if(aBallSpeedIncreaseFactor <= 0){
       		throw new RuntimeException("The speed increase factor of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    xSpeed = aXSpeed;
    ySpeed = aYSpeed;
    xPosition = aXPosition;
    yPosition = aYPosition;
    minBallSpeedX = aMinBallSpeedX;
    minBallSpeedY = aMinBallSpeedY;
    ballSpeedIncreaseFactor = aBallSpeedIncreaseFactor;
    if (aGame == null || aGame.getBall() != null)
    {
      throw new RuntimeException("Unable to create Ball due to aGame");
    }
    game = aGame;
    setBallState(BallState.HitPaddle);
  }

  public Ball(int aXSpeed, int aYSpeed, int aXPosition, int aYPosition, int aMinBallSpeedX, int aMinBallSpeedY, double aBallSpeedIncreaseFactor, boolean aPublishedForGame, String aNameForGame, int aNrBlocksPerLevelForGame, HallOfFame aHallOfFameForGame, Admin aAdminForGame, Paddle aPaddleForGame, Block223 aBlock223ForGame)
  {
    // line 190 "../../../../../Block223.ump"
    if(aMinBallSpeedX < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    // line 196 "../../../../../Block223.ump"
    if(aMinBallSpeedY < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    // line 202 "../../../../../Block223.ump"
    if(aBallSpeedIncreaseFactor <= 0){
       		throw new RuntimeException("The speed increase factor of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    xSpeed = aXSpeed;
    ySpeed = aYSpeed;
    xPosition = aXPosition;
    yPosition = aYPosition;
    minBallSpeedX = aMinBallSpeedX;
    minBallSpeedY = aMinBallSpeedY;
    ballSpeedIncreaseFactor = aBallSpeedIncreaseFactor;
    game = new Game(aPublishedForGame, aNameForGame, aNrBlocksPerLevelForGame, aHallOfFameForGame, aAdminForGame, this, aPaddleForGame, aBlock223ForGame);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setXSpeed(int aXSpeed)
  {
    boolean wasSet = false;
    xSpeed = aXSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setYSpeed(int aYSpeed)
  {
    boolean wasSet = false;
    ySpeed = aYSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setXPosition(int aXPosition)
  {
    boolean wasSet = false;
    xPosition = aXPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setYPosition(int aYPosition)
  {
    boolean wasSet = false;
    yPosition = aYPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinBallSpeedX(int aMinBallSpeedX)
  {
    boolean wasSet = false;
    // line 190 "../../../../../Block223.ump"
    if(aMinBallSpeedX < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    minBallSpeedX = aMinBallSpeedX;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinBallSpeedY(int aMinBallSpeedY)
  {
    boolean wasSet = false;
    // line 196 "../../../../../Block223.ump"
    if(aMinBallSpeedY < 0){
       		throw new RuntimeException("The minimum speed of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    minBallSpeedY = aMinBallSpeedY;
    wasSet = true;
    return wasSet;
  }

  public boolean setBallSpeedIncreaseFactor(double aBallSpeedIncreaseFactor)
  {
    boolean wasSet = false;
    // line 202 "../../../../../Block223.ump"
    if(aBallSpeedIncreaseFactor <= 0){
       		throw new RuntimeException("The speed increase factor of the ball must be greater than zero.");
       	}
    // END OF UMPLE BEFORE INJECTION
    ballSpeedIncreaseFactor = aBallSpeedIncreaseFactor;
    wasSet = true;
    return wasSet;
  }

  public int getXSpeed()
  {
    return xSpeed;
  }

  public int getYSpeed()
  {
    return ySpeed;
  }

  public int getXPosition()
  {
    return xPosition;
  }

  public int getYPosition()
  {
    return yPosition;
  }

  public int getMinBallSpeedX()
  {
    return minBallSpeedX;
  }

  public int getMinBallSpeedY()
  {
    return minBallSpeedY;
  }

  public double getBallSpeedIncreaseFactor()
  {
    return ballSpeedIncreaseFactor;
  }

  public String getBallStateFullName()
  {
    String answer = ballState.toString();
    return answer;
  }

  public BallState getBallState()
  {
    return ballState;
  }

  public boolean hitBlock()
  {
    boolean wasEventProcessed = false;
    
    BallState aBallState = ballState;
    switch (aBallState)
    {
      case HitPaddle:
        exitBallState();
        setBallState(BallState.HitBlock);
        wasEventProcessed = true;
        break;
      case HitWall:
        exitBallState();
        setBallState(BallState.HitBlock);
        wasEventProcessed = true;
        break;
      case HitNothing:
        exitBallState();
        setBallState(BallState.HitBlock);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean hitWall()
  {
    boolean wasEventProcessed = false;
    
    BallState aBallState = ballState;
    switch (aBallState)
    {
      case HitPaddle:
        exitBallState();
        setBallState(BallState.HitWall);
        wasEventProcessed = true;
        break;
      case HitNothing:
        exitBallState();
        setBallState(BallState.HitWall);
        wasEventProcessed = true;
        break;
      case HitBlock:
        exitBallState();
        setBallState(BallState.HitWall);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean goesOutOfBounds()
  {
    boolean wasEventProcessed = false;
    
    BallState aBallState = ballState;
    switch (aBallState)
    {
      case HitPaddle:
        exitBallState();
        setBallState(BallState.OutOfBound);
        wasEventProcessed = true;
        break;
      case HitWall:
        exitBallState();
        setBallState(BallState.OutOfBound);
        wasEventProcessed = true;
        break;
      case HitNothing:
        exitBallState();
        setBallState(BallState.OutOfBound);
        wasEventProcessed = true;
        break;
      case HitBlock:
        exitBallState();
        setBallState(BallState.OutOfBound);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean hitNothing()
  {
    boolean wasEventProcessed = false;
    
    BallState aBallState = ballState;
    switch (aBallState)
    {
      case HitPaddle:
        exitBallState();
        setBallState(BallState.HitNothing);
        wasEventProcessed = true;
        break;
      case HitWall:
        exitBallState();
        setBallState(BallState.HitNothing);
        wasEventProcessed = true;
        break;
      case HitNothing:
        exitBallState();
        setBallState(BallState.HitNothing);
        wasEventProcessed = true;
        break;
      case HitBlock:
        exitBallState();
        setBallState(BallState.HitNothing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean hitPaddle()
  {
    boolean wasEventProcessed = false;
    
    BallState aBallState = ballState;
    switch (aBallState)
    {
      case HitWall:
        exitBallState();
        setBallState(BallState.HitPaddle);
        wasEventProcessed = true;
        break;
      case HitNothing:
        exitBallState();
        setBallState(BallState.HitPaddle);
        wasEventProcessed = true;
        break;
      case HitBlock:
        exitBallState();
        setBallState(BallState.HitPaddle);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitBallState()
  {
    switch(ballState)
    {
      case HitPaddle:
        // line 14 "../../../../../Block223StateMachine.ump"
        moveBall();
        break;
      case HitWall:
        // line 23 "../../../../../Block223StateMachine.ump"
        moveBall();
        break;
      case HitNothing:
        // line 31 "../../../../../Block223StateMachine.ump"
        moveBall();
        break;
      case HitBlock:
        // line 39 "../../../../../Block223StateMachine.ump"
        moveBall();
        break;
    }
  }

  private void setBallState(BallState aBallState)
  {
    ballState = aBallState;

    // entry actions and do activities
    switch(ballState)
    {
      case HitPaddle:
        // line 9 "../../../../../Block223StateMachine.ump"
        bounce();
        break;
      case HitWall:
        // line 18 "../../../../../Block223StateMachine.ump"
        bounce();
        break;
      case HitBlock:
        // line 34 "../../../../../Block223StateMachine.ump"
        bounce();
        break;
    }
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }

  public void delete()
  {
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "xSpeed" + ":" + getXSpeed()+ "," +
            "ySpeed" + ":" + getYSpeed()+ "," +
            "xPosition" + ":" + getXPosition()+ "," +
            "yPosition" + ":" + getYPosition()+ "," +
            "minBallSpeedX" + ":" + getMinBallSpeedX()+ "," +
            "minBallSpeedY" + ":" + getMinBallSpeedY()+ "," +
            "ballSpeedIncreaseFactor" + ":" + getBallSpeedIncreaseFactor()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 88 "../../../../../Block223Persistence.ump"
  private static final long serialVersionUID = 10L ;

  
}