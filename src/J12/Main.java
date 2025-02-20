package J12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<List<CharBoolString>> data = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J12/entree.txt"));
        int total = 0;
        int totalBordure = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            data.add(line.chars().mapToObj(c -> new CharBoolString((char) c,false)).collect(Collectors.toList()));
        }
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(0).size(); j++) {
                if (data.get(i).get(j).isUtilise() == false){
                    int area = 0;
                    int perimeter = 0;
                    int[] result = chercheAutour(i,j, area, perimeter, i, j);
                    total += result[0] * result[1];
                    totalBordure += result[1];
                }
            }
        }
        int totalBordurePart2 = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(0).size(); j++) {
                totalBordurePart2 += data.get(i).get(j).countBordure();
                int nbrBodure = 0;
                int firstI = data.get(i).get(j).getiOfFirst();
                int firstJ = data.get(i).get(j).getjOfFirst();
                if (data.get(i).get(j).getBordure(0) != ' '){
                    // Si bordure en haut
                    if (j < data.get(0).size()-1) {
                        // Si pas contre le bord droit
                        if (data.get(i).get(j).getCaractere() == data.get(i).get(j + 1).getCaractere()) {
                            // Si voisin droit est pareil
                            if (data.get(i).get(j + 1).getBordure(0) == ' ') {
                                // Si voisin droit n'a pas de bordure en haut
                                nbrBodure++;
                            }
                        } else {
                            // Si voisin droit pas pareil
                            nbrBodure++;
                        }
                    }
                    else{
                        // Si contre le bord droit
                        nbrBodure++;
                    }
                }
                if (data.get(i).get(j).getBordure(1) != ' '){
                    // Si bordure en bas
                    if (j < data.get(0).size()-1) {
                        // Si pas contre le bord droit
                        if (data.get(i).get(j).getCaractere() == data.get(i).get(j + 1).getCaractere()) {
                            // Si voisin droit est pareil
                            if (data.get(i).get(j + 1).getBordure(1) == ' ') {
                                // Si voisin droit n'a pas de bordure en bas
                                nbrBodure++;
                            }
                        } else {
                            // Si voisin droit pas pareil
                            nbrBodure++;
                        }
                    }
                    else{
                        // Si contre le bord droit
                        nbrBodure++;
                    }
                }
                if (data.get(i).get(j).getBordure(2) != ' '){
                    // Si bordure a gauche
                    if (i < data.size()-1) {
                        // Si pas contre le bord bas
                        if (data.get(i).get(j).getCaractere() == data.get(i+1).get(j).getCaractere()) {
                            // Si voisin bas est pareil
                            if (data.get(i+1).get(j).getBordure(2) == ' ') {
                                // Si voisin bas n'a pas de bordure a gauche
                                nbrBodure++;
                            }
                        } else {
                            // Si voisin bas pas pareil
                            nbrBodure++;
                        }
                    }
                    else{
                        // Si contre le bord bas
                        nbrBodure++;
                    }
                }
                if (data.get(i).get(j).getBordure(3) != ' '){
                    // Si bordure en haut
                    if (i < data.size()-1) {
                        // Si pas contre le bord bas
                        if (data.get(i).get(j).getCaractere() == data.get(i+1).get(j).getCaractere()) {
                            // Si voisin du bas est pareil
                            if (data.get(i+1).get(j).getBordure(3) == ' ') {
                                // Si voisin bas n'a pas de bordure a droit
                                nbrBodure++;
                            }
                        } else {
                            // Si voisin du bas pas pareil
                            nbrBodure++;
                        }
                    }
                    else{
                        // Si contre le bord bas
                        nbrBodure++;
                    }
                }
                data.get(firstI).get(firstJ).setTotalBordure(data.get(firstI).get(firstJ).getTotalBordure()+nbrBodure);
            }
        }
        int totalPart2 = 0;
        int totalPart1 = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(0).size(); j++) {
                System.out.print(data.get(i).get(j).getTotalBordure());
                if (data.get(i).get(j).isUtilise() == false){
                    totalPart2 += data.get(i).get(j).getTotalArea() * data.get(i).get(j).getTotalBordure();
                    totalPart1 += data.get(i).get(j).getTotalArea() * data.get(i).get(j).getPerimeter();
                }
            }
            System.out.println();
        }
        System.out.println("Premiere partie : " + total);
        System.out.println("Nombre de bordure premiere partie : " + totalBordure);
        System.out.println("Partie deux : " + totalPart2);
        System.out.println("Nombre de bordures deuxieme partie : " + totalBordurePart2);
        System.out.println("Premiere partie avec technique n°2 : " + totalPart1);
    }

    public static int[] chercheAutour(int i, int j, int area, int perimeter, int firstI, int firstJ){
        int perimeterOfCase = 4;
        data.get(i).get(j).setUtilise(true);
        data.get(i).get(j).setiOfFirst(firstI);
        data.get(i).get(j).setjOfFirst(firstJ);
        if (i > 0){
            if (data.get(i).get(j).getCaractere() == data.get(i-1).get(j).getCaractere()) {
                perimeterOfCase--;
                data.get(i).get(j).changeOneBordure(0);
                if (data.get(i-1).get(j).isUtilise() == false) {
                    int[] result = chercheAutour(i - 1, j, area, perimeter, firstI, firstJ);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (i < data.size()-1){
            if (data.get(i).get(j).getCaractere() == data.get(i+1).get(j).getCaractere()) {
                perimeterOfCase--;
                data.get(i).get(j).changeOneBordure(1);
                if (data.get(i+1).get(j).isUtilise() == false) {
                    int[] result = chercheAutour(i + 1, j, area, perimeter, firstI, firstJ);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (j > 0){
            if (data.get(i).get(j).getCaractere() == data.get(i).get(j-1).getCaractere()) {
                perimeterOfCase--;
                data.get(i).get(j).changeOneBordure(2);
                if (data.get(i).get(j-1).isUtilise() == false) {
                    int[] result = chercheAutour(i, j-1, area, perimeter, firstI, firstJ);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (j < data.get(0).size()-1){
            if (data.get(i).get(j).getCaractere() == data.get(i).get(j+1).getCaractere()) {
                perimeterOfCase--;
                data.get(i).get(j).changeOneBordure(3);
                if (data.get(i).get(j+1).isUtilise() == false) {
                    int[] result = chercheAutour(i, j + 1, area, perimeter, firstI, firstJ);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (i == firstI && j == firstJ){
            data.get(i).get(j).setUtilise(false);
            data.get(i).get(j).setTotalArea(area+1);
            data.get(i).get(j).setPerimeter(perimeter+perimeterOfCase);
        }
        return new int[]{area+1,perimeter+perimeterOfCase};
    }
}
