package J09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J09/entree.txt"));
        List<Integer> diskMap = new ArrayList<>();
        int index = 0;
        String line = scanner.next();
        for (char caractere : line.toCharArray()){
            int intCaractere = caractere - '0';
            for (int i = 0; i < intCaractere; i++) {
                if (index % 2 == 0){
                    diskMap.add(index/2);
                }else{
                    diskMap.add(null);
                }
            }

            index++;
        }
        // PART 1
        /*int indexFirstNull = 0;
        int indexLastInt = diskMap.size()-1;
        while (indexFirstNull < indexLastInt){
            while (diskMap.get(indexFirstNull) != null){
                indexFirstNull++;
            }
            while (diskMap.get(indexLastInt) == null){
                indexLastInt--;
            }
            if (indexFirstNull < indexLastInt) {
                Collections.swap(diskMap, indexLastInt, indexFirstNull);
            }
        }*/
        // PART 2
        int indexLastFile = diskMap.size()-1;
        int sizeLastFile = 1;
        int indexFirstNull = 0;
        int sizeFirstNull = 0;
        while (indexLastFile > 1){
            sizeLastFile = 1;
            sizeFirstNull = 0;
            indexFirstNull = 0;
            // Naviguer jusqu'au dernier fichier
            while (diskMap.get(indexLastFile) == null && indexLastFile > 1) {
                indexLastFile--;
            }
            if (indexLastFile > 1) {
                // Determiner sa taille et placer son index au premier
                while (diskMap.get(indexLastFile - 1) != null && diskMap.get(indexLastFile - 1).equals(diskMap.get(indexLastFile)) && indexLastFile > 1) {
                    indexLastFile--;
                    sizeLastFile++;
                }
                if (indexFirstNull > 94520) {
                    System.out.println("coucou");
                }
                while (sizeFirstNull < sizeLastFile && indexFirstNull < diskMap.size()) {
                    // Naviguer jusqu'au premier null
                    while (diskMap.get(indexFirstNull) != null && indexFirstNull < diskMap.size()) {
                        indexFirstNull++;
                    }
                    sizeFirstNull = 1;
                    // Determiner sa taille
                    int i = 0;
                    while (indexFirstNull + i + 1 < diskMap.size() && diskMap.get(indexFirstNull + i + 1) == (diskMap.get(indexFirstNull + i))) {
                        sizeFirstNull++;
                        i++;
                    }
                    // Si la taille du premier null est trop petit, on passe au suivant
                    if (sizeFirstNull < sizeLastFile && indexFirstNull + i < diskMap.size()) {
                        indexFirstNull += i + 1;
                    }
                }
                if (sizeFirstNull >= sizeLastFile && indexFirstNull < indexLastFile) {
                    for (int i = 0; i < sizeLastFile; i++) {
                        Collections.swap(diskMap, indexFirstNull + i, indexLastFile + i);
                    }
                } else {
                    indexLastFile--;
                }
            }
            System.out.println("Premier null : " + indexFirstNull);
            System.out.println("Dernier fichier : " + indexLastFile);

        }
        index = 0;
        long total = 0;
        while (index < diskMap.size()){
            if (diskMap.get(index) != null) {
                total += diskMap.get(index) * index;
            }
            index++;
        }
        System.out.println(diskMap);
        System.out.println(total);
    }
}
