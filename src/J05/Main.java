package J05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/J05/entree.txt"));
        boolean part1 = true;
        List<Paire> regles = new ArrayList<>();
        int total = 0;
        int totalPart2 = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.isEmpty()){
                part1 = false;
            }
            else if(part1){
                String premier = line.substring(0,2);
                String deuxieme = line.substring(3);
                Paire regle = new Paire();
                regle.setAvant(Integer.parseInt(premier));
                regle.setApres(Integer.parseInt(deuxieme));
                regles.add(regle);
            }else{
                List<String> strUpdate = Arrays.stream(line.split(",")).toList();
                List<Integer> update = new ArrayList<>();
                update.addAll(strUpdate.stream().map(Integer::parseInt).toList());
                boolean isLineGood = true;
                for (int i = 0; i < update.size()-1; i++) {
                    int premier = update.get(i);
                    for (int j = i+1; j < update.size(); j++) {
                        int deuxieme = update.get(j);
                        int k = 0;
                        while (regles.get(k).getPaireIfMatch(premier, deuxieme) == null) {
                            k++;
                        }
                        if (k != regles.size()) {
                            Paire regle = (regles.get(k).getPaireIfMatch(premier, deuxieme));
                            if (premier != regle.avant || deuxieme != regle.apres) {
                                isLineGood = false;
                                Collections.swap(update,i,j);
                                i = -1;
                                j = update.size();
                            }
                        }
                    }
                }
                if (isLineGood){
                    int indexmoitie = (update.size() / 2);
                    total = total + update.get(indexmoitie);
                }else{
                    int indexmoitie = (update.size() / 2);
                    totalPart2 = totalPart2 + update.get(indexmoitie);
                }
            }
        }
        System.out.println(total);
        System.out.println(totalPart2);
    }
}
