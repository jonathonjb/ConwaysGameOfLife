import java.util.List;

public class Cell {
    private boolean isAlive;
    private Neighbors neighbors;

    private int row;
    private int col;

    public Cell(){
        isAlive = false;
        neighbors = new Neighbors();
    }

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        isAlive = false;
        neighbors = new Neighbors();
    }

    public Neighbors getNeighbors(){
        return neighbors;
    }

    public void setIfAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean checkIfAlive(){
        return isAlive;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public void addNeighbor(Cell cell){
        neighbors.addNeighbor(cell);
    }
}
