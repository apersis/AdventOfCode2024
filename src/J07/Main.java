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
        long nombreCombinaisons = Math.round(Math.pow(2,monEquation.size()-2));
        for (int i = 0; i < nombreCombinaisons; i++) {
            // init du binaire
            int[] binaire = new int[monEquation.size() - 2];
            for (int j = 0; j < binaire.length; j++) {
                binaire[j] = 0;
            }
            int id = 0;
            int decToBin = i;
            while (decToBin > 0) {
                binaire[id++] = decToBin % 2;
                decToBin = decToBin / 2;
            }

            long totalCombinaison = monEquation.get(1);
            for (int j = 2; j < monEquation.size(); j++) {
                //ADDITIONNE CHAQUE NOMBRE
                if (binaire[j - 2] == 0) {
                    totalCombinaison += monEquation.get(j);
                } else {
                    totalCombinaison *= monEquation.get(j);
                }
            }
            if (totalCombinaison == monEquation.getFirst()) {
                return totalCombinaison;
            }
        }
        return 0;
    }
}
