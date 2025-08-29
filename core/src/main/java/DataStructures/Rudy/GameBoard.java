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
        addBombs();
        initBoardNumbers();
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

    //randomly add bombs around the tiles
    public void addBombs() {
        int bombsToBeAdded = numBombs;

        while (bombsToBeAdded > 0) {
            int randomRow = (int) (Math.random() * board.length);
            int randomCol = (int) (Math.random() * board[0].length);

            if(board[randomRow][randomCol] != -1) {
                board[randomRow][randomCol] = -1;
                bombsToBeAdded--;
            }
        }
    }

    //checks if the row or column is valid (greater or equal to 0, less than the length of the board)
    public boolean isValid(int row, int col) {
        return (row >= 0 && row < board.length) && (col >= 0 && col < board[0].length);
    }

    //checks all surrounding tiles for bombs; returns an integer representing the number of bombs around a location
    public int checkSurroundingTiles(int row, int col) {
        //integer variable for number of bombs around the tile
        int surroundingBombs = 0;
        
        //checks if all possible surround tiles are valid and have bombs
        for(int i = row -1; i <= row +1; i++) {
            for(int j = col - 1; j <= col +1; j++) {
                if(isValid(i, j) && board[i][j] == -1) {
                    surroundingBombs++;
                }
            }
        }
        /* 
        if(isValid(row -1, col) && board[row-1][col] == -1) {
            surroundingBombs++;
        }

        if(isValid(row +1, col) && board[row+1][col] == -1) {
            surroundingBombs++;
        }

        if(isValid(row, col-1) && board[row][col-1] == -1) {
            surroundingBombs++;
        }

        if(isValid(row, col+1) && board[row][col+1] == -1) {
            surroundingBombs++;
        }

        if(isValid(row -1, col) && board[row-1][col] == -1) {
            surroundingBombs++;
        }

        if(isValid(row -1, col-1) && board[row-1][col-1] == -1) {
            surroundingBombs++;
        }
        if(isValid(row -1, col+1) && board[row-1][col+1] == -1) {
            surroundingBombs++;
        }

        if(isValid(row +1, col-1) && board[row+1][col-1] == -1) {
            surroundingBombs++;
        }

        if(isValid(row +1, col+1) && board[row+1][col+1] == -1) {
            surroundingBombs++;
        }
            */

        //return the number of bombs around a tile
        return surroundingBombs;
    }

    //initializes the tiles by giving integer values for tiles surrounding bombs that represent the number of bombs around that tile
    public void initBoardNumbers() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != -1) {
                    board[i][j] = checkSurroundingTiles(i, j);
                }
            }
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        int xOffset = 100;
        int yOffset = 500;

        //each tile is 25x25 pixels
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                //tile revealing a bomb
                if(board[i][j] == 9) {
                    spriteBatch.draw(bombTile, j*25 + xOffset, yOffset-i*25);
                }
                //temporarily draw the bombs on the screen
                //so I know the bombs are being placed corectly
                //if they are not...I will fix this when 
                if(board[i][j] ==-1) {
                    spriteBatch.draw(bombTile, j*25 + xOffset, yOffset-i*25);
                }
                //tiles revealing numbers
                else if(board[i][j] == 10) {
                    spriteBatch.draw(emptyFloorTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 1) {
                    spriteBatch.draw(oneTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 2) {
                    spriteBatch.draw(twoTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 3) {
                    spriteBatch.draw(threeTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 4) {
                    spriteBatch.draw(fourTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 5) {
                    spriteBatch.draw(fiveTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 6) {
                    spriteBatch.draw(sixTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 7) {
                    spriteBatch.draw(sevenTile, j*25 + xOffset, yOffset-i*25);
                }
                else if(board[i][j] == 8) {
                    spriteBatch.draw(eightTile, j*25 + xOffset, yOffset-i*25);
                }
                //+20 to the tile's value indicates a flag 
                else if(board[i][j] >= 19 && board[i][j] <= 28) {
                    spriteBatch.draw(flagTile, j*25 + xOffset, yOffset-i*25);
                }
                //empty tile if less than nine
                else {
                    spriteBatch.draw(emptyTile, j*25 + xOffset, yOffset-i*25);
                }
            }
        }
    }
}