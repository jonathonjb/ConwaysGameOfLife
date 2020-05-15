import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void test3x3GridCreation(){
        Grid grid = new Grid(3);
        Cell[][] expected = new Cell[3][3];
        for(int i = 0; i < expected.length; i++){
            Cell[] currentRow = new Cell[] {new Cell(), new Cell(), new Cell()};
            expected[i] = currentRow;
        }

        for(int row = 0; row < expected.length; row++){
            for(int col = 0; col < expected[0].length; col++){
                Cell gridCell = grid.getCell(row, col);
                Cell expectedCell = expected[row][col];

                boolean gridCellIsAlive = gridCell.checkIfAlive();
                boolean expectedCellIsAlive = expectedCell.checkIfAlive();

                assertEquals(expectedCellIsAlive, gridCellIsAlive);
            }
        }
    }

    @Test
    public void testInBounds(){
        Grid testGrid = new Grid(20);
        assertFalse(testGrid.inBounds(-1, 0));
        assertFalse(testGrid.inBounds(0, -1));
        assertFalse(testGrid.inBounds(-1, -1));
        assertFalse(testGrid.inBounds(20, 10));
        assertFalse(testGrid.inBounds(10, 20));
        assertFalse(testGrid.inBounds(20, 20));
        assertFalse(testGrid.inBounds(1000000000, 10));
        assertFalse(testGrid.inBounds(10, 1000000000));
        assertFalse(testGrid.inBounds(-1000000000, 0));
        assertFalse(testGrid.inBounds(0, -1000000000));
        assertFalse(testGrid.inBounds(0, -1000000000));

        assertTrue(testGrid.inBounds(0, 0));
        assertTrue(testGrid.inBounds(19, 0));
        assertTrue(testGrid.inBounds(0, 19));
        assertTrue(testGrid.inBounds(19, 19));
        assertTrue(testGrid.inBounds(10, 10));
    }

    @Test
    public void testIfAllCellsAreInitialized(){
        int size = 20;
        Grid testGrid = new Grid(size);
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Object object = testGrid.getCell(row, col);
                assert(object != null);
            }
        }
    }

    @Test
    public void testGetAllCellsFunction(){
        int size = 3;
        Grid testGrid = new Grid(size);
        Set<Cell> cells = testGrid.getAllCells();

        int expectedSize = 9;
        assertEquals(expectedSize, cells.size());

        Cell cellOne = testGrid.getCell(0, 0);
        Cell cellTwo = testGrid.getCell(2, 2);

        assertTrue(cells.contains(cellOne));
        assertTrue(cells.contains(cellTwo));
    }
}