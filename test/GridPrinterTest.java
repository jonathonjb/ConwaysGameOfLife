import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GridPrinterTest {
    private GridPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new GridPrinter();
    }

    @Test
    public void testCreate3x3GridStringWithDeadCells(){
        Grid grid = new Grid(3);
        String gridString = printer.createGridString(grid);
        String expected = "      \n      \n      \n";
        assertEquals(expected, gridString);
    }

    @Test
    public void testCreate3x3GridStringWithLiveCells(){
        Grid grid = new Grid(3);
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                Cell cell = grid.getCell(row, col);
                cell.setIfAlive(true);
            }
        }

        String gridString = printer.createGridString(grid);
        String expected = " ■ ■ ■\n ■ ■ ■\n ■ ■ ■\n";
        assertEquals(expected, gridString);
    }

    @Test
    public void testCreate3x3GridStringWithHalfLiveCells(){
        Grid grid = createGridWithHalfLiveCells();
        String gridString = printer.createGridString(grid);
        String expected = " ■   ■\n   ■  \n ■   ■\n";
        assertEquals(expected, gridString);
    }

    @Test void testPrint3x3GridStringWithHalfLiveCells(){
        Grid grid = createGridWithHalfLiveCells();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        printer.printGrid(grid);
        String expected = " ■   ■\n   ■  \n ■   ■\n";
        assertEquals(expected, outContent.toString());
    }

    private Grid createGridWithHalfLiveCells() {
        boolean nextCellWillBeAlive = true;
        Grid grid = new Grid(3);
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(nextCellWillBeAlive) {
                    Cell cell = grid.getCell(row, col);
                    cell.setIfAlive(true);
                }
                nextCellWillBeAlive = !nextCellWillBeAlive;
            }
        }
        return grid;
    }
}