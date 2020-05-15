public class GridPrinter{

    public static void printGrid(Grid grid){
        String gridString = createGridString(grid);
        System.out.print(gridString);
    }

    public static String createGridString(Grid grid){
        String gridString = "";
        int size = grid.getSize();

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                Cell cell = grid.getCell(row, col);
                gridString += createCellString(cell);
            }
            gridString += "\n";
        }
        return gridString;
    }

    private static String createCellString(Cell cell){
        if(cell.checkIfAlive())
            return " ■";
        else
            return "  ";
    }
}
