/*
 * Mouner Dabjan 
 * 4/1/2020
 * This program determines if the human cells are cancerous or not 
 */
package cancer;

/**
 *
 * @author User
 */
public class Cancer {

    public static String grid[][];
    public static int blobSize;

    public static void main(String[] args) {
        int row, col;
        //Create 2D array size 15 x 15
        grid = new String[15][15];

        //Fill the array with positive signs 
        for (row = 0; row < 15; row++) {
            for (col = 0; col < 15; col++) {
                grid[row][col] = "+";
            }
        }

    //Fill 98 random elements in the array with an asterisk
        //Do no choose an element along the border
        //The border will always contain elements with spaces
        //(blank border)
        for (int i = 0; i < 98  ; i++) {
            row = (int) (Math.random() * 13 + 1);
            col = (int) (Math.random() * 13 + 1);
            grid[row][col] = "-";
        }

        //Print out the current grid
        displayGrid();

        //variable to determine the size of the blob
        blobSize = 0;

 
        for (int i=0 ; i < 98; i++){
        int blobRow = (int) (Math.random() * 13 + 1);
        int blobCol = (int) (Math.random() * 13 + 1);
               
        cancerFill(blobRow, blobCol);
        }
        
        
        // print out how many negatives there was 
        System.out.println("The blob had " + blobSize
                + " items in it");
        System.out.println("The new grid is:");
        //Print out the new grid
        displayGrid();
    }
    // recursive method 
    public static void cancerFill(int row, int col) {

        if (grid[row][col].equals("-")) {
            grid[row][col] = " ";
            blobSize++;
            cancerFill(row - 1, col - 1);
            cancerFill(row - 1, col);
            cancerFill(row - 1, col + 1);
            cancerFill(row, col - 1);
            cancerFill(row, col + 1);
            cancerFill(row + 1, col - 1);
            cancerFill(row + 1, col);
            cancerFill(row + 1, col + 1);
            
        }

    }
    // display grid method 
    public static void displayGrid() {
        String output = "";
        for (int row = 0; row <15; row++) {
            if ((row >0) && (row < 15)) {
                output += (row % 15);
            }
            for (int col = 0; col < 15; col++) {
                output += grid[row][col];
            }
            output += "\n";
        }
        System.out.println(output);
    }

}
