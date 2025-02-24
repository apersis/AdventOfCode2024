package J13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainPart2Again {
    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(new File("src/J13/entree.txt"));
        List<Long> btnAX = new ArrayList<>();
        List<Long> btnAY = new ArrayList<>();
        List<Long> btnBX = new ArrayList<>();
        List<Long> btnBY = new ArrayList<>();
        List<Long> prizeX = new ArrayList<>();
        List<Long> prizeY = new ArrayList<>();
        int index = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (index % 4 != 3) {
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
            long yb = btnBY.get(i);
            long ya = btnAY.get(i);
            long xb = btnBX.get(i);
            long xa = btnAX.get(i);
            long yp = prizeY.get(i);
            long xp = prizeX.get(i);
            long a = (yb * xp - xb * yp)/(xa*yb-xb*ya);
            long b = (xp-a*xa)/xb;
            System.out.println("a : " + a + " b : " + b);
            System.out.println(a*xa+b*xb + " = " + xp);
            System.out.println(a*ya+b*yb + " = " + yp);
            if (a*xa+b*xb==xp&&a*ya+b*yb==yp){
                total+= a*3 + b;
            }
        }
        System.out.println(total);
    }
}
