import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighborsTest extends Neighbors{
    @Test
    public void testNeighborCreation(){
        Neighbors neighbors = new Neighbors();
        boolean containsCell = neighbors.contains(new Cell());
        assertFalse(containsCell);
    }

    @Test
    public void testNeighborCellAddition(){
        Neighbors neighbors = new Neighbors();
        Cell neighborCell = new Cell();
        assertFalse(neighbors.contains(neighborCell));
        neighbors.addNeighbor(neighborCell);
        assertTrue(neighbors.contains(neighborCell));
    }

    @Test
    public void testNumOfLiveNeighbors(){
        Neighbors neighbors = new Neighbors();
        assertEquals(0, neighbors.getNumberOfLiveNeighbors());

        Cell neighborCellOne = new Cell();
        neighborCellOne.setIfAlive(true);
        neighbors.addNeighbor(neighborCellOne);
        assertEquals(1, neighbors.getNumberOfLiveNeighbors());

        Cell neighborCellTwo = new Cell();
        neighborCellTwo.setIfAlive(true);
        neighbors.addNeighbor(neighborCellTwo);
        assertEquals(2, neighbors.getNumberOfLiveNeighbors());

        neighborCellTwo.setIfAlive(false);
        assertEquals(1, neighbors.getNumberOfLiveNeighbors());
    }

    @Test
    public void testGridNeighborCreation(){
        Grid grid = new Grid(10);
        Cell cell = grid.getCell(0, 0);
        Neighbors neighbors = cell.getNeighbors();
        int expectedNumberOfNeighbors = 3;
        assertEquals(expectedNumberOfNeighbors, neighbors.getNumberOfNeighbors());
    }
}