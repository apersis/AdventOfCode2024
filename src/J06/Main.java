package J06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J06/entree.txt"));
        char[][] virginMap = new char[130][130];
        int totalPart2 = 0;
        int index = 0;
        int posDepartX = 0;
        int posDepartY = 0;
        int posX = 0;
        int posY = 0;
        boolean isOOB = false;
        boolean isLooping = false;
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
                virginMap[index][jndex] = caractere;
                if(caractere == '^'){
                    posDepartX = index;
                    posDepartY = jndex;
                }
                jndex++;
            }
            index++;
        }
        for (int i = 0; i < virginMap.length; i++) {
            for (int j = 0; j < virginMap[0].length; j++) {
                String[][] map = new String[130][130];
                for (int k = 0; k < virginMap.length; k++) {
                    for (int l = 0; l < virginMap[0].length; l++) {
                        map[k][l] = String.valueOf(virginMap[k][l]);
                    }
                }
                //System.arraycopy(virginMap, 0 ,map, 0, 130);
                if(map[i][j].equals(".")) {
                    map[i][j] = "#";
                    isOOB = false;
                    isLooping = false;
                    posX = posDepartX;
                    posY = posDepartY;
                    direction = 0;
                    while (!isOOB && !isLooping) {
                        if(i == 29 && j == 107){
                            print2D(map);
                        }
                        if (direction % 4 == 0) {
                            if (!map[posX][posY].contains("H")) {
                                map[posX][posY] += 'H';
                                if (posX > 0) {
                                    if (map[posX - 1][posY].equals("#")) {
                                        direction++;
                                    } else {
                                        posX--;
                                    }
                                } else {
                                    isOOB = true;
                                }
                            } else {
                                isLooping = true;
                                totalPart2++;
                            }
                        } else if (direction % 4 == 1) {
                            if (!map[posX][posY].contains("D")) {
                                map[posX][posY] += 'D';
                                if (posY < 129) {
                                    if (map[posX][posY + 1].equals("#")) {
                                        direction++;
                                    } else {
                                        posY++;
                                    }
                                } else {
                                    isOOB = true;
                                }
                            } else {
                                isLooping = true;
                                totalPart2++;
                            }
                        } else if (direction % 4 == 2) {
                            if (!map[posX][posY].contains("B")) {
                                map[posX][posY] += 'B';
                                if (posX < 129) {
                                    if (map[posX + 1][posY].equals("#")) {
                                        direction++;
                                    } else {
                                        posX++;
                                    }
                                } else {
                                    isOOB = true;
                                }
                            } else {
                                isLooping = true;
                                totalPart2++;
                            }
                        } else if (direction % 4 == 3) {
                            if (!map[posX][posY].contains("G")) {
                                map[posX][posY] += 'G';
                                if (posY > 0) {
                                    if (map[posX][posY - 1].equals("#")) {
                                        direction++;
                                    } else {
                                        posY--;
                                    }
                                } else {
                                    isOOB = true;
                                }
                            } else {
                                isLooping = true;
                                totalPart2++;
                            }
                        }
                    }
                }
            }
        }
        /*int total = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'X' || map[i][j] == 'H' ||map[i][j] == 'B' ||map[i][j] == 'G' ||map[i][j] == 'D'){
                    total++;
                }
            }
        }
        System.out.println(total);*/
        System.out.println(totalPart2);
    }
    public static void print2D(String mat[][])
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j].contains("^")){
                    System.out.print("\u001B[31m" + mat[i][j] + "\u001B[0m");
                }else{
                    System.out.print(mat[i][j]);
                }
            }
            System.out.println();
        }
    }
}
