package J08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J08/entree.txt"));
        String[][] map = new String[50][50];
        int index = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            map[index++] = line.split("");
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!map[i][j].contains(".")){
                    String frequencie = map[i][j];
                    for (int k = 0; k < map.length; k++) {
                        for (int l = 0; l < map[0].length; l++) {
                            if (i!=k && j!=l){
                                if (map[k][l].substring(0,1).equals(frequencie.substring(0,1))) {
                                    int diffX = i - k;
                                    int diffY = j - l;
                                    int antinodeX = i + diffX;
                                    int antinodeY = j + diffY;
                                    while (antinodeX >= 0 && antinodeX < map.length && antinodeY >= 0 && antinodeY < map[0].length){
                                        map[antinodeX][antinodeY] += "#";
                                        antinodeX = antinodeX + diffX;
                                        antinodeY = antinodeY + diffY;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int totalUnique = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].contains("#") || !map[i][j].contains(".")) {
                    totalUnique++;
                }
            }
        }
        System.out.println(totalUnique);
    }
}
