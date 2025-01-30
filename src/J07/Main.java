package J07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J07/entree.txt"));
        long total = 0;
        while (scanner.hasNextLine()){
            //CHAQUE LIGNE DU SCANNER
            List<Long> monEquation;
            String line = scanner.nextLine();
            line = line.replaceAll(":","");
            monEquation = Arrays.stream(line.split(" ")).toList().stream().map(Long::valueOf).toList();
            total += calcul(monEquation);
        }
        System.out.println(total);
    }
    public static long calcul(List<Long> monEquation){
        long nombreCombinaisons = Math.round(Math.pow(3,monEquation.size()-2));
        for (int i = 0; i < nombreCombinaisons; i++) {
            // init du binaire
            int[] trinaire = new int[monEquation.size() - 2];
            for (int j = 0; j < trinaire.length; j++) {
                trinaire[j] = 0;
            }
            int id = 0;
            int decToTri = i;
            while (decToTri > 0) {
                trinaire[id++] = decToTri % 3;
                decToTri = decToTri / 3;
            }

            long totalCombinaison = monEquation.get(1);
            for (int j = 2; j < monEquation.size(); j++) {
                //ADDITIONNE CHAQUE NOMBRE
                if (trinaire[j - 2] == 0) {
                    totalCombinaison += monEquation.get(j);
                } else if (trinaire[j - 2] == 1){
                    totalCombinaison *= monEquation.get(j);
                } else {
                    totalCombinaison = Long.parseLong (String.valueOf(totalCombinaison) + String.valueOf(monEquation.get(j)));
                }
            }
            if (totalCombinaison == monEquation.getFirst()) {
                return totalCombinaison;
            }
        }
        return 0;
    }
}
