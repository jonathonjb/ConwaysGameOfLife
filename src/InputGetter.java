import java.util.Scanner;

public class InputGetter {
    private static final int MAX_SIZE = 50;
    private static Scanner scanner = new Scanner(System.in);

    public static int getGridSizeFromUser(){
        String input = "";
        while(!checkIfSizeInputIsValid(input)){
            askUserForSize();
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }

    private static void askUserForSize(){
        System.out.print("Please enter the size of the grid: ");
    }

    protected static boolean checkIfSizeInputIsValid(String input){
        try{
            int numInput = Integer.parseInt(input);
            return numInput > 0 && numInput <= MAX_SIZE;
        }
        catch(NumberFormatException exception){
            return false;
        }
    }
}
