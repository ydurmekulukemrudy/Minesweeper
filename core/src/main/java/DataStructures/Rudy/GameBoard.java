package DataStructures.Rudy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameBoard {
    //private int varaibles
    private int[][] board;//our data structure
    private int numBombs;//number of bombs
    private int numFlags;//number of flags you still have to place
    private static final int BOMB = -1;//help with readability
    private GameplayScreen gameplayScreen;

    //texture = 2d graphic
    private Texture emptyTile;
    private Texture emptyFloorTile;
    private Texture oneTile;
    private Texture twoTile;
    private Texture threeTile;
    private Texture fourTile;
    private Texture fiveTile;
    private Texture sixTile;
    private Texture sevenTile;
    private Texture eightTile;
    private Texture bombTile;
    private Texture flagTile;

    public GameBoard(GameplayScreen gameplayScreen) {
        this.gameplayScreen = gameplayScreen;
        board = new int[16][30];
        numBombs = 50;
        numFlags = numBombs;
        loadGraphics();
    }

    public GameBoard(GameplayScreen gameplayScreen, int numRows, int numCols, int numBombs) {
        this.gameplayScreen = gameplayScreen;
        board = new int[numRows][numCols];
        this.numBombs = numBombs;
        this.numFlags = numBombs;
    }

    public void loadGraphics() {
        emptyTile = new Texture("assets/emptyTile.jpg");
        emptyFloorTile = new Texture("assets/empty floor.jpg");
        oneTile = new Texture("assets/oneTile.jpg");
        twoTile = new Texture("assets/twoTile.jpg");
        threeTile = new Texture("assets/threeTile.jpg");
        fourTile = new Texture("assets/fourTile.jpg");
        fiveTile = new Texture("assets/fiveTile.jpg");
        sixTile = new Texture("assets/sixTile.jpg");
        sevenTile = new Texture("assets/sevenTile.jpg");
        eightTile = new Texture("assets/eightTile.jpg");
        bombTile = new Texture("assets/bomb.jpg");
        flagTile = new Texture("assets/flagTile.jpg");
    }

    public void draw(SpriteBatch spriteBatch) {
        //each tile is 25x25 pixels
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                spriteBatch.draw(emptyTile, j*25 + 1, i*25 +1);
            }
        }
        
    }
}