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
        int indexFirstNull = 0;
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
        }
        index = 0;
        long total = 0;
        while (diskMap.get(index) != null){
            total += diskMap.get(index) * index;
            index++;
        }
        System.out.println(diskMap);
        System.out.println(total);
    }
}
