package J11;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SavePart1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner("5178527 8525 22 376299 3 69312 0 275");
        List<Long> sortie = new ArrayList<>();
        while (scanner.hasNext()){
            sortie.add(scanner.nextLong());
        }
        System.out.println(sortie);
        for (int i = 0; i < 75; i++) {
            for (int j = 0; j < sortie.size(); j++) {
                Long nombreDeBase = sortie.get(j);
                int nbrChiffre = 1;
                long nombre = nombreDeBase;
                while(nombre/10 >= 1){
                    nombre /= 10;
                    nbrChiffre++;
                }
                if(nombreDeBase == 0){
                    sortie.set(j,Long.parseLong("1"));
                }else if(nbrChiffre % 2 == 0){
                    String strNombre = nombreDeBase.toString();
                    sortie.set(j, Long.parseLong(strNombre.substring(0,nbrChiffre/2)));
                    sortie.add(j+1, Long.parseLong(strNombre.substring(nbrChiffre/2, nbrChiffre)));
                    j++;
                }else{
                    sortie.set(j, sortie.get(j)*2024);
                }
            }
            System.out.println(i + " : " + sortie.size());
        }
        System.out.println("fin : " + sortie.size());
    }
}
