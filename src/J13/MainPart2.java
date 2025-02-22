package J13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("src/J13/entree.txt"));
        List<Long> btnAX = new ArrayList<>();
        List<Long> btnAY = new ArrayList<>();
        List<Long> btnBX = new ArrayList<>();
        List<Long> btnBY = new ArrayList<>();
        List<Long> prizeX = new ArrayList<>();
        List<Long> prizeY = new ArrayList<>();
        int index = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (index % 4 != 3){
                List<String> splittedLine = Arrays.stream(line.split("[^0-9*]")).filter(x -> !x.isEmpty()).toList();
                long x = Integer.parseInt(splittedLine.get(0));
                long y = Integer.parseInt(splittedLine.get(1));
                if (index % 4 == 0) {
                    btnAX.add(x);
                    btnAY.add(y);
                } else if (index % 4 == 1) {
                    btnBX.add(x);
                    btnBY.add(y);
                } else if (index % 4 == 2) {
                    long myPrizeX = x;
                    long myPrizeY = y;
                    myPrizeX += 10000000000000L;
                    myPrizeY += 10000000000000L;
                    prizeX.add(myPrizeX);
                    prizeY.add(myPrizeY);
                }
            }
            index++;
        }
        long total = 0;
        for (int i = 0; i < btnAX.size(); i++) {
            if (btnAX.get(i) * btnAY.get(i) > btnBX.get(i) * btnBY.get(i) * 3){
                long nbrA = prizeX.get(i) / btnAX.get(i);
                long reste = prizeX.get(i) % btnAX.get(i);
                while (reste % btnBX.get(i) != 0 && nbrA >=0){
                        nbrA--;
                        reste += btnAX.get(i);
                }
                long nbrB = reste / btnBX.get(i);
                while ((nbrA * btnAX.get(i) + nbrB * btnBX.get(i) != prizeX.get(i)
                        || nbrA * btnAY.get(i) + nbrB * btnBY.get(i) != prizeY.get(i))
                        && nbrA >= 0){
                    nbrA--;
                    reste += btnAX.get(i);
                    while (reste % btnBX.get(i) != 0){
                        nbrA--;
                        reste += btnAX.get(i);
                    }
                    nbrB = reste / btnBX.get(i);
                }
                if (nbrA >= 0) {
                    total += nbrA * 3 + nbrB;
                }
            }else{
                long nbrB = prizeX.get(i) / btnBX.get(i);
                long reste = prizeX.get(i) % btnBX.get(i);
                while (reste % btnAX.get(i) != 0 && nbrB >=0){
                    nbrB--;
                    reste += btnBX.get(i);
                }
                long nbrA = reste / btnAX.get(i);
                while ((nbrA * btnAX.get(i) + nbrB * btnBX.get(i) != prizeX.get(i)
                        || nbrA * btnAY.get(i) + nbrB * btnBY.get(i) != prizeY.get(i))
                        && nbrB >= 0){
                    nbrB--;
                    reste += btnBX.get(i);
                    while (reste % btnAX.get(i) != 0){
                        nbrB--;
                        reste += btnBX.get(i);
                    }
                    nbrA = reste / btnAX.get(i);
                }
                if (nbrB >= 0) {
                    total += nbrA * 3 + nbrB;
                }
            }
            System.out.println(i);
            System.out.println(total);
        }
        System.out.println(total);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Temps d'execution : " + executionTime + " ms");
    }
}