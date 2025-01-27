import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> maListe = new ArrayList<>();
        maListe.add(7);
        maListe.add(1);
        maListe.add(0);
        maListe.add(2);
        maListe.add(10);
        maListe.add(-3);
        System.out.println(maListe);
        //maListe = maListe.stream().map(x -> (int)(Math.pow(x,2))).collect(Collectors.toList());
        //System.out.println();
        //System.out.println(maListe.stream().reduce((a,b) -> a+b ));
        maListe.set(2, 999);
        System.out.println(maListe);
    }
}