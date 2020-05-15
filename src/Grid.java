import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grid {
    private final double CHANCE_OF_EACH_CELL_BEING_ALIVE = .2;

    private Cell grid[][];
    private int size;
    private GridPrinter printer;

    public Grid(int size){
        this.size = size;
        initializeGridFullOfDeadCells();
        printer = new GridPrinter();
    }

    private void initializeGridFullOfDeadCells(){
        grid = new Cell[size][size];
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cell = new Cell(row, col);
                grid[row][col] = cell;
            }
        }
        initializeNeighbors();
    }

    private void initializeNeighbors() {
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cell = grid[row][col];
                initializeCellNeighbors(cell);
            }
        }
    }

    // Since the cell classes has no way of knowing who their neighbors are, it is initialized here.
    private void initializeCellNeighbors(Cell cell){
        int row = cell.getRow();
        int col = cell.getCol();

        for(int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++){
            for(int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++){
                if(neighborRow == row && neighborCol == col)
                    continue;
                if(inBounds(neighborRow, neighborCol)){
                    Cell neighborCell = grid[neighborRow][neighborCol];
                    cell.addNeighbor(neighborCell);
                }
            }
        }
    }

    public void randomlyPlaceAliveCells(){
        Random random = new Random();
        Set<Cell> cells = getAllCells();
        for(Cell cell : cells){
            double randomNumber = random.nextDouble();
            if(randomNumber <= CHANCE_OF_EACH_CELL_BEING_ALIVE){
                cell.setIfAlive(true);
            }
        }
    }

    public boolean inBounds(int row, int col){
        boolean rowInBounds = row >= 0 && row < size;
        boolean colInBounds = col >= 0 && col < size;
        return rowInBounds && colInBounds;
    }

    public Cell getCell(int row, int col){
        return grid[row][col];
    }

    public int getSize(){
        return size;
    }

    public Set<Cell> getAllCells(){
        Set<Cell> cells = new HashSet<>();

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cell = grid[row][col];
                cells.add(cell);
            }
        }

        return cells;
    }
}
