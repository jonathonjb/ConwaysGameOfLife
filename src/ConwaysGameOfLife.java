import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ConwaysGameOfLife {
    private static Grid grid;
    private static int size;

    public static void main(String[] args){
        size = InputGetter.getGridSizeFromUser();
        startGame();
    }

    private static void startGame(){
        grid = new Grid(size);
        grid.randomlyPlaceAliveCells();
        int round = 0;
        int waitBetweenRoundsInMilliseconds = 100;

        while(round < 50){
            executeRound();

            clearScreen();

            GridPrinter.printGrid(grid);
            round++;
            wait(waitBetweenRoundsInMilliseconds);
        }
    }

    private static void wait(int waitBetweenRoundsInMilliseconds) {
        try {
            Thread.sleep(waitBetweenRoundsInMilliseconds);
        }
        catch(InterruptedException exception){
            System.err.println(exception.getMessage());
        }
    }

    private static void executeRound(){
        Set<Cell> cellsThatChangesValueAfterRound = new HashSet<>();
        Set<Cell> cells = grid.getAllCells();
        for(Cell cell : cells){
            if(checkIfCellWillChange(cell))
                cellsThatChangesValueAfterRound.add(cell);
        }
        for(Cell cell : cellsThatChangesValueAfterRound){
            if(cell.checkIfAlive())
                cell.setIfAlive(false);
            else
                cell.setIfAlive(true);
        }
    }

    private static boolean checkIfCellWillChange(Cell cell){
        if(cell.checkIfAlive())
            return checkIfAliveCellWillChange(cell);
        else
            return checkIfDeadCellWillChange(cell);
    }

    private static boolean checkIfAliveCellWillChange(Cell cell){
        Neighbors neighbors = cell.getNeighbors();
        int numOfAliveNeighbors = neighbors.getNumberOfLiveNeighbors();
        if(numOfAliveNeighbors < 2 || numOfAliveNeighbors > 3)
            return true;
        else
            return false;
    }

    private static boolean checkIfDeadCellWillChange(Cell cell){
        Neighbors neighbors = cell.getNeighbors();
        int numOfAliveNeighbors = neighbors.getNumberOfLiveNeighbors();
        return numOfAliveNeighbors == 3;
    }

    private static void clearScreen(){
        clearWindowsScreen();
        clearUnixScreen();

    }

    private static void clearUnixScreen() {
        System.out.print("\033[H\033[2J");
    }

    private static void clearWindowsScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
