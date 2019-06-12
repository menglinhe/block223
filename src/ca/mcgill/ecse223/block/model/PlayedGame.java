/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import ca.mcgill.ecse223.block.model.BouncePoint.BounceDirection;
import java.io.Serializable;
import java.util.*;

// line 29 "../../../../../Block223PlayMode.ump"
// line 106 "../../../../../Block223Persistence.ump"
// line 12 "../../../../../Block223States.ump"
public class PlayedGame implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------


  /**
   * at design time, the initial wait time may be adjusted as seen fit
   */
  public static final int INITIAL_WAIT_TIME = 1000;
  private static int nextId = 1;
  public static final int NR_LIVES = 3;

  /**
   * the PlayedBall and PlayedPaddle are not in a separate class to avoid the bug in Umple that occurred for the second constructor of Game
   * no direct link to Ball, because the ball can be found by navigating to PlayedGame, Game, and then Ball
   */
  public static final int BALL_INITIAL_X = Game.PLAY_AREA_SIDE / 2;
  public static final int BALL_INITIAL_Y = Game.PLAY_AREA_SIDE / 2;

  /**
   * no direct link to Paddle, because the paddle can be found by navigating to PlayedGame, Game, and then Paddle
   * pixels moved when right arrow key is pressed
   */
  public static final int PADDLE_MOVE_RIGHT = 1;

  /**
   * pixels moved when left arrow key is pressed
   */
  public static final int PADDLE_MOVE_LEFT = -1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayedGame Attributes
  private int score;
  private int lives;
  private int currentLevel;
  private double waitTime;
  private String playername;
  private double ballDirectionX;
  private double ballDirectionY;
  private double currentBallX;
  private double currentBallY;
  private double currentPaddleLength;
  private double currentPaddleX;
  private double currentPaddleY;

  //Autounique Attributes
  private int id;

  //PlayedGame State Machines
  public enum PlayStatus { Ready, Moving, Paused, GameOver }
  private PlayStatus playStatus;

  //PlayedGame Associations
  private Player player;
  private Game game;
  private List<PlayedBlockAssignment> blocks;
  private BouncePoint bounce;
  private Block223 block223;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayedGame(String aPlayername, Game aGame, Block223 aBlock223)
  {
    // line 71 "../../../../../Block223PlayMode.ump"
    boolean didAddGameResult = setGame(aGame);
       if (!didAddGameResult)
       {
          throw new RuntimeException("Unable to create playedGame due to game");
       }
    // END OF UMPLE BEFORE INJECTION
    score = 0;
    lives = NR_LIVES;
    currentLevel = 1;
    waitTime = INITIAL_WAIT_TIME;
    playername = aPlayername;
    resetBallDirectionX();
    resetBallDirectionY();
    resetCurrentBallX();
    resetCurrentBallY();
    currentPaddleLength = getGame().getPaddle().getMaxPaddleLength();
    resetCurrentPaddleX();
    currentPaddleY = Game.PLAY_AREA_SIDE - Paddle.VERTICAL_DISTANCE - Paddle.PADDLE_WIDTH;
    id = nextId++;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create playedGame due to game");
    }
    blocks = new ArrayList<PlayedBlockAssignment>();
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create playedGame due to block223");
    }
    setPlayStatus(PlayStatus.Ready);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public boolean setLives(int aLives)
  {
    boolean wasSet = false;
    lives = aLives;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentLevel(int aCurrentLevel)
  {
    boolean wasSet = false;
    currentLevel = aCurrentLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean setWaitTime(double aWaitTime)
  {
    boolean wasSet = false;
    waitTime = aWaitTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayername(String aPlayername)
  {
    boolean wasSet = false;
    playername = aPlayername;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallDirectionX(double aBallDirectionX)
  {
    boolean wasSet = false;
    ballDirectionX = aBallDirectionX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallDirectionX()
  {
    boolean wasReset = false;
    ballDirectionX = getDefaultBallDirectionX();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallDirectionY(double aBallDirectionY)
  {
    boolean wasSet = false;
    ballDirectionY = aBallDirectionY;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallDirectionY()
  {
    boolean wasReset = false;
    ballDirectionY = getDefaultBallDirectionY();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentBallX(double aCurrentBallX)
  {
    boolean wasSet = false;
    currentBallX = aCurrentBallX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentBallX()
  {
    boolean wasReset = false;
    currentBallX = getDefaultCurrentBallX();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentBallY(double aCurrentBallY)
  {
    boolean wasSet = false;
    currentBallY = aCurrentBallY;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentBallY()
  {
    boolean wasReset = false;
    currentBallY = getDefaultCurrentBallY();
    wasReset = true;
    return wasReset;
  }

  public boolean setCurrentPaddleLength(double aCurrentPaddleLength)
  {
    boolean wasSet = false;
    currentPaddleLength = aCurrentPaddleLength;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentPaddleX(double aCurrentPaddleX)
  {
    boolean wasSet = false;
    currentPaddleX = aCurrentPaddleX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentPaddleX()
  {
    boolean wasReset = false;
    currentPaddleX = getDefaultCurrentPaddleX();
    wasReset = true;
    return wasReset;
  }

  public int getScore()
  {
    return score;
  }

  public int getLives()
  {
    return lives;
  }

  public int getCurrentLevel()
  {
    return currentLevel;
  }

  public double getWaitTime()
  {
    return waitTime;
  }

  /**
   * added here so that it only needs to be determined once
   */
  public String getPlayername()
  {
    return playername;
  }

  /**
   * 0/0 is the top left corner of the play area, i.e., a directionX/Y of 0/1 moves the ball down in a straight line
   */
  public double getBallDirectionX()
  {
    return ballDirectionX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultBallDirectionX()
  {
    return getGame().getBall().getMinBallSpeedX();
  }

  public double getBallDirectionY()
  {
    return ballDirectionY;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultBallDirectionY()
  {
    return getGame().getBall().getMinBallSpeedY();
  }

  /**
   * the position of the ball is at the center of the ball
   */
  public double getCurrentBallX()
  {
    return currentBallX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentBallX()
  {
    return BALL_INITIAL_X;
  }

  public double getCurrentBallY()
  {
    return currentBallY;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentBallY()
  {
    return BALL_INITIAL_Y;
  }

  public double getCurrentPaddleLength()
  {
    return currentPaddleLength;
  }

  /**
   * the position of the paddle is at its top right corner
   */
  public double getCurrentPaddleX()
  {
    return currentPaddleX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentPaddleX()
  {
    return (Game.PLAY_AREA_SIDE - currentPaddleLength) / 2;
  }

  public double getCurrentPaddleY()
  {
    return currentPaddleY;
  }

  public int getId()
  {
    return id;
  }

  public String getPlayStatusFullName()
  {
    String answer = playStatus.toString();
    return answer;
  }

  public PlayStatus getPlayStatus()
  {
    return playStatus;
  }

  public boolean play()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Ready:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      case Paused:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pause()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        setPlayStatus(PlayStatus.Paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean move()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        if (hitPaddle())
        {
        // line 23 "../../../../../Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBoundsAndLastLife())
        {
        // line 24 "../../../../../Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBounds())
        {
        // line 25 "../../../../../Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.Paused);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlockAndLastLevel())
        {
        // line 26 "../../../../../Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlock())
        {
        // line 27 "../../../../../Block223States.ump"
          doHitBlockNextLevel();
          setPlayStatus(PlayStatus.Ready);
          wasEventProcessed = true;
          break;
        }
        if (hitBlock())
        {
        // line 28 "../../../../../Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (hitWall())
        {
        // line 29 "../../../../../Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        // line 30 "../../../../../Block223States.ump"
        doHitNothingAndNotOutOfBounds();
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setPlayStatus(PlayStatus aPlayStatus)
  {
    playStatus = aPlayStatus;

    // entry actions and do activities
    switch(playStatus)
    {
      case Ready:
        // line 18 "../../../../../Block223States.ump"
        doSetup();
        break;
      case GameOver:
        // line 36 "../../../../../Block223States.ump"
        doGameOver();
        break;
    }
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }

  public boolean hasPlayer()
  {
    boolean has = player != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetMany */
  public PlayedBlockAssignment getBlock(int index)
  {
    PlayedBlockAssignment aBlock = blocks.get(index);
    return aBlock;
  }

  public List<PlayedBlockAssignment> getBlocks()
  {
    List<PlayedBlockAssignment> newBlocks = Collections.unmodifiableList(blocks);
    return newBlocks;
  }

  public int numberOfBlocks()
  {
    int number = blocks.size();
    return number;
  }

  public boolean hasBlocks()
  {
    boolean has = blocks.size() > 0;
    return has;
  }

  public int indexOfBlock(PlayedBlockAssignment aBlock)
  {
    int index = blocks.indexOf(aBlock);
    return index;
  }
  /* Code from template association_GetOne */
  public BouncePoint getBounce()
  {
    return bounce;
  }

  public boolean hasBounce()
  {
    boolean has = bounce != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Block223 getBlock223()
  {
    return block223;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removePlayedGame(this);
    }
    if (aPlayer != null)
    {
      aPlayer.addPlayedGame(this);
    }
    wasSet = true;
    return wasSet;
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
      existingGame.removePlayedGame(this);
    }
    game.addPlayedGame(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBlocks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PlayedBlockAssignment addBlock(int aX, int aY, Block aBlock)
  {
    return new PlayedBlockAssignment(aX, aY, aBlock, this);
  }

  public boolean addBlock(PlayedBlockAssignment aBlock)
  {
    boolean wasAdded = false;
    if (blocks.contains(aBlock)) { return false; }
    PlayedGame existingPlayedGame = aBlock.getPlayedGame();
    boolean isNewPlayedGame = existingPlayedGame != null && !this.equals(existingPlayedGame);
    if (isNewPlayedGame)
    {
      aBlock.setPlayedGame(this);
    }
    else
    {
      blocks.add(aBlock);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBlock(PlayedBlockAssignment aBlock)
  {
    boolean wasRemoved = false;
    //Unable to remove aBlock, as it must always have a playedGame
    if (!this.equals(aBlock.getPlayedGame()))
    {
      blocks.remove(aBlock);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBlockAt(PlayedBlockAssignment aBlock, int index)
  {  
    boolean wasAdded = false;
    if(addBlock(aBlock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlocks()) { index = numberOfBlocks() - 1; }
      blocks.remove(aBlock);
      blocks.add(index, aBlock);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBlockAt(PlayedBlockAssignment aBlock, int index)
  {
    boolean wasAdded = false;
    if(blocks.contains(aBlock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlocks()) { index = numberOfBlocks() - 1; }
      blocks.remove(aBlock);
      blocks.add(index, aBlock);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBlockAt(aBlock, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setBounce(BouncePoint aNewBounce)
  {
    boolean wasSet = false;
    bounce = aNewBounce;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBlock223(Block223 aBlock223)
  {
    boolean wasSet = false;
    if (aBlock223 == null)
    {
      return wasSet;
    }

    Block223 existingBlock223 = block223;
    block223 = aBlock223;
    if (existingBlock223 != null && !existingBlock223.equals(aBlock223))
    {
      existingBlock223.removePlayedGame(this);
    }
    block223.addPlayedGame(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (player != null)
    {
      Player placeholderPlayer = player;
      this.player = null;
      placeholderPlayer.removePlayedGame(this);
    }
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removePlayedGame(this);
    }
    while (blocks.size() > 0)
    {
      PlayedBlockAssignment aBlock = blocks.get(blocks.size() - 1);
      aBlock.delete();
      blocks.remove(aBlock);
    }
    
    bounce = null;
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removePlayedGame(this);
    }
  }


  /**
   * Guards
   */
  // line 43 "../../../../../Block223States.ump"
   private Point2D calculateIntersectPoint(Line2D line1, Line2D line2){
    if (line1.getX2() == line1.getX1()) {
    		return (new Point2D.Double(line1.getX1(), line2.getY1()));
    	}
	   double m1 = ((line1.getY2() - line1.getY1()) / (line1.getX2() - line1.getX1()));
		  double m2 = ((line2.getY2() - line2.getY1()) / (line2.getX2() - line2.getX1()));
		  double b1 = (line1.getY1() - m1 * line1.getX1());
		  double b2 = (line2.getY1() - m2 * line2.getX1());
		  
		  double x = (b2 - b1) / (m1 - m2);
		  double y = m1 * x + b1;
		  
		  return (new Point2D.Double(x, y));
  }

  // line 58 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointPaddle(){
    int BallX = (int) getCurrentBallX();
	   int BallY = (int) getCurrentBallY();
		int nextBallX = (int) (BallX + getBallDirectionX());
		int nextBallY = (int) (BallY + getBallDirectionY());
		Line2D ballTrajectory = new Line2D.Double(BallX, BallY, nextBallX, nextBallY);
		
		int ballRadius = Ball.BALL_DIAMETER / 2;
		
		Rectangle2D boxA = new Rectangle2D.Double(getCurrentPaddleX(), (getCurrentPaddleY() - ballRadius), getCurrentPaddleLength(), ballRadius);
		Rectangle2D boxB = new Rectangle2D.Double((getCurrentPaddleX() - ballRadius), getCurrentPaddleY(), ballRadius, Paddle.PADDLE_WIDTH);
		Rectangle2D boxC = new Rectangle2D.Double((getCurrentPaddleX() + getCurrentPaddleLength()), getCurrentPaddleY(), ballRadius, Paddle.PADDLE_WIDTH);
		Rectangle2D boxE = new Rectangle2D.Double((getCurrentPaddleX() - ballRadius), (getCurrentPaddleY() - ballRadius), ballRadius, ballRadius);
		Rectangle2D boxF = new Rectangle2D.Double((getCurrentPaddleX() + getCurrentPaddleLength()), (getCurrentPaddleY() - ballRadius), ballRadius, ballRadius);
	   
		BouncePoint bp = null;
		
		if (boxA.intersectsLine(ballTrajectory)) {
			if (nextBallY >= 350) {
				Line2D lineA = new Line2D.Double((getCurrentPaddleX() - getCurrentPaddleLength()), (getCurrentPaddleY() - ballRadius), getCurrentPaddleX(), (getCurrentPaddleY() - ballRadius));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineA);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_Y);
			}
		}
		else if (boxB.intersectsLine(ballTrajectory)) {
			Line2D lineB = new Line2D.Double((getCurrentPaddleX() - ballRadius), getCurrentPaddleY(), (getCurrentPaddleX() - ballRadius), (getCurrentPaddleY() + Paddle.PADDLE_WIDTH));
			Point2D intersection = calculateIntersectPoint(ballTrajectory, lineB);
			bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
		}
		else if (boxC.intersectsLine(ballTrajectory)) {
			Line2D lineC = new Line2D.Double((getCurrentPaddleX() + getCurrentPaddleLength() + ballRadius), getCurrentPaddleY(), (getCurrentPaddleX() + getCurrentPaddleLength() + ballRadius), (getCurrentPaddleY() + Paddle.PADDLE_WIDTH));
			Point2D intersection = calculateIntersectPoint(ballTrajectory, lineC);
			bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
		}
		else if (boxE.intersectsLine(ballTrajectory)) {
			Arc2D arcE = new Arc2D.Double((getCurrentPaddleX() - ballRadius), (getCurrentPaddleY() - ballRadius), (getCurrentPaddleX() + ballRadius), (getCurrentPaddleY() + ballRadius), 90, 90, Arc2D.OPEN);
			
			double xa = arcE.getX();
			double r = ballRadius;
			
			double x1 = BallX;
			double y1 = BallY;
			double x2 = nextBallX;
			double y2 = nextBallY;
			double dx = x2 - x1;
			double dy = y2 - y1;
			double al = Math.atan(dy/dx);
			
			double c = (xa + r * Math.cos(al) - x1) / dx;
			double intX = x1 + c * dx;
			double intY = y1 + c * dy;
			
			if (getBallDirectionX() < 0) {
				bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
			}
			else {
				bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
			}
		}
		else if (boxF.intersectsLine(ballTrajectory)) {
			Arc2D arcF = new Arc2D.Double((getCurrentPaddleX() + getCurrentPaddleLength() - ballRadius), (getCurrentPaddleY() - ballRadius), (getCurrentPaddleX() + getCurrentPaddleLength() + ballRadius), (getCurrentPaddleY() + ballRadius), 0, 90, Arc2D.OPEN);
			
			double xa = arcF.getX();
			double r = ballRadius;
			
			double x1 = BallX;
			double y1 = BallY;
			double x2 = nextBallX;
			double y2 = nextBallY;
			double dx = x2 - x1;
			double dy = y2 - y1;
			double al = Math.atan(dy/dx);
			
			double c = (xa + r * Math.cos(al) - x1) / dx;
			double intX = x1 + c * dx;
			double intY = y1 + c * dy;
			
			if (getBallDirectionX() < 0) {
				bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
			}
			else {
				bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
			}
		}
	return bp;
  }

  // line 145 "../../../../../Block223States.ump"
   private boolean hitPaddle(){
    BouncePoint bp = calculateBouncePointPaddle();
	   setBounce(bp);
    return (bp != null);
  }

  // line 151 "../../../../../Block223States.ump"
   private boolean isOutOfBoundsAndLastLife(){
    boolean outOfBounds = false;
	if (lives == 1) {
		outOfBounds = isBallOutOfBounds();
	}
    return outOfBounds;
  }

  // line 159 "../../../../../Block223States.ump"
   private boolean isOutOfBounds(){
    boolean outOfBounds = false;
    outOfBounds = isBallOutOfBounds();
    return outOfBounds;
  }

  // line 165 "../../../../../Block223States.ump"
   private boolean isBallOutOfBounds(){
    boolean outOfBounds = false;
	int y = Game.PLAY_AREA_SIDE - (Ball.BALL_DIAMETER / 2);
	int BallX = (int) getCurrentBallX();
	int BallY = (int) getCurrentBallY();
	int nextBallX = (int) (BallX + getBallDirectionX());
	int nextBallY = (int) (BallY + getBallDirectionY());
	Line2D ballTrajectory = new Line2D.Double(BallX, BallY, nextBallX, nextBallY);
	Line2D criticalBorder = new Line2D.Double(0, y, Game.PLAY_AREA_SIDE, y);
	if (ballTrajectory.intersectsLine(criticalBorder)) {
		outOfBounds = true;
  }
 	return outOfBounds;
  }

  // line 181 "../../../../../Block223States.ump"
   private boolean hitLastBlockAndLastLevel(){
    Game game = getGame();
  	int nrLevels = game.numberOfLevels();
  	setBounce(null);
  	if(nrLevels==currentLevel){
  		int nrBlocks = numberOfBlocks();
  		if(nrBlocks==1){
  			PlayedBlockAssignment block = getBlock(0);
  			BouncePoint bp = calculateBouncePointBlock(block);
  			if(bp!=null){
  				setBounce(bp);
  			}
  			return bp!=null;
  		}
  	}
  	return false;
  }

  // line 199 "../../../../../Block223States.ump"
   private boolean hitLastBlock(){
    int nrBlocks = numberOfBlocks();
  	setBounce(null);
  	if(nrBlocks==1){
  		PlayedBlockAssignment block = getBlock(0);
  		BouncePoint bp = calculateBouncePointBlock(block);
  		setBounce(bp);
  		return bp!=null;
  	}
    return false;
  }

  // line 211 "../../../../../Block223States.ump"
   private boolean hitBlock(){
    int nrBlocks = numberOfBlocks();
  	setBounce(null);
  	for(int i=0; i<nrBlocks-1; i++){
  		PlayedBlockAssignment block = getBlock(i);
  		BouncePoint bp = calculateBouncePointBlock(block);
  		boolean closer = isCloser(bp, bounce);
  		if(closer){
  			bp.setHitBlock(block);
  			setBounce(bp);
  		}
  	}
    return (getBounce()!=null);
  }

  // line 226 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointBlock(PlayedBlockAssignment block){
    int BallX = (int) getCurrentBallX();
		   int BallY = (int) getCurrentBallY();
			int nextBallX = (int) (BallX + getBallDirectionX());
			int nextBallY = (int) (BallY + getBallDirectionX());
			Line2D ballTrajectory = new Line2D.Double(BallX, BallY, nextBallX, nextBallY);

			int ballRadius = Ball.BALL_DIAMETER / 2;

			Rectangle2D boxA = new Rectangle2D.Double(block.getX(), (block.getY() - ballRadius), Block.SIZE, ballRadius);
			Rectangle2D boxB = new Rectangle2D.Double((block.getX() - ballRadius), block.getY(), ballRadius, Block.SIZE);
			Rectangle2D boxC = new Rectangle2D.Double((block.getX() + Block.SIZE), block.getY(), ballRadius, Block.SIZE);
			Rectangle2D boxD = new Rectangle2D.Double(block.getX(), (block.getY() + Block.SIZE), Block.SIZE, ballRadius);

			Rectangle2D boxE = new Rectangle2D.Double((block.getX() - ballRadius), (block.getY() - ballRadius), ballRadius, ballRadius);
			Rectangle2D boxF = new Rectangle2D.Double((block.getX() + Block.SIZE), (block.getY() - ballRadius), ballRadius, ballRadius);
			Rectangle2D boxG = new Rectangle2D.Double((block.getX() - ballRadius), (block.getY() + Block.SIZE), ballRadius, ballRadius);
			Rectangle2D boxH = new Rectangle2D.Double((block.getX() + Block.SIZE), (block.getY() + Block.SIZE), ballRadius, ballRadius);

			BouncePoint bp = null;

			if (boxA.intersectsLine(ballTrajectory)) {
				Line2D lineA = new Line2D.Double(block.getX(), (block.getY() - ballRadius), (block.getX() + Block.SIZE), (block.getY() - ballRadius));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineA);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_Y);
			}
			else if (boxB.intersectsLine(ballTrajectory)) {
				Line2D lineB = new Line2D.Double((block.getX() - ballRadius), block.getY(), (block.getX() - ballRadius), (block.getY() + Block.SIZE));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineB);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
			}
			else if (boxC.intersectsLine(ballTrajectory)) {
				Line2D lineC = new Line2D.Double((block.getX() + Block.SIZE + ballRadius), block.getY(), (block.getX() + Block.SIZE + ballRadius), (block.getY() + Block.SIZE));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineC);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
			}
			else if (boxD.intersectsLine(ballTrajectory)) {
				Line2D lineD = new Line2D.Double(block.getX(), (block.getY() + Block.SIZE + ballRadius), (block.getX() + Block.SIZE), (block.getY() + Block.SIZE + ballRadius));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineD);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_Y);
			}
			else if (boxE.intersectsLine(ballTrajectory)) {
				Arc2D arcE = new Arc2D.Double((block.getX() - ballRadius), (block.getY() - ballRadius), (block.getX() + ballRadius), (block.getY() + ballRadius), 90, 90, Arc2D.OPEN);

				double xa = arcE.getX();
				double r = ballRadius;

				double x1 = BallX;
				double y1 = BallY;
				double x2 = nextBallX;
				double y2 = nextBallY;
				double dx = x2 - x1;
				double dy = y2 - y1;
				double al = Math.atan(dy/dx);

				double c = (xa + r * Math.cos(al) - x1) / dx;
				double intX = x1 + c * dx;
				double intY = y1 + c * dy;

				if (getBallDirectionX() < 0) {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
				}
				else {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
				}
			}
			else if (boxF.intersectsLine(ballTrajectory)) {
				Arc2D arcF = new Arc2D.Double((block.getX() + Block.SIZE - ballRadius), (block.getY() - ballRadius), (block.getX() + Block.SIZE + ballRadius), (block.getY() + ballRadius), 0, 90, Arc2D.OPEN);

				double xa = arcF.getX();
				double r = ballRadius;

				double x1 = BallX;
				double y1 = BallY;
				double x2 = nextBallX;
				double y2 = nextBallY;
				double dx = x2 - x1;
				double dy = y2 - y1;
				double al = Math.atan(dy/dx);

				double c = (xa + r * Math.cos(al) - x1) / dx;
				double intX = x1 + c * dx;
				double intY = y1 + c * dy;

				if (getBallDirectionX() < 0) {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
				}
				else {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
				}
			}
			else if (boxG.intersectsLine(ballTrajectory)) {
				Arc2D arcG = new Arc2D.Double((block.getX() - ballRadius), (block.getY() + Block.SIZE - ballRadius), (block.getX() + ballRadius), (block.getY() + Block.SIZE + ballRadius), 180, 90, Arc2D.OPEN);

				double xa = arcG.getX();
				double r = ballRadius;

				double x1 = BallX;
				double y1 = BallY;
				double x2 = nextBallX;
				double y2 = nextBallY;
				double dx = x2 - x1;
				double dy = y2 - y1;
				double al = Math.atan(dy/dx);

				double c = (xa + r * Math.cos(al) - x1) / dx;
				double intX = x1 + c * dx;
				double intY = y1 + c * dy;

				if (getBallDirectionX() < 0) {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
				}
				else {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
				}
			}
			else if (boxH.intersectsLine(ballTrajectory)) {
				Arc2D arcH = new Arc2D.Double((block.getX() + Block.SIZE - ballRadius), (block.getY() + Block.SIZE - ballRadius), (block.getX() + Block.SIZE + ballRadius), (block.getY() + Block.SIZE + ballRadius), 270, 90, Arc2D.OPEN);

				double xa = arcH.getX();
				double r = ballRadius;

				double x1 = BallX;
				double y1 = BallY;
				double x2 = nextBallX;
				double y2 = nextBallY;
				double dx = x2 - x1;
				double dy = y2 - y1;
				double al = Math.atan(dy/dx);

				double c = (xa + r * Math.cos(al) - x1) / dx;
				double intX = x1 + c * dx;
				double intY = y1 + c * dy;

				if (getBallDirectionX() < 0) {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_X);
				}
				else {
					bp = new BouncePoint(intX, intY, BounceDirection.FLIP_Y);
				}
			}
		return bp;
  }

  // line 370 "../../../../../Block223States.ump"
   private boolean isCloser(BouncePoint first, BouncePoint second){
    if(first==null) return false;
  	if(second==null) return true;
  	double secondDist = Math.sqrt((Math.pow(getCurrentBallX()-second.getX(),2)) + (Math.pow(getCurrentBallY()-second.getY(),2)));
  	double firstDist = Math.sqrt((Math.pow(getCurrentBallX()-first.getX(),2)) + (Math.pow(getCurrentBallY()-first.getY(),2)));
  	if(firstDist<secondDist) return true;
  	else return false;
  }

  // line 379 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointWall(){
    BouncePoint bp = null;
	   int ballRadius = Ball.BALL_DIAMETER / 2;
	   int BallX = (int) getCurrentBallX();
	   int BallY = (int) getCurrentBallY();
		int nextBallX = (int) (BallX + getBallDirectionX());
		int nextBallY = (int) (BallY + getBallDirectionY());
		Line2D ballTrajectory = new Line2D.Double(BallX, BallY, nextBallX, nextBallY);
	   
	   Rectangle2D boxA = new Rectangle2D.Double(0, 0, ballRadius, (Game.PLAY_AREA_SIDE - ballRadius));
	   Rectangle2D boxB = new Rectangle2D.Double(ballRadius, 0, (Game.PLAY_AREA_SIDE - Ball.BALL_DIAMETER), ballRadius);
	   Rectangle2D boxC = new Rectangle2D.Double((Game.PLAY_AREA_SIDE - ballRadius), 0, ballRadius, (Game.PLAY_AREA_SIDE - ballRadius));
	   
	   if (ballTrajectory.ptLineDist(5, 5) == 0.0) {
		   bp = new BouncePoint(5, 5, BounceDirection.FLIP_BOTH);
	   }
	   else if (ballTrajectory.ptLineDist(385, 5) == 0.0) {
		   bp = new BouncePoint(385, 5, BounceDirection.FLIP_BOTH);
	   }
	   else if (boxA.intersectsLine(ballTrajectory)) {
		   if (nextBallX <= ballRadius) {
				Line2D lineA = new Line2D.Double(ballRadius, ballRadius, ballRadius, (Game.PLAY_AREA_SIDE - ballRadius));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineA);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
		   }
		}
	   else if (boxB.intersectsLine(ballTrajectory)) {
		   if (nextBallY <= ballRadius) {
				Line2D lineB = new Line2D.Double(ballRadius, ballRadius, (Game.PLAY_AREA_SIDE - ballRadius), ballRadius);
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineB);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_Y);
		   }
		}
	   else if (boxC.intersectsLine(ballTrajectory)) {
		   if (nextBallX >= Game.PLAY_AREA_SIDE - ballRadius) {
				Line2D lineC = new Line2D.Double((Game.PLAY_AREA_SIDE - ballRadius), ballRadius, (Game.PLAY_AREA_SIDE - ballRadius), (Game.PLAY_AREA_SIDE - ballRadius));
				Point2D intersection = calculateIntersectPoint(ballTrajectory, lineC);
				bp = new BouncePoint(intersection.getX(), intersection.getY(), BounceDirection.FLIP_X);
		   }
		}
	   return bp;
  }

  // line 422 "../../../../../Block223States.ump"
   private boolean hitWall(){
    BouncePoint bp = calculateBouncePointWall();
    setBounce(bp);
    return (bp != null);
  }

  // line 428 "../../../../../Block223States.ump"
   private void bounceBall(){
    double inY = bounce.getY() - currentBallY;
	   double remY = ballDirectionY - inY;
	   double inX = bounce.getX() - currentBallX;
	   double remX = ballDirectionY - inX;
	   double newBallDirectionY;
	   double newBallDirectionX;
	   double newPositionY = 0;
	   double newPositionX = 0;
	   double signX = Math.signum(ballDirectionX);
	   if (signX == 0) {
		   signX = 1;
	   }
	   double signY = Math.signum(ballDirectionY);
	   if (signY == 0) {
		   signY = 1;
	   }
	   
	   if ((remY == 0) || (remX == 0)) {
		   // no bounce, no change of dir: new pos is bounce getX and getY
		   setCurrentBallX(bounce.getX());
		   setCurrentBallY(bounce.getY());
		   return;
	   }
	   else if (bounce.getDirection() == BounceDirection.FLIP_Y) {
		   newBallDirectionY = ballDirectionY * -1;
		   newBallDirectionX = ballDirectionX + signX * 0.1 * Math.abs(ballDirectionY);
		   setBallDirectionY(newBallDirectionY);
		   setBallDirectionX(newBallDirectionX);
		   
		   newPositionY = bounce.getY() + remY / ballDirectionY * newBallDirectionY;
		   newPositionX = bounce.getX() + remY / ballDirectionY * newBallDirectionX;
	   }
	   else if (bounce.getDirection() == BounceDirection.FLIP_X) {
		   newBallDirectionX = ballDirectionX * -1;
		   newBallDirectionY = ballDirectionY + signY * 0.1 * Math.abs(ballDirectionX);
		   setBallDirectionX(newBallDirectionX);
		   setBallDirectionY(newBallDirectionY);
		   
		   newPositionX = bounce.getX() + remX / ballDirectionX * newBallDirectionX;
		   newPositionY = bounce.getY() + remX / ballDirectionX * newBallDirectionY;
	   }
	   else if (bounce.getDirection() == BounceDirection.FLIP_BOTH) {
		   newBallDirectionX = ballDirectionX * -1;
		   newBallDirectionY = ballDirectionY * -1;
		   setBallDirectionX(newBallDirectionX);
		   setBallDirectionY(newBallDirectionY);
		   
		   newPositionX = bounce.getX() + remX / ballDirectionX * newBallDirectionX;
		   newPositionY = bounce.getY() + remY / ballDirectionY * newBallDirectionY;
	   }
	   
	   setCurrentBallX(newPositionX);
	   setCurrentBallY(newPositionY);
  }

  // line 484 "../../../../../Block223States.ump"
   private void doSetup(){
    resetCurrentBallX();
		resetCurrentBallY();
		resetBallDirectionX();
		resetBallDirectionY();
		resetCurrentPaddleX();
		game = getGame();
		Level level = game.getLevel(currentLevel-1);

		List<BlockAssignment> assignments = level.getBlockAssignments();

		for (BlockAssignment a : assignments) {
			PlayedBlockAssignment pblock = new PlayedBlockAssignment(Game.WALL_PADDING + (Block.SIZE + Game.COLUMNS_PADDING) * (a.getGridHorizontalPosition()-1), 
					Game.WALL_PADDING +(Block.SIZE + Game.ROW_PADDING) * (a.getGridVerticalPosition() -1), a.getBlock(), this);
		}
		Random rand = new Random();
		int x = rand.nextInt(BlockAssignment.MAX_NR_HORZ_BLOCKS - 1) + 1;
		int y = rand.nextInt(BlockAssignment.MAX_NR_VERT_BLOCKS - 1) + 1;
		while (numberOfBlocks() < game.getNrBlocksPerLevel()) {
			if (x >= BlockAssignment.MAX_NR_HORZ_BLOCKS) {
				x = 1;
				y++;
				if (y > BlockAssignment.MAX_NR_VERT_BLOCKS) {
					x = 1;
					y = 1; 
				}
			} else {
				x++;
			}
			if (level.findBlockAssignment(x,y) == null) {
				PlayedBlockAssignment pblock = new PlayedBlockAssignment(
						Game.WALL_PADDING + (Block.SIZE + Game.COLUMNS_PADDING) * (x - 1),
						Game.WALL_PADDING + (Block.SIZE + Game.ROW_PADDING) * (y - 1), game.getRandomBlock(), this);
			}
		}
  }

  // line 521 "../../../../../Block223States.ump"
   private void doHitPaddleOrWall(){
    bounceBall();
  }

  // line 525 "../../../../../Block223States.ump"
   private void doOutOfBounds(){
    setLives(lives -1);
	resetCurrentBallX();
	resetCurrentBallY();
	resetBallDirectionX();
	resetBallDirectionY();
	resetCurrentPaddleX();
  }

  // line 534 "../../../../../Block223States.ump"
   private void doHitBlock(){
    int score = getScore();
  	PlayedBlockAssignment pblock = bounce.getHitBlock();
  	Block block = pblock.getBlock();
  	int points = block.getPoints();
  	setScore(score+points);
  	pblock.delete();
  	bounceBall();//checkout ballHitsPaddle
  }

  // line 544 "../../../../../Block223States.ump"
   private void doHitBlockNextLevel(){
    doHitBlock();
  	int level = getCurrentLevel();
  	setCurrentLevel(level+1);
  	int paddleIncrease = (getGame().getPaddle().getMaxPaddleLength()-getGame().getPaddle().getMinPaddleLength())/
  							(getGame().numberOfLevels()-1);
  	setCurrentPaddleLength(getGame().getPaddle().getMaxPaddleLength()-paddleIncrease*(level-1));
  	setWaitTime(INITIAL_WAIT_TIME*Math.pow(getGame().getBall().getBallSpeedIncreaseFactor(),level-1));
  }

  // line 554 "../../../../../Block223States.ump"
   private void doHitNothingAndNotOutOfBounds(){
    setCurrentBallX(getCurrentBallX() + getBallDirectionX());
	setCurrentBallY(getCurrentBallY() + getBallDirectionY());
  }

  // line 559 "../../../../../Block223States.ump"
   private void doGameOver(){
    block223 = getBlock223();
	player = getPlayer();
	if (player != null) {
		game = getGame();
		HallOfFameEntry hof =  new HallOfFameEntry(score, playername, player, game, block223);
		game.setMostRecentEntry(hof);
	}
	delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "score" + ":" + getScore()+ "," +
            "lives" + ":" + getLives()+ "," +
            "currentLevel" + ":" + getCurrentLevel()+ "," +
            "waitTime" + ":" + getWaitTime()+ "," +
            "playername" + ":" + getPlayername()+ "," +
            "ballDirectionX" + ":" + getBallDirectionX()+ "," +
            "ballDirectionY" + ":" + getBallDirectionY()+ "," +
            "currentBallX" + ":" + getCurrentBallX()+ "," +
            "currentBallY" + ":" + getCurrentBallY()+ "," +
            "currentPaddleLength" + ":" + getCurrentPaddleLength()+ "," +
            "currentPaddleX" + ":" + getCurrentPaddleX()+ "," +
            "currentPaddleY" + ":" + getCurrentPaddleY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bounce = "+(getBounce()!=null?Integer.toHexString(System.identityHashCode(getBounce())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 109 "../../../../../Block223Persistence.ump"
  private static final long serialVersionUID = 12L ;

  
}