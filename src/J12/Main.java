package J12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<List<CharBool>> data = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J12/entree.txt"));
        int total = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            data.add(line.chars().mapToObj(c -> new CharBool((char) c,false)).collect(Collectors.toList()));
        }
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(0).size(); j++) {
                if (data.get(i).get(j).isUtilise() == false){
                    int area = 0;
                    int perimeter = 0;
                    int[] result = chercheAutour(i,j, area, perimeter);
                    total += result[0] * result[1];
                }
            }
        }
        System.out.println(total);
    }

    public static int[] chercheAutour(int i, int j, int area, int perimeter){
        int perimeterOfCase = 4;
        data.get(i).get(j).setUtilise(true);
        if (i > 0){
            if (data.get(i).get(j).getCaractere() == data.get(i-1).get(j).getCaractere()) {
                perimeterOfCase--;
                if (data.get(i-1).get(j).isUtilise() == false) {
                    int[] result = chercheAutour(i - 1, j, area, perimeter);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (i < data.size()-1){
            if (data.get(i).get(j).getCaractere() == data.get(i+1).get(j).getCaractere()) {
                perimeterOfCase--;
                if (data.get(i+1).get(j).isUtilise() == false) {
                    int[] result = chercheAutour(i + 1, j, area, perimeter);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (j > 0){
            if (data.get(i).get(j).getCaractere() == data.get(i).get(j-1).getCaractere()) {
                perimeterOfCase--;
                if (data.get(i).get(j-1).isUtilise() == false) {
                    int[] result = chercheAutour(i, j-1, area, perimeter);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        if (j < data.get(0).size()-1){
            if (data.get(i).get(j).getCaractere() == data.get(i).get(j+1).getCaractere()) {
                perimeterOfCase--;
                if (data.get(i).get(j+1).isUtilise() == false) {
                    int[] result = chercheAutour(i, j + 1, area, perimeter);
                    area = result[0];
                    perimeter = result[1];
                }
            }
        }
        return new int[]{area+1,perimeter+perimeterOfCase};
    }
}
