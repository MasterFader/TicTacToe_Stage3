package tictactoe;
//import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String inputString = scanner.nextLine().replace("_"," ");


        int counter9 = 0;
        char[][] matrix = new char[3][3];
        char[][] inputMatrix = new char[3][3];
        boolean checkInput = true;
        int x = 0;
        int y = 0;
        boolean stringCheck = false;
        boolean cellCheck = true;

        String str1 = null;
        String str2 = null;

        tictactoeFillingMatrix(inputString,counter9,matrix);

        printTicTacToe(matrix);

        do{
            do{
                do{
                    do{
                        System.out.println("Enter the coordinates: ");
                        stringCheck = false;
                        str1 = scanner.next();
                        if(isNumber(str1)){
                            stringCheck = true;
                            x = Integer.parseInt(str1);
                            continue;
                        }
                        System.out.println("You should enter numbers!");
                    }while(!stringCheck);

                    stringCheck = false;
                    str2 = scanner.next();
                    if(isNumber(str2)){
                        stringCheck = true;
                        y = Integer.parseInt(str2);
                        continue;
                    }
                    System.out.println("You should enter numbers!");
                }while(!stringCheck);

            }while(!inputCheck(x,y));

        }while(!checkCell(matrix,x,y));


        inputMatrix[(x-1)][(y-1)] = 'X';

//        checkCell(matrix,x,y);


//        printTicTacToe(matrix);
        rotateMatrixLeft(matrix);
        rotateMatrixLeft(matrix);
        rotateMatrixLeft(matrix);
//        printTicTacToe(matrix);
//        printTicTacToe(inputMatrix);
        matrix[(x-1)][(y-1)] = inputMatrix[(x-1)][(y-1)];
        rotateMatrixLeft(matrix);

        printTicTacToe(matrix);


        }

        private static boolean checkCell(char[][] matrix,int x,int y) {
        char check;
        rotateMatrixLeft(matrix);
//        printTicTacToe(matrix);
        rotateMatrixLeft(matrix);
//        printTicTacToe(matrix);
        rotateMatrixLeft(matrix);
//        printTicTacToe(matrix);
            check = matrix[(x - 1)][(y - 1)];
        if (check != ' '){
            System.out.println("This cell is occupied! Choose another one!");
            rotateMatrixLeft(matrix);
            return false;
        }
        rotateMatrixLeft(matrix);
        return true;
    }
        private static boolean checkStringX(String stringInput1){
            if(stringInput1 != null){
                System.out.println("You Should Enter Numbers!");
                return true;
            }
            return false;
        }
        private static boolean checkStringY(String stringInput2){
        if(stringInput2 != null){
            System.out.println("You Should Enter Numbers!");
            return true;
        }
        return false;
    }
        static void rotateMatrixLeft (char[][] mat){
            int matrixLenght = 3;
            // Consider all squares one by one
            for (int x = 0; x < matrixLenght / 2; x++) {
                // Consider elements in group of 4 in
                // current square
                for (int y = x; y < matrixLenght - x - 1; y++) {
                    // store current cell in temp variable
                    int temp = mat[x][y];

                    // move values from right to top
                    mat[x][y] = mat[y][matrixLenght - 1 - x];

                    // move values from bottom to right
                    mat[y][matrixLenght - 1 - x] = mat[matrixLenght - 1 - x][matrixLenght - 1 - y];

                    // move values from left to bottom
                    mat[matrixLenght - 1 - x][matrixLenght - 1 - y] = mat[matrixLenght - 1 - y][x];

                    // assign temp to left
                    mat[matrixLenght - 1 - y][x] = (char) temp;
                }
            }
        }
        private static void printTicTacToe ( char[][] matrix){
            System.out.println("---------");
            System.out.println("| " + matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2] + " |");
            System.out.println("| " + matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2] + " |");
            System.out.println("| " + matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2] + " |");
            System.out.println("---------");
        }
        private static boolean inputCheck ( int x, int y){

            if (x > 0 && x < 4) {
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            if (y > 0 && y < 4) {
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }

            return true;
        }
        private static void tictactoeFillingMatrix (String inputString,int counter9, char[][] matrix){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = inputString.charAt(counter9 + j);
                }
                counter9 += 3;
            }
        }

        static boolean isNumber(String s){
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;

            return true;
    }


}

