import java.util.HashSet;
import java.util.Set;

public class Neighbors {
    private Set<Cell> neighbors;

    public Neighbors(){
        neighbors = new HashSet<>();
    }

    public void addNeighbor(Cell neighbor) {
        this.neighbors.add(neighbor);
    }

    public boolean contains(Cell cell){
        return neighbors.contains(cell);
    }

    public int getNumberOfLiveNeighbors(){
        int numOfLiveNeighbors = 0;
        for(Cell cell : neighbors){
            if(cell.checkIfAlive()){
                numOfLiveNeighbors++;
            }
        }
        return numOfLiveNeighbors;
    }

    protected int getNumberOfNeighbors(){
        return neighbors.size();
    }
}
