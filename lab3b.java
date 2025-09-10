// lab3b.java
// fall 2025
// Prof. Lehman
// Demonstrates recursive algorithm to "flood fill"
// an ASCII graphic
// caroline smith

class lab3b {
    public static void main(String[] args) {

        // grid represents a graphic image
        char grid[][] = { { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
                { 'g', 'g', ' ', 'g', 'g', ' ', ' ', ' ', 'g' },
                { 'g', 'g', ' ', ' ', ' ', ' ', 'g', ' ', 'g' },
                { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
                { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
                { 'g', ' ', ' ', ' ', ' ', 'g', ' ', ' ', 'g' },
                { 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'g' },
                { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' } };

        // show starting grid
        display(grid);

        // fill open space ' ' with 'r'
        floodFill(grid, 5, 3, 'r', 'g');
        display(grid);

        // fill same space with 'b'
        floodFill(grid, 0, 0, 'b', 'r');
        display(grid);

        //floodFill(grid, 5, 3, 'y', 'g');
       // display(grid);

        //floodFill(grid, 5, 3, 'y', 'p');
       // display(grid);

    } // main

    // flood fill 2D char array
    public static void floodFill(char temp[][], int row, int col, char fillColor, char borderColor) {


        // base case that stops if the row or column is out of bounds
        if (row < 0 || row >= temp.length || col < 0 || col >= temp[0].length ) {
            return;
        }

        // base case is when position is already filled or hit border
        if (temp[row][col] != fillColor && temp[row][col] != borderColor) {

            // set current to fill color
            temp[row][col] = fillColor;

            // recursive calls to fill
            floodFill(temp, row, col - 1, fillColor, borderColor); // fill left
            floodFill(temp, row, col + 1, fillColor, borderColor); // fill right

            floodFill(temp, row + 1, col, fillColor, borderColor); // fill down
            floodFill(temp, row - 1, col, fillColor, borderColor); // fill up

            floodFill(temp, row - 1, col - 1, fillColor, borderColor); // fill left, up
            floodFill(temp, row - 1, col + 1, fillColor, borderColor); // fill right, up

            floodFill(temp, row + 1, col - 1, fillColor, borderColor); // fill left, down
            floodFill(temp, row + 1, col + 1, fillColor, borderColor); // fill right, down
            
        }

    } // floodFill


    // display array
    public static void display(char temp[][]) {
        for (int r = 0; r < temp.length; r++) {
            for (int c = 0; c < temp[r].length; c++) {
                System.out.print(temp[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    } // display

} // class