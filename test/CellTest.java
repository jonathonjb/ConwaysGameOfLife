import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;

    @BeforeEach
    public void setUp(){
        cell = new Cell(0, 0);
    }

    @Test
    public void testCellCreation(){
        final int TEST_ROW = 8;
        final int TEST_COL = 7;
        Cell cell = new Cell(TEST_ROW, TEST_COL);
        assertEquals(TEST_ROW, cell.getRow());
        assertEquals(TEST_COL, cell.getCol());
    }

    @Test void testSetIfAlive(){
        cell.setIfAlive(true);
        assertTrue(cell.checkIfAlive());

        cell.setIfAlive(false);
        assertFalse(cell.checkIfAlive());
    }

    @Test void testIfCellHasNeighbor(){
        Neighbors neighbors = cell.getNeighbors();
        assert(neighbors != null);
    }

    @Test
    public void testNeighborAddition(){
        Cell neighborCell = new Cell(1, 0);
        cell.addNeighbor(neighborCell);
        Neighbors neighbors = cell.getNeighbors();
        neighbors.contains(neighborCell);
    }
}