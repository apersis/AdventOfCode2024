package J06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J06/entree.txt"));
        char[][] map = new char[130][130];
        int index = 0;
        int posX = 0;
        int posY = 0;
        boolean isOOB = false;
        int direction = 0;
        /*
        0 = Vers le haut
        1 = Vers la droite
        2 = Vers le bas
        3 = Vers la gauche
         */
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int jndex = 0;
            for (char caractere : line.toCharArray()){
                map[index][jndex] = caractere;
                if(caractere == '^'){
                    posX = index;
                    posY = jndex;
                }
                jndex++;
            }
            index++;
        }
        //posX >= 0 && posX < 130 && posY >= 0 && posY < 130
        while(!isOOB){
            if(direction%4 == 0){
                map[posX][posY] = 'H';
                if(posX > 0) {
                    if (map[posX - 1][posY] == '#') {
                        direction++;
                    } else {
                        posX--;
                    }
                }
                else{
                    isOOB = true;
                }
            }else if(direction%4 == 1){
                map[posX][posY] = 'D';
                if(posY < 129) {
                    if (map[posX][posY + 1] == '#') {
                        direction++;
                    } else {
                        posY++;
                    }
                }else{
                    isOOB = true;
                }
            }else if(direction%4 == 2){
                map[posX][posY] = 'B';
                if (posX < 129) {
                    if (map[posX + 1][posY] == '#') {
                        direction++;
                    } else {
                        posX++;
                    }
                }else{
                    isOOB = true;
                }
            }else if(direction%4 == 3){
                map[posX][posY] = 'G';
                if (posY > 0 ) {
                    if (map[posX][posY - 1] == '#') {
                        direction++;
                    } else {
                        posY--;
                    }
                }else{
                    isOOB = true;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'X' || map[i][j] == 'H' ||map[i][j] == 'B' ||map[i][j] == 'G' ||map[i][j] == 'D'){
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
