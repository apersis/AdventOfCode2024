package J11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Long[]> sortieChanging = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner("5178527 8525 22 376299 3 69312 0 275");
        List<Long[]> sortie = new ArrayList<>();
        while (scanner.hasNext()){
            Long[] nombre = {1L,scanner.nextLong()};
            sortie.add(nombre);
        }
        for (int i = 0; i < 75; i++) {
            sortieChanging = new ArrayList<>();
            for (int j = 0; j < sortie.size(); j++) {
                Long nombreDeBase = sortie.get(j)[1];
                Long nombreDOccurence = sortie.get(j)[0];
                int nbrChiffre = 1;
                long nombre = nombreDeBase;
                while(nombre/10 >= 1){
                    nombre /= 10;
                    nbrChiffre++;
                }
                if(nombreDeBase == 0){
//                    int indexNbr = indexOf(sortieChanging,nombreDeBase);
//                    if (indexNbr == -1) {
                        //sortieChanging.add(new Long[]{nombreDOccurence, 1L});
//                    }else{
//                        Long[] beforeChange = sortieChanging.get(indexNbr);
//                        sortieChanging.set(indexNbr, new Long[]{nombreDOccurence + beforeChange[0],beforeChange[1]});
//                    }
                    updateSortieChanging(1,nombreDOccurence);

                }else if(nbrChiffre % 2 == 0){
                    String strNombre = nombreDeBase.toString();
                    long nbr1 = Long.parseLong(strNombre.substring(0,nbrChiffre/2));
                    long nbr2 = Long.parseLong(strNombre.substring(nbrChiffre/2, nbrChiffre));
                    /*int indexNbr1 = indexOf(sortieChanging,nbr1);
                    if (indexNbr1 == -1) {*/
                        //sortieChanging.add(new Long[]{nombreDOccurence, nbr1});
                    /*}else{
                        Long[] beforeChange = sortieChanging.get(indexNbr1);
                        sortieChanging.set(indexNbr1, new Long[]{nombreDOccurence + beforeChange[0],beforeChange[1]});
                    }
                    int indexNbr2 = indexOf(sortieChanging,nbr2);
                    if (indexNbr2 == -1) {*/
                        //sortieChanging.add(new Long[]{nombreDOccurence, nbr2});
                    /*}else{
                        Long[] beforeChange = sortieChanging.get(indexNbr2);
                        sortieChanging.set(indexNbr2, new Long[]{nombreDOccurence + beforeChange[0],beforeChange[1]});
                    }*/
                    updateSortieChanging(nbr1,nombreDOccurence);
                    updateSortieChanging(nbr2,nombreDOccurence);

                }else{
                    /*int indexNbr = indexOf(sortieChanging,nombreDeBase);
                    if (indexNbr == -1) {*/
//                        sortieChanging.add(new Long[]{nombreDOccurence, nombreDeBase * 2024});
                    /*}else{
                        Long[] beforeChange = sortieChanging.get(indexNbr);
                        sortieChanging.set(indexNbr, new Long[]{nombreDOccurence + beforeChange[0],beforeChange[1]});
                    }*/
                    updateSortieChanging(nombreDeBase * 2024,nombreDOccurence);
                }
            }
            sortie = sortieChanging;
            long totalLen = 0;
            for(Long[] maSortie : sortie){
                totalLen += maSortie[0];
            }
//            sortie.stream().map(x -> x[1]).forEach(x -> System.out.printf(x + " "));
//            System.out.println();
//            System.out.println(i + " : " + totalLen);
        }
        long totalLen = 0;
        for(Long[] maSortie : sortie){
            totalLen += maSortie[0];
        }
        System.out.println(totalLen);
    }
    public static int indexOf(List<Long[]> liste, Long chiffre){
        int index = 0;
        for (Long[] tableau : liste) {
            if (tableau[1].equals(chiffre)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void updateSortieChanging(long nombreEnSortie, long nombreDOccurence){
        int indexNbr = indexOf(sortieChanging,nombreEnSortie);
        if (indexNbr == -1) {
            sortieChanging.add(new Long[]{nombreDOccurence, nombreEnSortie});
        }else{
            Long[] beforeChange = sortieChanging.get(indexNbr);
            sortieChanging.set(indexNbr, new Long[]{nombreDOccurence + beforeChange[0],beforeChange[1]});
        }
    }
}
