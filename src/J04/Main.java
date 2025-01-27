package J04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J04/entree.txt"));
        char[][] tableau = new char[140][140];
        int i = 0;
        int total = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            tableau[i] = line.toCharArray();
            i++;
        }
        for (i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                if (tableau[i][j] == 'X'){
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if(i+k*3>=0 && j+l*3>=0 && i+k*3<140 && j+l*3<140){
                                if (tableau[i+k][j+l] == 'M') {
                                    if (tableau[i+k*2][j+l*2] == 'A') {
                                        if (tableau[i+k*3][j+l*3] == 'S') {
                                            total++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(total);
        total = 0;
        for (i = 1; i < 139; i++) {
            for (int j = 1; j < 139; j++) {
                if (tableau[i][j] == 'A') {
                    if (tableau[i-1][j-1] == 'M'){
                        if (tableau[i+1][j+1] == 'S'){
                            if (tableau[i-1][j+1] == 'M'){
                                if (tableau[i+1][j-1] == 'S'){
                                    total++;
                                }
                            }
                            else if (tableau[i-1][j+1] == 'S'){
                                if (tableau[i+1][j-1] == 'M'){
                                    total++;
                                }
                            }
                        }
                    }
                    else if (tableau[i-1][j-1] == 'S'){
                        if (tableau[i+1][j+1] == 'M'){
                            if (tableau[i-1][j+1] == 'M'){
                                if (tableau[i+1][j-1] == 'S'){
                                    total++;
                                }
                            }
                            else if (tableau[i-1][j+1] == 'S'){
                                if (tableau[i+1][j-1] == 'M'){
                                    total++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(total);
    }
}
