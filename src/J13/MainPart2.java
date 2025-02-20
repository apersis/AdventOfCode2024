package J13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainPart2 {
    public static void main(String[] args) throws FileNotFoundException {
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
                    prizeX.add(x+10000000000000L);
                    prizeY.add(y+10000000000000L);
                }
            }
            index++;
        }
        int total = 0;
        for (int i = 0; i < btnAX.size(); i++) {
            long countBtnA = 1;
            long countBtnB = 0;
            List<Long> lstPrix = new ArrayList<>();
            boolean firstPhase = true;
            while (countBtnA > 0){
                if (btnAX.get(i)*countBtnA+btnBX.get(i)*countBtnB == prizeX.get(i) && btnAY.get(i)*countBtnA+btnBY.get(i)*countBtnB == prizeY.get(i)){
                    lstPrix.add(countBtnA*3+countBtnB);
                    firstPhase = false;
                    countBtnA/=2;
                    countBtnA =+ countBtnA/2;
                }else{
                    if (btnAX.get(i)*countBtnA+btnBX.get(i)*countBtnB <= prizeX.get(i)){
                        if(firstPhase) {
                            countBtnA*=2;
                        }else{
                            countBtnB*=2;
                        }
                    }else{
                        firstPhase = false;
                        countBtnA/=2;
                        countBtnA =+ countBtnA/2;
                    }
                }
            }
            total += lstPrix.stream().min(Long::compareTo).orElse(0L);
            System.out.println(i);
            System.out.println(total);
        }
        System.out.println(total);
    }
}
