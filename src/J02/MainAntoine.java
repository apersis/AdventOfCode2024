package J02;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainAntoine {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Scanner scanner = new Scanner(new File("src/J02/entree.txt"));
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        int sumSafe=0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            List<Integer> liste0 = Arrays.stream(line.split(" ")).map(el->Integer.parseInt(el)).toList();
            List<Integer> liste = new ArrayList<>();
            liste.addAll(liste0);
            System.out.println(liste);
            int toAdd = tryWithoutSmth(liste, true);
            System.out.println(toAdd);
            sumSafe+=toAdd;
            System.out.println(sumSafe);

        }

        System.out.println(sumSafe);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Temps d'exÃ©cution : " + executionTime + " millisecondes");

    }

    public static int tryWithoutSmth(List<Integer> liste,boolean firstReplace){
        boolean oldBool =true;
        boolean increase = true;
        for (int i = 0; i < liste.size()-1; i++) {
            int newValue = liste.get(i) - liste.get(i+1);
            increase = Math.signum(newValue) ==1;
            if(i!=0 && oldBool != increase){
                if(firstReplace){
                    if(i==1){
                        int newValueB = liste.get(i+1) - liste.get(i+2);
                        boolean increaseB = Math.signum(newValueB) ==1;
                        if(increaseB == increase){
                            liste.remove(0);
                        }else{
                            liste.remove(i+1);
                        }

                    }
                    liste.remove(i+1);
                    return tryWithoutSmth(liste,false);
                }else{
                    return 0;
                }
            }
            if(Math.abs(newValue)>3 || newValue ==0){
                if(firstReplace){
                    if(i==0 && Math.abs(liste.get(i+1)-liste.get(i+2))<=3){
                        liste.remove(i);
                    }
                    liste.remove(i+1);
                    return tryWithoutSmth(liste,false);
                }else{
                    return 0;
                }
            }

            oldBool = increase;

        }
        return 1;
    }
}
