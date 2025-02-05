package J10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static IntBool[][] tableau = new IntBool[41][41];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J10/entree.txt"));
        //IntBool tableau[][] = new IntBool[8][8];
        int i = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int j = 0;
            for (char caractere : line.toCharArray()) {
                IntBool monIntBool = new IntBool();
                monIntBool.setChiffre(caractere - '0');
                monIntBool.setUtilise(false);
                tableau[i][j] = monIntBool;
                j++;
            }
            i++;
        }
        int total = 0;
        for (i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if(tableau[i][j].getChiffre() == 0){
                    for (int k = 0; k < tableau.length; k++) {
                        for (int l = 0; l < tableau[k].length; l++) {
                            tableau[k][l].setUtilise(false);
                        }
                    }
                    System.out.println(tableau);
                    total += calculAllRoute(i, j, 0);
                    System.out.println(tableau);
                }
            }
        }
        System.out.println(total);
    }
    public static int calculAllRoute(int i, int j, int total){
        if (tableau[i][j].getChiffre() == 9){
            if (!tableau[i][j].isUtilise()) {
                total++;
                //tableau[i][j].setUtilise(true);
            }
        }else{
            if (i-1 >= 0) {
                if (tableau[i - 1][j].getChiffre() == tableau[i][j].getChiffre() + 1) {
                    total = calculAllRoute(i - 1, j, total);
                }
            }
            if (i+1 < tableau.length) {
                if (tableau[i + 1][j].getChiffre() == tableau[i][j].getChiffre() + 1) {
                    total = calculAllRoute(i + 1, j, total);
                }
            }
            if (j-1 >= 0) {
                if (tableau[i][j - 1].getChiffre() == tableau[i][j].getChiffre() + 1) {
                    total = calculAllRoute(i, j - 1, total);
                }
            }
            if (j+1 < tableau.length) {
                if (tableau[i][j + 1].getChiffre() == tableau[i][j].getChiffre() + 1) {
                    total = calculAllRoute(i, j + 1, total);
                }
            }
        }
        return total;
    }
}
