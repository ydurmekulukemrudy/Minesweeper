package DataStructures.Rudy;

public class Location {
    //private int variables
    private int row;
    private int col;
    
    //getters and setters for row and col
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
   
   //toString; prints [row, col]
    @Override
    public String toString() {
        return "[" + row + ", " + col + "]";
    }

    public boolean equals(Location other) {
        return this.row == other.row && this.col == other.col;
    }

    
}
