package J02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("src/J02/entree.txt"));
        int nbrSafe = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Integer> listLineFix = new ArrayList<>();
            List<Integer> streamList = Arrays.stream((line.split(" "))).map(string -> Integer.valueOf(string)).toList();
            listLineFix.addAll(streamList);
            boolean isSafe = false;
            for (int j = 0; j < listLineFix.size(); j++) {
                if(!isSafe) {
                    List<Integer> listLine = new ArrayList<>();
                    listLine.addAll(listLineFix);
                    listLine.remove(j);
                    TypeLigne typeLigne = TypeLigne.INCONNU;
                    for (int i = 0; i < listLine.size() - 1; i++) {
                        if (typeLigne == TypeLigne.INCONNU) {
                            // PREMIER TOUR
                            if (listLine.get(i) > listLine.get(i + 1)) {
                                // DECROISSANT
                                if (listLine.get(i) - listLine.get(i + 1) > 3) {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                } else {
                                    typeLigne = TypeLigne.DECROISSANT;
                                }
                            } else if (listLine.get(i) < listLine.get(i + 1)) {
                                // CROISSANT
                                if (listLine.get(i + 1) - listLine.get(i) > 3) {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                } else {
                                    typeLigne = TypeLigne.CROISSANT;
                                }
                            } else {
                                typeLigne = TypeLigne.STAGNANT;
                            }
                        } else if (typeLigne == TypeLigne.DECROISSANT) {
                            // AUTRES TOURS : DECROISSANT
                            if (listLine.get(i) > listLine.get(i + 1)) {
                                // DECROISSANT
                                if (listLine.get(i) - listLine.get(i + 1) > 3) {
                                    // TROP EQUARTÉ
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                } else {
                                    typeLigne = TypeLigne.DECROISSANT;
                                }
                            } else {
                                typeLigne = TypeLigne.INCOHERENT;
                            }
                        } else if (typeLigne == TypeLigne.CROISSANT) {
                            // AUTRES TOURS : CROISSANT
                            if (listLine.get(i) < listLine.get(i + 1)) {
                                // CROISSANT
                                if (listLine.get(i + 1) - listLine.get(i) > 3) {
                                    typeLigne = TypeLigne.TROPEQUARTE;
                                } else {
                                    typeLigne = TypeLigne.CROISSANT;
                                }
                            } else {
                                typeLigne = TypeLigne.INCOHERENT;
                            }
                        }
                    }
                    if (typeLigne == TypeLigne.DECROISSANT || typeLigne == TypeLigne.CROISSANT) {
                        nbrSafe++;
                        isSafe = true;
                    }
                }
            }
            System.out.println(line);
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(nbrSafe);
        System.out.println("Temps d'execution : " + executionTime + " ms");
    }
}
